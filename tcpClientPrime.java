//tcpClientPrime.java
// 1A - A client server-based program using TCP to find if the number entered is prime.  
import java.net.*;
import java.io.*;

class tcpClientPrime {
    public static void main(String args[]) {
        try {
            Socket cs = new Socket("localhost", 8001);

            BufferedReader infu = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter a number : ");
            int a = Integer.parseInt(infu.readLine());

            DataOutputStream out = new DataOutputStream(cs.getOutputStream());

            out.writeInt(a);

            DataInputStream in = new DataInputStream(cs.getInputStream());

            System.out.println(in.readUTF());

            in.close();
            out.close();
            cs.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
