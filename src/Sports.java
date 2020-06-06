
public class Sports extends Vehical {

    private boolean isTurbo;
    
    public Sports(String modelNumber, String engineType, String type, int enginePower, int terSize, boolean isTurbo){
        super(modelNumber,  engineType,  type,  enginePower,  terSize);
        this.isTurbo = isTurbo;
    }

    @Override
    public void display() {

        super.display();
        System.out.println("Turbo is : " + (isTurbo ? "Yes" : "No"));
    }

}
