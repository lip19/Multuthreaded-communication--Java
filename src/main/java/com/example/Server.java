package com.example;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Server
{
    public static void main(String[] args) throws Exception{
        DatagramSocket socket=new DatagramSocket(6666);
        byte[] buff=new byte[1024*64];
            DatagramPacket packet=new DatagramPacket(buff,buff.length);
            int count=0;
        while (true) {
    socket.receive(packet);
    int len = packet.getLength();
    String s = new String(buff, 0, len);
    System.out.println(s);
    if(count==0) {
        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(packet.getPort());
    }
            count++;

        }
    }
}
