
import java.io.FileWriter;
import java.io.IOException;

public class Sports extends Vehical {

    private final boolean isTurbo;

    public Sports(String modelNumber, String engineType, String type, int enginePower, int terSize, boolean isTurbo) {
        super(modelNumber, engineType, type, enginePower, terSize);
        this.isTurbo = isTurbo;
    }

    @Override
    public void display() {

        super.display();
        System.out.println("Turbo is : " + (isTurbo ? "Yes" : "No"));
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
        fileWriter.append(String.valueOf(this.isTurbo));
        fileWriter.append(",");
        fileWriter.append("0");
        fileWriter.append("\n");
    }

}
