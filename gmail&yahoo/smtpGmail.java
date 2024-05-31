import java.io.*;
import java.time.LocalDateTime;
import javax.net.ssl.*;
import java.util.*;

class smtpGmail {

  private static DataOutputStream dos;
  public static BufferedReader br;

  public static void main(String argv[]) throws Exception {
    String user = "s2012176145@ru.ac.bd";
    String pass = ""; 
    
    String username =new String(Base64.getEncoder().encode(user.getBytes()));
    String password =pass;//new String(Base64.getEncoder().encode(pass.getBytes()));password encrypted kore dici tai sudu pass likheci
    //pass encrypt na korle [[new String(Base64.getEncoder().encode(pass.getBytes()))]] ai line ta likha lagto
    SSLSocket s = (SSLSocket) SSLSocketFactory.getDefault().createSocket("smtp.gmail.com", 465);
    dos = new DataOutputStream(s.getOutputStream());
    br = new BufferedReader(new InputStreamReader(s.getInputStream()));



    send("EHLO smtp.gmail.com\r\n");
              System.out.println("SERVER: "+ br.readLine());
              System.out.println("SERVER: "+ br.readLine());
              System.out.println("SERVER: "+ br.readLine());
              System.out.println("SERVER: "+ br.readLine());
              System.out.println("SERVER: "+ br.readLine());
              System.out.println("SERVER: "+ br.readLine());
              System.out.println("SERVER: "+ br.readLine());
              System.out.println("SERVER: "+ br.readLine());
              System.out.println("SERVER: "+ br.readLine());


    
    send("AUTH LOGIN\r\n");
              System.out.println("SERVER: "+ br.readLine());


    send(username + "\r\n");
              System.out.println("SERVER: "+ br.readLine());



    send(password + "\r\n");
              System.out.println("SERVER: "+ br.readLine());


    send("MAIL FROM:<s2012176145@ru.ac.bd>\r\n");
              System.out.println("SERVER: "+ br.readLine());


    send("RCPT TO:<nahidhasan107297@gmail.com>\r\n");
              System.out.println("SERVER: "+ br.readLine());



    send("DATA\r\n");
            System.out.println("SERVER: "+ br.readLine());


    send("FROM: s2012176145@ru.ac.bd\r\n");
    send("TO: nahidhasan107297@gmail.com\r\n");
    send("Subject: Email test" + LocalDateTime.now() + "\r\n");
    send("Hi there,do you want a job?Then contact us\r\n");
    send(".\r\n");
          System.out.println("SERVER: "+ br.readLine());


          
    send("QUIT\r\n");
    System.out.println("SERVER: "+ br.readLine());
  }

  private static void send(String s) throws Exception {
    dos.writeBytes(s);
    Thread.sleep(1000);
    System.out.println("CLIENT: " + s);
     }
}
