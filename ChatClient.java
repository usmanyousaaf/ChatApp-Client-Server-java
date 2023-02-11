package chatApp;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 7777);

            DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToServer = new DataOutputStream(socket.getOutputStream());


            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a message: ");
                String msgwrite = scanner.nextLine();

                // Send the message to the server
                outputToServer.writeUTF(msgwrite);

                String msgread = inputFromServer.readUTF();
                // Print the message
                System.out.println("server: " + msgread);

            }
    }
        catch(IOException ex) {
            System.err.println(ex);
        }
    }
}