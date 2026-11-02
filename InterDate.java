//InterDate.java 
// 4 - RMI based application program to display current date and time (start rmiregistry)
import java.rmi.*;
public interface InterDate extends Remote {
    public String display() throws Exception;
}