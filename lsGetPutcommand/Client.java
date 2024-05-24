import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send ls command to get directory listing
            out.println("ls");
            String file;
            while (!(file = in.readLine()).equals("END")) {
                System.out.println(file);
            }

            // Send get command to retrieve get.txt
            out.println("get get.txt");
            FileOutputStream fos = new FileOutputStream("received_get.txt");
            BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(fos));
            while (!(file = in.readLine()).equals("END")) {
                fileWriter.write(file);
                fileWriter.newLine();
            }
            fileWriter.close();

            // Send put command to upload put.txt
            out.println("put put.txt");
            BufferedReader fileReader = new BufferedReader(new FileReader("put.txt"));
            String line;
            while ((line = fileReader.readLine()) != null) {
                out.println(line);
            }
            out.println("END"); // End of file
            fileReader.close();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
