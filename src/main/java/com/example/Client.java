package com.example;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class Client {
    public static void main(String[] args)throws Exception {
        Scanner sc=new Scanner(System.in);
        DatagramSocket socket =new DatagramSocket();
        while (true) {
            String s = sc.nextLine();
            if(s.equals("7355608"))
            {
                System.out.println("communication is over");
                socket.close();
                break;
            }
            byte[] bytes = s.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 6666);
            socket.send(packet);
        }


    }
}
