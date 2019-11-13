import Percent.noPercent;
import Percent.percentBehavior;
import Type.typeBehavior;

public abstract class Client implements typeBehavior, percentBehavior {


    private String name;
    private String ID;
    private int contractNumber;
    protected percentBehavior percentage;
    protected typeBehavior type;
    public Client(String name, String ID, int contractNumber) {
        this.percentage = new noPercent();
        this.name = name;
        this.ID = ID;
        this.contractNumber = contractNumber;
    }
    public Client() {
        this.name = "";
        this.ID = "";
        this.contractNumber = 0;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", contractNumber=" + contractNumber +
                '}';
    }

    @Override
    public void getType(){
        type.getType();
    }
    @Override
    public void getPercent(){
        percentage.getPercent();
    }

    public void setTypeBehavior(typeBehavior type){
        this.type = type;
    }

    public void setPercentageBehavior(percentBehavior percentage){
        this.percentage = percentage;
    }

}
