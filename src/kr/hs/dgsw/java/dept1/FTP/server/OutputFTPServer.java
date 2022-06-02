package kr.hs.dgsw.java.dept1.FTP.server;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class OutputFTPServer {

    private DataOutputStream dos;

    public OutputFTPServer(Socket socket) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            dos = new DataOutputStream(bos);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendFileMessage(byte[] bytes, int i, int readSize) {
        try {
            dos.write(bytes, 0, readSize);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}