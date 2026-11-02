//BroadcastServer.java 
//3 Multicast Socket example
import java.net.*;
import java.io.*;
import java.util.*;

public class BroadcastServer {

    public static final int PORT = 1234;

    public static void main(String args[]) throws Exception {
        MulticastSocket socket;
        DatagramPacket packet;
        InetAddress address;

        // Set the multicast address
        address = InetAddress.getByName("239.1.2.3");
        socket = new MulticastSocket();

        // Join the multicast group
        socket.joinGroup(address);

        byte[] data;

        for (;;) {
            Thread.sleep(10000);

            System.out.println("Sending");

            String str = "This is Sam Calling";
            data = str.getBytes();

            packet = new DatagramPacket(data, data.length, address, PORT);

            // Send the packet
            socket.send(packet);
        }
    }
}
