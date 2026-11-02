//RPCClient.java
//2B - A program to implement simple calculator operations like addition, subtraction, multiplication and division.
import java.io.*;
import java.net.*;

class RPCClient {
    RPCClient() {
        try {
            InetAddress ia = InetAddress.getLocalHost();

            DatagramSocket ds = new DatagramSocket();
            DatagramSocket ds1 = new DatagramSocket(1300);

            System.out.println("\nRPC Client\n");
            System.out.println("Enter method name and parameters like: add 3 4");
            System.out.println("Type q to quit.\n");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String str = br.readLine();

                if (str.equalsIgnoreCase("q")) 
		{
                    byte b[] = str.getBytes();

                    DatagramPacket dp = new DatagramPacket(b, b.length, ia, 1200);

                    ds.send(dp);
                    break;
                }

                byte b[] = str.getBytes();

                DatagramPacket dp = new DatagramPacket(b, b.length, ia, 1200);

                ds.send(dp);

                byte b1[] = new byte[4096];

                DatagramPacket dp1 = new DatagramPacket(b1, b1.length);

                ds1.receive(dp1);

                String s = new String(dp1.getData(), 0, dp1.getLength());

                System.out.println("\nResult = " + s + "\n");
            }

            ds.close();
            ds1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        new RPCClient();
    }
}
