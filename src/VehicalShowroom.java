
import java.util.ArrayList;
import java.util.Scanner;

public class VehicalShowroom {

    static ArrayList<Vehical> listOfVehicals;
    static int expectedVisitor = 30;
    static Scanner scanner;

    public static void main(String[] args) {

        listOfVehicals = new ArrayList<>();

        scanner = new Scanner(System.in);

        String userInput;
		
        while (true) {
            System.out.print("Enter command: ");
            userInput = scanner.next();

            if (userInput.equalsIgnoreCase("add")) {
                addVehicals();
            } else if (userInput.equalsIgnoreCase("remove")) {
                removeVehicals();
            } else if (userInput.equalsIgnoreCase("show")) {
                showVehicals();
            }
            if (userInput.equalsIgnoreCase("end")) {
                System.out.println("Showroom is closed");
                break;
            } else {
                System.out.println(userInput + " is a invalid type command. Please put a valid type command. Valid type commands are add, remove, show");
            }
        }

    }

    public static void addVehicals() {
        String mn, et, typ;
        int ep, ts;
        boolean isTurbo;
        int weight;

        Vehical vehical;

        System.out.print("Model Number is : ");
        mn = scanner.next();

        System.out.print("Engine type is : ");
        et = scanner.next();

        System.out.print("Engine power is : ");
        ep = scanner.nextInt();

        System.out.print("Tire size is : ");
        ts = scanner.nextInt();

        System.out.print("Vehicle type is : ");
        typ = scanner.next();

        if (typ.equalsIgnoreCase("Sports")) {
            System.out.print("If turbo press 1 else press 0: ");
            int turbo = scanner.nextInt();
            isTurbo = (turbo == 1);
            et = "Oil";
            vehical = new Sports(mn, et, typ, ep, ts, isTurbo);

        } else if (typ.equalsIgnoreCase("Heavy")) {
            System.out.print("Weight: ");
            weight = scanner.nextInt();
            et = "Diesel";
            vehical = new Heavy(mn, et, typ, ep, ts, weight);
        } else {
            vehical = new Vehical(mn, et, typ, ep, ts);
        }

        listOfVehicals.add(vehical);

        if (vehical.isSports()) {
            expectedVisitor = expectedVisitor + 20;
        }
    }

    private static void showVehicals() {
        if (listOfVehicals.isEmpty()) {
            System.out.println("No cars in showroom");
            return;
        }

        for (int i = 0; i < listOfVehicals.size(); i++) {
            System.out.println("");
            System.out.print("Number " + (i + 1) + " is : ");
            listOfVehicals.get(i).display();
        }

        System.out.println("Todays Expected visitor count is : " + expectedVisitor);
    }

    private static void removeVehicals() {
        if (listOfVehicals.isEmpty()) {
            System.out.println("Currently the showroom has no vehical to present.Please come later.");
            return;
        }

        showVehicals();
        System.out.print("Select a vehical from (1 to " + listOfVehicals.size() + ") to remove from the listOfVehicals: ");

        int whichOneToRemove = scanner.nextInt();

        if (whichOneToRemove <= 0 || whichOneToRemove > listOfVehicals.size()) {
            System.out.println("Your selected vehical is not present.Please try again.");
        } else {
            expectedVisitor = listOfVehicals.get(whichOneToRemove - 1).isSports() ? expectedVisitor - 20 : expectedVisitor;


            listOfVehicals.remove(whichOneToRemove - 1);

            System.out.println("The seleted vehical is removed from the listOfVehicals");
        }
    }

}
