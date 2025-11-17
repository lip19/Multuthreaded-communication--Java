import java.net.InetAddress;

public class mtc {
    public static void main (String[] args )throws Exception {
        InetAddress ip1=InetAddress.getLocalHost();
        System.out.println(ip1.getAddress());


    }
}

