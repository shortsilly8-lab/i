//BroadcastClient.java
//3 Multicast Socket example 
import java.net.*;
import java.io.*;
public class BroadcastClient {
    public static final int PORT = 1234;
    public static void main(String args[]) throws Exception {
        MulticastSocket socket;
        DatagramPacket packet;
        InetAddress address;

        // Set the multicast address
        address = InetAddress.getByName("239.1.2.3");
        socket = new MulticastSocket(PORT);

        // Join the multicast group
        socket.joinGroup(address);
        byte[] data = new byte[1024];
        packet = new DatagramPacket(data, data.length);
        for (;;) {
            // Receive the packets
            socket.receive(packet);
            String str = new String(packet.getData(), 0,packet.getLength());
            System.out.println("Message received from "+ packet.getAddress());
            System.out.println("Message is : " + str);
        }
    }
}
