
public class Vehical {
    
  
    private final String modelNumber;
    private final String engineType;
    private final String type;
    private final int enginePower;
    private final int tireSize;

    public Vehical(String modelNumber, String engineType, String type, int enginePower, int terSize ) {
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

    public boolean isHeavy() {
        return type.equalsIgnoreCase("heavy");
    }

    public boolean isSports() {
        return type.equalsIgnoreCase("sports");
    }

}
