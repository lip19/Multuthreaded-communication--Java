import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;

public class TServer {
    public static void main(String[] args) throws Exception{
        ServerSocket Serversocket=new ServerSocket(6666);
        Socket socket=Serversocket.accept() ;
        InputStream is=socket.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        while (true) {
            try {
                String rs = dis.readUTF();
                System.out.println(rs);
            } catch (Exception e) {
                System.out.println(socket.getRemoteSocketAddress()+"over");
                dis.close();
                socket.close();
                break;
            }


        }
    }
}
