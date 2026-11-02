//tcpServerPrime.java 
// 1A - A client server-based program using TCP to find if the number entered is prime. 
import java.net.*;
import java.io.*;
class tcpServerPrime {
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(8001);
            System.out.println("Server Started");

            Socket s = ss.accept();

            DataInputStream in = new DataInputStream(s.getInputStream());

            int x = in.readInt();

            DataOutputStream otc = new DataOutputStream(s.getOutputStream());

            int y = x / 2;
            boolean prime = true;

            if (x <= 1) {
                prime = false;
            } else {
                for (int i = 2; i <= y; i++) {
                    if (x % i == 0) {
                        prime = false;
                        break;
                    }
                }
            }

            if (prime) {
                otc.writeUTF(x + " is Prime");
            } else {
                otc.writeUTF(x + " is not Prime");
            }

            in.close();
            otc.close();
            s.close();
            ss.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
