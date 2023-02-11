package chatApp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatServer {

    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(7777);
            System.out.println("Server started at 7777");


            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create data input and output streams
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

            while (true) {
                Scanner scanner =new Scanner(System.in);
                String msgread = inputFromClient.readUTF();
                // Print the message
                System.out.println("Client: " + msgread);

                System.out.print("Enter a message: ");
                String msgwrite = scanner.nextLine();

                // Send the message to the server
                outputToClient.writeUTF(msgwrite);

                if (msgread.equals("NO MORE")) {
                    outputToClient.writeUTF("OK");
                    break;
                }

            }
        }
        catch(IOException ex) {
            System.err.println(ex);
        }
    }
}