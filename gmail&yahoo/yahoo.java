//yahoo to any server

// import javax.net.ssl.SSLSocket;
// import javax.net.ssl.SSLSocketFactory;
// import java.io.BufferedReader;
// import java.io.DataOutputStream;
// import java.io.InputStreamReader;
// import java.util.Base64;

// public class SmtpMailWithSocket {
//     private static DataOutputStream dos;

//     public static void main(String[] args) throws Exception {
//         int delay = 1000;
//         String user = "your_yahoo_email@yahoo.com";
//         String pass = "your_yahoo_password";
//         String username = new String(Base64.getEncoder().encode(user.getBytes()));
//         String password = new String(Base64.getEncoder().encode(pass.getBytes()));
//         SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
//         SSLSocket sock = (SSLSocket) sslsocketfactory.createSocket("smtp.mail.yahoo.com", 465);
//         final BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

//         dos = new DataOutputStream(sock.getOutputStream());

//         send("EHLO smtp.mail.yahoo.com\r\n");
//         Thread.sleep(delay);
//         for (int i = 1; i <= 9; i++) {
//             System.out.println("SERVER: " + br.readLine());
//         }

//         send("AUTH LOGIN\r\n");
//         Thread.sleep(delay);
//         System.out.println("SERVER: " + br.readLine());

//         send(username + "\r\n");
//         Thread.sleep(delay);
//         System.out.println("SERVER: " + br.readLine());

//         send(password + "\r\n");
//         Thread.sleep(delay);
//         System.out.println("SERVER: " + br.readLine());

//         send("MAIL FROM:<your_yahoo_email@yahoo.com>\r\n");
//         Thread.sleep(delay);
//         System.out.println("SERVER: " + br.readLine());

//         send("RCPT TO:<recipient_email@example.com>\r\n");
//         Thread.sleep(delay);
//         System.out.println("SERVER: " + br.readLine());

//         send("DATA\r\n");
//         Thread.sleep(delay);
//         System.out.println("SERVER: " + br.readLine());

//         Thread.sleep(delay);
//         send("Subject: Test Email\r\n");

//         Thread.sleep(delay);
//         send("This mail was sent using SMTP Server & Java Socket Programming.\r\n");

//         send(".\r\n");
//         Thread.sleep(delay);
//         System.out.println("SERVER: " + br.readLine());

//         send("QUIT\r\n");
//     }

//     private static void send(String s) throws Exception {
//         dos.writeBytes(s);
//         System.out.println("CLIENT: " + s);
//     }
// }


//gmail to yahoo
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.Base64;

public class yahoo {
    private static DataOutputStream dos;

    public static void main(String[] args) throws Exception {
        int delay = 1000;
        String user = "s2012176145@ru.ac.bd";
        String pass = "Heart-beat@2001";
        String username = new String(Base64.getEncoder().encode(user.getBytes()));
        String password = new String(Base64.getEncoder().encode(pass.getBytes()));
        SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sock = (SSLSocket) sslsocketfactory.createSocket("smtp.gmail.com", 465);
        final BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

        dos = new DataOutputStream(sock.getOutputStream());

        send("EHLO smtp.gmail.com\r\n");
        Thread.sleep(delay);
        for (int i = 1; i <= 9; i++) {
            System.out.println("SERVER: " + br.readLine());
        }

        send("AUTH LOGIN\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: " + br.readLine());

        send(username + "\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: " + br.readLine());

        send(password + "\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: " + br.readLine());

        send("MAIL FROM:<s2012176145@ru.ac.bd>\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: " + br.readLine());

        send("RCPT TO:<jimsballard@yahoo.com>\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: " + br.readLine());

        send("DATA\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: " + br.readLine());

        Thread.sleep(delay);
        send("Subject: Test Email\r\n");

        Thread.sleep(delay);
        send("This mail was sent using SMTP Server & Java Socket Programming.\r\n");

        send(".\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: " + br.readLine());

        send("QUIT\r\n");
    }

    private static void send(String s) throws Exception {
        dos.writeBytes(s);
        System.out.println("CLIENT: " + s);
    }
}
