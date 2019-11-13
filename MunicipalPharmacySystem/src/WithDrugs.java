import java.util.ArrayList;

public class WithDrugs implements Drugable{
    ArrayList<Drug> drugs = new ArrayList<Drug>();

    public ArrayList<Drug> getDrugs() {
        return drugs;
    }
    @Override
    public void addDrug(Drug drug) {
        drugs.add(drug);
        System.out.println("This Drug add " + drug.getName());
    }

    @Override
    public boolean check() {
        return false;
    }
}
