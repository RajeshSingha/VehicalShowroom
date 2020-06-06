
import java.io.FileWriter;
import java.io.IOException;

public class Vehical {

    String modelNumber;
    String engineType;
    String type;
    int enginePower;
    int tireSize;

    public Vehical(String modelNumber, String engineType, String type, int enginePower, int terSize) {
        this.modelNumber = modelNumber;
        this.engineType = engineType;
        this.type = type;
        this.enginePower = enginePower;
        this.tireSize = terSize;
    }

    public void display() {

        System.out.println("Mode number is : " + modelNumber);
        System.out.println("Engine type is : " + engineType);
        System.out.println("Engine power is : " + enginePower);
        System.out.println("Tire size is : " + tireSize);
        System.out.println("Vehicle type is : " + type);

    }

    public void writeToFile(FileWriter fileWriter) throws IOException {

        fileWriter.append(this.modelNumber);
        fileWriter.append(",");
        fileWriter.append(this.engineType);
        fileWriter.append(",");
        fileWriter.append(this.type);
        fileWriter.append(",");
        fileWriter.append(String.valueOf(this.enginePower));
        fileWriter.append(",");
        fileWriter.append(String.valueOf(this.tireSize));
        fileWriter.append(",");
        fileWriter.append("False");
        fileWriter.append(",");
        fileWriter.append("0");
        fileWriter.append("\n");

    }

    public boolean isHeavy() {
        return type.equalsIgnoreCase("heavy");
    }

    public boolean isSports() {
        return type.equalsIgnoreCase("sports");
    }

}
