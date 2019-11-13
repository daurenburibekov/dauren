import Percent.noPercent;
import Type.indiType;

public class Individual extends Client{


    public Individual(String name, String ID, int contractNumber){
        super(name, ID, contractNumber);
        type = new indiType();
    }
}
