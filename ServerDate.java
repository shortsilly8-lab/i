//ServerDate.java
// 4 - RMI based application program to display current date and time (start rmiregistry)
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
public class ServerDate extends UnicastRemoteObject implements InterDate {
    public ServerDate() throws Exception {
        super();
    }
    public String display() throws Exception {
        String str = "";
        Date d = new Date();
        str = d.toString();
        return str;
    }
    public static void main(String args[]) throws Exception {
        ServerDate s1 = new ServerDate();
        Naming.rebind("DS", s1);
        System.out.println(
            "Object registered");
    }
}