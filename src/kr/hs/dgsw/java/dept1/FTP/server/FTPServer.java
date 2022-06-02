package kr.hs.dgsw.java.dept1.FTP.server;

import kr.hs.dgsw.java.dept1.FTP.common.CommonFuntions;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FTPServer extends Thread{

    private Socket sc;
    private static String id = "ldh3907";
    private static String pass = "qwer";
    private String fileFolder = "C:\\Users\\DGSW\\IdeaProjects\\jsp-work2022\\FTP\\src\\files\\";
    private  OutputFTPServer os;
    private  InputFTPServer is;
    private CommonFuntions cf;

    public FTPServer(Socket sc, CommonFuntions cf) throws IOException {
        this.sc =sc;
        this.cf = cf;
    }


    public void checkLoginInfo () {
        String id = "";
        String pass = "";


        while(true) {
            id =  is.getMessage();
            pass = is.getMessage();

            if(id.equals(this.id) && pass.equals(this.pass)){
                os.sendMessage("true");
                break;
            }
            else {
                os.sendMessage("false");
            }
        }
    }

    public String fileSizeTransform (long fileSize) {
        String Byte = "B";

        if(fileSize > 1024) {
            fileSize /= 1024;
            Byte = "KB";
        }
        if(fileSize > 1024) {
            fileSize /= 1024;
            Byte = "MB";
        }
        if(fileSize > 1024) {
            fileSize /= 1024;
            Byte = "GB";
        }
        return fileSize + Byte;

    }

    public void fileList() {
        File dir = new File(this.fileFolder);
        File[] files = dir.listFiles();

        int fileListLength = files.length;

        os.sendMessage(fileListLength+"");
        if(fileListLength != 0) {
            for(File file : files) {
                String fileSize = fileSizeTransform(file.length());
                os.sendMessage("** " + file.getName() + " " + fileSize + " **");
            }
        }
        String fileListLengthMsg = "** "+fileListLength+"개 "+"파일 "+"**";
        os.sendMessage(fileListLengthMsg);
    }

    public void fileUpload() {
        String fileName =  is.getMessage();

        boolean fileExist = cf.fileExistCheck(fileFolder + fileName);
        FileOutputStream fos =null;
        try {
            fos = new FileOutputStream(fileFolder + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(fileExist) {
            os.sendMessage("exist");

            boolean isOverwrite = is.getMessage().equals("overwrite");

            if(isOverwrite) {

                int clientFileSize = Integer.parseInt(is.getMessage());
                int readSize = 0;
                int totalReadSize = 0;
                byte[] bytes = new byte[1024];

                while(totalReadSize < clientFileSize) {
                    try {
                        readSize = is.getBytes(bytes);

                        fos.write(bytes, 0, readSize);
                        totalReadSize += readSize;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }



                boolean fileExist2 = cf.fileExistCheck(fileFolder + fileName);
                if(fileExist2) {
                    os.sendMessage("exist");
                }
                else {
                    os.sendMessage("notExist");
                }
            }
        }
        else {
            os.sendMessage("notExist");



            int clientFileSize = Integer.parseInt(is.getMessage());
            int readSize = 0;
            int totalReadSize = 0;
            byte[] bytes = new byte[1024];

            while(totalReadSize < clientFileSize) {
                try {
                    readSize = is.getBytes(bytes);
                    fos.write(bytes, 0, readSize);
                    totalReadSize += readSize;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            boolean fileExist2 = cf.fileExistCheck(fileFolder + fileName);
            if(fileExist2) {
                os.sendMessage("exist");
            }
            else {
                os.sendMessage("notExist");
            }
        }
    }

    public void fileUploadWithName() {
        String fileName = is.getMessage();
        boolean fileExist = cf.fileExistCheck(fileFolder + fileName);
        FileOutputStream fos =null;
        try {
            fos = new FileOutputStream(fileFolder + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(fileExist) {
            os.sendMessage("exist");
        }
        else {
            os.sendMessage("notExist");
            int clientFileSize = Integer.parseInt(is.getMessage());
            int readSize = 0;
            int totalReadSize = 0;
            byte[] bytes = new byte[1024];

            while(totalReadSize < clientFileSize) {
                try {
                    readSize = is.getBytes(bytes);

                    fos.write(bytes, 0, readSize);
                    totalReadSize += readSize;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



            boolean fileExist2 = cf.fileExistCheck(fileFolder + fileName);
            if(fileExist2) {
                os.sendMessage("exist");
            }
            else {
                os.sendMessage("notExist");
            }

        }
    }

    public void download() {
        String fileName =  is.getMessage();
        File dir = new File(this.fileFolder);
        File[] files = dir.listFiles();
        File file = null;
        FileInputStream fis = null;

        for(File serverFile : files) {
            if(serverFile.getName().equals(fileName)){
                file = new File(serverFile.getAbsolutePath());
            }
        }

        if(file == null) {
            os.sendMessage("notExist");
        }
        else  {
            try {
                fis = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            os.sendMessage("exist");
            int readSize = 0;
            byte[]  bytes = new byte[1024];

            os.sendMessage(file.length()+"");

            while(true) {
                try {
                    if (!((readSize = fis.read(bytes)) != -1)) break;
                    os.sendFileMessage(bytes, 0, readSize);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public void commandExecute() throws Exception{
        String msg = is.getMessage();
        switch (msg){
            //파일 목록
            case "1":
                fileList();
                break;

            //업로드
            case "2":
                fileUpload();
                break;

            //업로드 이름 지정
            case "3":
                fileUploadWithName();
                break;

            //다운로드
            case "4":
                download();
                break;

            //접속종료

        }
    }

    public void execute (Socket socket) {
        os = new OutputFTPServer(socket);
        is = new InputFTPServer(socket);

        checkLoginInfo();
        while (true) {
            try {
                commandExecute();
            } catch (Exception e) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        ServerSocket ss;
        {
            try {
                    ss = new ServerSocket(5000);
                while (true) {
                    Socket socket = ss.accept();
                    CommonFuntions cf = new CommonFuntions();

                    FTPServer server = new FTPServer(socket, cf);
                    server.start();
                }
            } catch (IOException e) {
            }
        }
    }

    @Override
    public void run() {
        execute(this.sc);
    }
}
