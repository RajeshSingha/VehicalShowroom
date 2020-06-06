
import java.util.Scanner;

public class VehicalShowroom {

    static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        String userInput;

        while (true) {
            System.out.print("Enter command: ");
            userInput = scanner.next();

            if (userInput.equalsIgnoreCase("add")) {
                break;
            } else if (userInput.equalsIgnoreCase("remove")) {
                break;
            } else if (userInput.equalsIgnoreCase("show")) {
                break;
            }
            if (userInput.equalsIgnoreCase("end")) {
                System.out.println("Showroom is closed");
                break;
            } else {
                System.out.println(userInput + " is a invalid type command. Please put a valid type command. Valid type commands are add, remove, show");
            }
        }

    }

}
