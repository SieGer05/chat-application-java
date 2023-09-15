import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    private static final InetAddress HOTE = null; // Unused variable, should be removed
    private static InetAddress hote; // Unused variable, should be removed
    private static final int PORT = 2005; // The port to connect to on the server

    public static void main(String[] args) throws Exception {
        String hostName;

        // Check if a custom host name is provided as a command line argument
        if (args.length > 0) {
            hostName = args[0];
        } else {
            hostName = "localhost"; // Use "localhost" as the default host name
        }

        Socket socket = null; // Socket for communication with the server
        Scanner inputScanner = new Scanner(System.in); // Scanner to read user input

        // Resolve the host name to an InetAddress
        InetAddress serverAddress = InetAddress.getByName(hostName);

        // Create a socket and connect to the server
        socket = new Socket(serverAddress, PORT);

        // Set up input and output streams for communication with the server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream());

        // Display a message indicating that the client is waiting for the server to send a message
        System.out.print("\n\n\tWaiting for the server to send a message");

        boolean isSent = false; // Flag to track if a message has been sent
        String messageToSend = "";

        // Continue the conversation until "fin" is entered
        while (!messageToSend.equals("fin")) {
            String reply;

            // Read a message from the server
            reply = in.readLine();

            // If it's the first message from the server, display a notification
            if (!isSent) {
                System.out.print("\n\n\tThe server has sent a message!");
                isSent = true;
                Thread.sleep(5000); // Sleep for 5 seconds
                System.out.print("\n\n");
                Dessiner('-', 70); // Call the Dessiner method to draw a line
            }

            // Display the server's message
            System.out.print("\n\n\tServer: ");
            if (reply == null) {
                System.out.println("END OF CONVERSATION!!");
                return;
            }
            System.out.println(reply);

            // Prompt the user for a message to send to the server
            System.out.print("\n\n\tClient .>");
            messageToSend = inputScanner.nextLine();

            // Send the user's message to the server
            out.println("" + messageToSend);
            out.flush();
        }

        // Display a message when the conversation is finished
        System.out.print("\n\n\tConnection closed.");
        Dessiner('-', 70); // Call the Dessiner method to draw a line
        socket.close(); // Close the socket
        inputScanner.close(); // Close the input scanner
    }

    // Utility method to draw a line of characters
    public static void Dessiner(char CH, int number) {
        System.out.println();
        System.out.print("\t+");
        for (int i = 0; i < number; i++) {
            System.out.print(CH);
        }
        System.out.print("+");
        System.out.println();
    }
}
