import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {
    public final static int DEFAULT_PORT = 2005;

    public static void main(String[] args) throws Exception {
        int port = DEFAULT_PORT;

        // Check if a custom port is provided as a command line argument
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                // Handle the case where the provided argument is not a valid integer
            }
            // Check if the provided port is within a valid range
            if ((port < 0) || (port >= 65536)) {
                System.err.println("Port must be between 0 and 65535...");
                return;
            }
        }

        ServerSocket server = null;
        Socket socket = null;
        Scanner inputScanner = new Scanner(System.in);

        // Create a ServerSocket and bind it to the specified port
        server = new ServerSocket(port);
        System.out.print("\n\n\tWaiting for connections...");

        // Wait for a client to connect
        socket = server.accept();
        System.out.print("\n\n\tConnection established...");

        // Sleep for a brief period (5 seconds) to allow the connection to settle
        Thread.sleep(5000);

        // Set up input and output streams for communication with the client
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.print("\n\n");
        drawLine('-', 70);

        String messageToSend = "";

        // Continue the conversation until "fin" is entered
        while (!messageToSend.equals("fin")) {
            System.out.print("\n\n\tServer .>");

            // Read the message to be sent from the server's console input
            messageToSend = inputScanner.nextLine();

            // Send the message to the client
            out.println("" + messageToSend);
            out.flush();

            // Read the client's response
            String reply = in.readLine();
            System.out.print("\n\n\tClient: ");
            if (reply == null) {
                System.out.println("END OF CONVERSATION!!");
                return;
            }
            System.out.print(reply);
            System.out.flush();
            System.out.print("\n");
        }

        // Close the connection when "fin" is entered
        System.out.print("\n\n\tConnection closed.");
        drawLine('-', 70);
        socket.close();
        inputScanner.close();
    }

    // Utility method to draw a line of characters
    public static void drawLine(char character, int length) {
        System.out.println();
        System.out.print("\t+");
        for (int i = 0; i < length; i++) {
            System.out.print(character);
        }
        System.out.print("+");
        System.out.println();
    }
}
