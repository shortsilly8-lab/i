//ClientDate.java
// 4 - RMI based application program to display current date and time (start rmiregistry)
import java.rmi.*;
import java.io.*;
public class ClientDate {
    public static void main(String args[]) throws Exception {
        String s1;
        InterDate h1 = (InterDate) Naming.lookup("rmi://localhost/DS");
        s1 = h1.display();
        System.out.println(s1);
    }
}