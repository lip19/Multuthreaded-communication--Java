import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("new connection" + socket.getRemoteSocketAddress());
        InputStream is = null;
        try {
            is = socket.getInputStream();
        } catch (IOException e) {

        }
        DataInputStream dis = new DataInputStream(is);
        while (true) {
            try {
                String rs = null;
                try {
                    rs = dis.readUTF();
                } catch (Exception e) {
                    TServer.onlinesocket.remove(socket);
                    dis.close();
                    socket.close();
                    break;
                }
                System.out.println(rs + ' ' + "by: " + socket.getRemoteSocketAddress());
                sendmsgtoall(rs);
            } catch (Exception e) {

            }


        }

    }

    private void sendmsgtoall(String rs) {
        for (Socket onlinesocket : TServer.onlinesocket) {
            OutputStream os = null;
            try {
                os = onlinesocket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF(rs);
                dos.flush();
            } catch (Exception e) {

            }
        }
    }
}

