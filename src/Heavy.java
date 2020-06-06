
public class Heavy extends Vehical {

    public int weight;
    
    public Heavy(String modelNumber, String engineType, String type, int enginePower, int terSize, int weigth){
        super(modelNumber,  engineType,  type,  enginePower,  terSize);
        this.weight = weigth;
    }

    @Override
    public void display() {

        super.display();
        System.out.println("Weight is : " + weight);
    }
}
