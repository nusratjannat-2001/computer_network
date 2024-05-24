import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String command;
                while ((command = in.readLine()) != null) {
                    if (command.equals("ls")) {
                        // List directory contents
                        File directory = new File(".");
                        File[] files = directory.listFiles();
                        for (File file : files) {
                            if (file.isFile()) {
                                out.println("[FILE] " + file.getName());
                            } else if (file.isDirectory()) {
                                out.println("[DIR] " + file.getName());
                            }
                        }
                        out.println("END"); // End of list
                    } else if (command.startsWith("get ")) {
                        // Send requested file to client
                        String fileName = command.substring(4);
                        File file = new File(fileName);
                        if (file.exists() && !file.isDirectory()) {
                            BufferedReader fileReader = new BufferedReader(new FileReader(file));
                            String line;
                            while ((line = fileReader.readLine()) != null) {
                                out.println(line);
                            }
                            out.println("END"); // End of file
                            fileReader.close();
                        } else {
                            out.println("File not found");
                        }
                    }  else if (command.startsWith("put ")) {
    // Receive file from client and save it as put.txt
    String fileName = "put.txt";
    FileWriter fileWriter = new FileWriter(fileName);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    String line;
    while (!(line = in.readLine()).equals("END")) {
        bufferedWriter.write(line);
        bufferedWriter.newLine();
    }
    bufferedWriter.close();
    System.out.println("File received and saved as: " + fileName);
}

                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
