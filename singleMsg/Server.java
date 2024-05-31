

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

public static void main(String[] args) throws Exception{

ServerSocket ss= new ServerSocket(7777);
Socket s1=ss.accept();
DataInputStream ds1=new DataInputStream(s1.getInputStream());
String msg= (String) ds1.readUTF();
System.out.println("Message---- " + msg);
ss.close();


    
}


}

//For knowing client port----

// import java.io.DataInputStream;
// import java.net.ServerSocket;
// import java.net.Socket;

// public class Server {

//     public static void main(String[] args) throws Exception {

//         ServerSocket ss = new ServerSocket(7777);
//         System.out.println("Server started...");

//         Socket s1 = ss.accept();
//         // Get the client port
//         int clientPort = s1.getPort();
//         System.out.println("Client connected from port: " + clientPort);

//         DataInputStream ds1 = new DataInputStream(s1.getInputStream());
//         String msg = (String) ds1.readUTF();
//         System.out.println("Message received: " + msg);
//         ss.close();
//     }
// }
