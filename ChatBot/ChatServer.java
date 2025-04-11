import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server is listening on port 1234...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            Thread readThread = new Thread(() -> {
                try {
                    String clientMessage;
                    while ((clientMessage = in.readLine()) != null) {
                        System.out.println("Client: " + clientMessage);
                        if (clientMessage.equalsIgnoreCase("exit")) {
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Client disconnected.");
                } finally {
                    try {
                        clientSocket.close();
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread writeThread = new Thread(() -> {
                try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
                    String serverMessage;
                    while ((serverMessage = consoleReader.readLine()) != null) {
                        out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Error reading from console.");
                }
            });

            readThread.start();
            writeThread.start();

            readThread.join();
            writeThread.interrupt();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Server closed.");
    }
}