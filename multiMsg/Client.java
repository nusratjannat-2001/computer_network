import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);\\different device a korle localhost er jaigai ip address dite hobe server computer ar.
            System.out.println("Connected to server.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String message;
            while (true) {
                // Send message to server
                System.out.print("Client: ");
                message = consoleReader.readLine();
                writer.println(message);

                // Receive response from server
                message = reader.readLine();
                System.out.println("Server: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
