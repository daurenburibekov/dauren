import Percent.withPercent;
import Type.legalType;

public class Legal extends Client {

    public Legal(String name, String ID, int contractNumber) {
        super(name, ID, contractNumber);
        type = new legalType();
        percentage = new withPercent();
    }

}
