
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicalShowroom extends Vehical {

    static ArrayList<Vehical> listOfVehicals;
    static int expectedVisitor = 30;
    static Scanner scanner;
    static String filePath = "data.csv";
    static boolean isTurbo;
    Vehical v;

    public static void main(String[] args) throws IOException {

        loadVehicals();

        scanner = new Scanner(System.in);

        String userInput;

        while (true) {
            System.out.print("Enter command: ");
            userInput = scanner.next();

            if (userInput.equalsIgnoreCase("add")) {
                addVehicals();
            } else if (userInput.equalsIgnoreCase("remove")) {
                removeCar();
            } else if (userInput.equalsIgnoreCase("show")) {
                showVehicals();
            } else if (userInput.equalsIgnoreCase("end")) {
                System.out.println("Showroom is closed");
                break;
            } else {
                System.out.println(userInput + " is a invalid type command. Please put a valid type command. Valid type commands are add, remove, show");
            }
        }
        saveVehicals();

    }

    private static void saveVehicals() throws IOException {
        FileWriter fileWriter = null;
        System.out.println("File saved");

        try {
            fileWriter = new FileWriter(filePath);

//            fileWriter.append("ModelNumber, EngineType, Type, EnginePower, TireSize, IsTurbo, Weight");
//            fileWriter.append("\n");
            for (Vehical v : listOfVehicals) {
                v.writeToFile(fileWriter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void addVehicals() throws IOException {
        String mn, et, typ;
        int ep, ts;
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

    private static void removeCar() {
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

            System.out.println("The selected vehical is removed from the list Of Vehicals");
        }
    }

    public VehicalShowroom(String modelNumber, String engineType, String type, int enginePower, int terSize) {
        super(modelNumber, engineType, type, enginePower, terSize);
    }

    private static void loadVehicals() {
        listOfVehicals = new ArrayList<>();

        BufferedReader br;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                if (line.length() == 0) {
                    break;
                }
                String[] values = line.split(",");

                Vehical vehical;
                if (values[2].equalsIgnoreCase("Sports")) {
                    vehical = new Sports(values[0], values[1], values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4]), values[5].equalsIgnoreCase("true"));

                } else if (values[2].equalsIgnoreCase("Heavy")) {
                    vehical = new Heavy(values[0], values[1], values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[6]));
                } else {
                    vehical = new Vehical(values[0], values[1], values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4]));
                }

                listOfVehicals.add(vehical);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Running for the first time ");

        } catch (Exception e) {
            System.out.println("Unknown error");
        }
    }

}
