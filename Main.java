import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner inputScanner = new Scanner(System.in);
        int choice;

        // Start a loop to display the menu and handle user choices
        do {
            // Display the menu
            System.out.print("\n\n\t+-------------------------------- M E N U -------------------------------+");
            System.out.print("\n\n\t01. START AS A SERVER...");
            System.out.print("\n\n\t02. START AS A CLIENT...");
            System.out.print("\n\n\t03. EXIT...");
            System.out.print("\n\n\tCHOICE (01 - 03) .>");

            // Read the user's choice
            choice = inputScanner.nextInt();
            inputScanner.nextLine(); // Consume the newline character

            System.out.print("\n\n\t+------------------------------------------------------------------------+");

            switch (choice) {
                case 1:
                    // Start the server by calling the Serveur class's main method
                    Server.main(new String[]{});
                    return; // Exit the program

                case 2:
                    System.out.print("\n\n\tDo you want to enter the host? (Y/N)");
                    char carac = (inputScanner.nextLine()).charAt(0);

                    if ((carac == 'Y') || (carac == 'y')) {
                        // If the user wants to enter the host name, prompt for it
                        System.out.print("\n\n\tEnter the Server's hostname .>");
                        String hostName = inputScanner.nextLine();
                        // Start the client with the provided host name
                        Client.main(new String[]{hostName});
                    } else {
                        // Start the client without providing a host name
                        Client.main(new String[]{});
                    }
                    return; // Exit the program

                case 3:
                    // Exit the loop and the program
                    break;

                default:
                    System.err.print("\n\n\tINVALID INPUT!!");
                    break;
            }
        } while (choice != 3); // Continue the loop until the user chooses to exit

        inputScanner.close(); // Close the input scanner when done
    }
}
