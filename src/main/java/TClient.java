import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.Socket;
import java.util.Scanner;

public class TClient {
    public static void main(String[] args)throws Exception {
        Socket socket=new Socket("127.0.0.1",6666);
        OutputStream os=socket.getOutputStream();
        DataOutputStream dos=new DataOutputStream(os);
        Scanner sc=new Scanner(System.in);

        while (true) {
            String msg=sc.nextLine();
            if (msg.equals("7355608")) {
                System.out.println("over");
                dos.close();
                sc.close();
                socket.close();
                break;
            }
            dos.writeUTF(msg);
            dos.flush();
        }
    }
}
