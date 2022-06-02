package kr.hs.dgsw.java.dept1.FTP.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import kr.hs.dgsw.java.dept1.FTP.common.CommonFuntions;

public class FTPClient {


    private Socket sc;
    private Scanner scanner = new Scanner(System.in);
    private OutputFTPClient oc;
    private InputFTPClient ic;
    private String fileFolder = "C:\\Users\\DGSW\\IdeaProjects\\jsp-work2022\\FTP\\src\\clientFiles\\";
    private CommonFuntions cf;

    public FTPClient(Socket sc, CommonFuntions cf) throws IOException {
        this.sc = sc;
        this.cf = cf;
    }


    public void login () {
        System.out.print("ID : ");
        String id = scanner.nextLine();
        System.out.print("PASS : ");
        String pass = scanner.nextLine();
        oc.sendMessage(id);
        oc.sendMessage(pass);
    }

    public boolean loginCheck () {
        boolean serverLoginCheckResponse = ic.getMessage().equals("true");
        return serverLoginCheckResponse;
    }

    public void execute(Socket socket){
        oc = new OutputFTPClient(socket);
        ic = new InputFTPClient(socket);

        
        System.out.println("** 서버에 접속하였습니다 **");
        while (true) {
            login();
            if(loginCheck()){
                System.out.println("FTP 서버에 접속하였습니다.");
            }else {
                System.out.println("ID 또는 PASS가 틀렸습니다!");
                continue;
            }

            while(true) {
                String command = scanner.nextLine();
                try {
                    checkCommandAndExecute(command);
                } catch (Exception e) {
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("** 서버에서 퇴장하였습니다 **");
                    break;
                }
            }
            break;
        }
    }

    public void fileList() {
        System.out.println("** File List **");
        int fileListLength =  Integer.parseInt(ic.getMessage());
        if(fileListLength != 0) {
            for(int i = 0; i<fileListLength; i++) {
                System.out.println(ic.getMessage());
            }
        }
        System.out.println(ic.getMessage());
    }
    public void fileUpload(String address) {
        File file = new File(address);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        oc.sendMessage(file.getName());
        boolean fileExist = cf.fileResponseExistCheck(ic.getMessage());

            if (fileExist) {
                boolean isOverwrite;
                while(true) {
                    System.out.println("파일이 이미 있습니다. 덮어쓰기 하실건가요?(Yes: 덮어쓰기 / No: 업로드 취소):");
                    String command = scanner.next();
                    if(command.equals("Yes") || command.equals("yes") || command.equals("No") || command.equals("no")) {
                        isOverwrite = command.equals("Yes") || command.equals("yes");
                        break;
                    }
                    else {
                        System.out.println("Yes 또는 No 로 입력해주세요.");
                    }
                }

            if(isOverwrite) {
                oc.sendMessage("overwrite");
                int readSize = 0;
                byte[] bytes = new byte[1024];

                oc.sendMessage(file.length()+"");

                while(true) {
                    try {
                        if (!((readSize = fis.read(bytes)) != -1)) break;
                        oc.sendFileMessage(bytes, 0, readSize);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                boolean fileExist2 = cf.fileResponseExistCheck(ic.getMessage());

                if(fileExist2) {
                    System.out.println("** "+file.getName() + " 파일을 업로드 하였습니다. **");
                }
                else {
                    System.out.println("** 파일 업로드를 실패했습니다 **");
                }
            }
            else {
                oc.sendMessage("notOverwrite");
            }
        }else {
            int readSize = 0;
            byte[] bytes = new byte[1024];

            oc.sendMessage(file.length()+"");

            while(true) {
                try {
                    if (!((readSize = fis.read(bytes)) != -1)) break;
                    oc.sendFileMessage(bytes, 0, readSize);
                 } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            boolean fileExist2 = cf.fileResponseExistCheck(ic.getMessage());

            if(fileExist2) {
                System.out.println("** "+file.getName() + " 파일을 업로드 하였습니다. **");
            }
            else {
                System.out.println("** 파일 업로드를 실패했습니다 **");
            }

        }



    }

    public void fileUploadWithName(String address, String name) {
        File file = new File(address);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        oc.sendMessage(name);
        boolean fileExist = cf.fileResponseExistCheck(ic.getMessage());

        if(fileExist) {
            System.out.println("파일이 이미 있습니다.");
        }
        else {
            int readSize = 0;
            byte[] bytes = new byte[1024];

            oc.sendMessage(file.length()+"");

            while(true) {
                try {
                    if (!((readSize = fis.read(bytes)) != -1)) break;
                    oc.sendFileMessage(bytes, 0, readSize);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            boolean fileExist2 = cf.fileResponseExistCheck(ic.getMessage());

            if(fileExist2) {
                System.out.println("** "+file.getName() + " 파일을 업로드 하였습니다. **");
            }
            else {
                System.out.println("** 파일 업로드를 실패했습니다 **");
            }
        }
    }

    public void download(String name) {
        oc.sendMessage(name);

        FileOutputStream fos =null;

        boolean exist = cf.fileResponseExistCheck(ic.getMessage());
        if(exist) {
            try {
                fos = new FileOutputStream(fileFolder + name);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int clientFileSize = Integer.parseInt(ic.getMessage());
            int readSize = 0;
            int totalReadSize = 0;
            byte[] bytes = new byte[1024];

            while(totalReadSize < clientFileSize) {
                try {
                    readSize = ic.getBytes(bytes);

                    fos.write(bytes, 0, readSize);
                    totalReadSize += readSize;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            boolean exist2 = new File(fileFolder + name).exists();
            if(exist2) {
                String downloadMessage = "** " + name + "을 " + fileFolder + "로 다운로드 하였습니다. **";
                System.out.println(downloadMessage);
            }
            else {
                System.out.println("다운로드에 실패하였습니다.");
            }

        }else {
            System.out.println("해당 파일이 존재하지 않습니다.");
        }
    }

    public  void exit() throws Exception {
        boolean isExit =  ic.getMessage().equals("exit");
        if(isExit){
          System.out.println("서버가 종료되었습니다.");
          throw new Exception();
        }
    }

    private void checkCommandAndExecute(String command) throws Exception {

             if(command.startsWith("/파일목록")){
                 oc.sendMessage("1");
                 fileList();
             }

             else if(command.startsWith("/업로드")){
                 String[] commands = command.split(" ");
                 if(commands.length == 2){
                     oc.sendMessage("2");
                     fileUpload(commands[1]);
                 }
                 else if(commands.length == 3) {
                     oc.sendMessage("3");
                     fileUploadWithName(commands[1], commands[2]);
                 }
             }

             else if(command.startsWith("/다운로드")){
                 String[] commands = command.split(" ");
                oc.sendMessage("4");
                download(commands[1]);
             }

             else if(command.startsWith("/접속종료")){
                 throw new Exception();
             }

    }


    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            CommonFuntions cf = new CommonFuntions();
            FTPClient client = new FTPClient(socket, cf);
            client.execute(socket);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
