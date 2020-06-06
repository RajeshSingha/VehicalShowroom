
import java.io.FileWriter;
import java.io.IOException;

public class Heavy extends Vehical {

    public int weight;

    public Heavy(String modelNumber, String engineType, String type, int enginePower, int terSize, int weigth) {
        super(modelNumber, engineType, type, enginePower, terSize);
        this.weight = weigth;
    }

    @Override
    public void display() {

        super.display();
        System.out.println("Weight is : " + weight);
    }

    @Override
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
        fileWriter.append(String.valueOf(weight));
        fileWriter.append("\n");
    }

}
