import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TServer {
    public static List<Socket> onlinesocket =new ArrayList<>();
    public static void main(String[] args) throws Exception{
        ServerSocket Serversocket=new ServerSocket(6666);
        while (true) {
            Socket socket = Serversocket.accept();
            onlinesocket.add(socket);
            new ServerThread(socket).start();

        }
    }
}
