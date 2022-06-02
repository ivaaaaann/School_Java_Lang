package kr.hs.dgsw.java.dept1.FTP.client;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class InputFTPClient {

    public DataInputStream dis;

    public InputFTPClient(Socket socket) {
        try {
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            dis = new DataInputStream(bis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMessage() {
        try {
            return  dis.readUTF();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public int getBytes (byte[] bytes) {
        try {
            return dis.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
