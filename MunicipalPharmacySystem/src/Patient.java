import java.util.ArrayList;

public class Patient {
    String name;
    ArrayList<Drug> drugs = new ArrayList<Drug>();;
    ArrayList<Drug> drugsWithRecept = new ArrayList<Drug>();

    public Patient(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Drug> getDrugsWithRecept() {
        return drugsWithRecept;
    }
    public void setDrugsWithRecept(Drug drug) {
        this.drugsWithRecept.add(drug);
    }
    public void addDrug(Drug d){ this.drugs.add(d); }
}

