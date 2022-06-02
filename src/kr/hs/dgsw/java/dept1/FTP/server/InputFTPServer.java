package kr.hs.dgsw.java.dept1.FTP.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class InputFTPServer {

    private DataInputStream dis;

    public InputFTPServer(Socket socket) {
        try {
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            dis = new DataInputStream(bis);
        } catch (IOException e) {
        }
    }

    public String getMessage() {
        try {
            return dis.readUTF();
        }catch (IOException e){
        }
        return null;
    }

    public int getBytes (byte[] bytes) {
        try {
            return dis.read(bytes);
        } catch (IOException e) {
        }
        return 0;
    }

}
