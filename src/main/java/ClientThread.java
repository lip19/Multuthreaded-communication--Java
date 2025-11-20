import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run(){
        InputStream is = null;
        try {
            is = socket.getInputStream();
        } catch (IOException e) {

        }
        DataInputStream dis = new DataInputStream(is);
        while (true) {
            try {
                String rs = dis.readUTF();
                System.out.println(rs + ' ' + "by: " + socket.getRemoteSocketAddress());

            } catch (Exception e) {
                try {
                    dis.close();
                    socket.close();
                    break;
                } catch (Exception ex) {

                }


            }


        }


    }
}
