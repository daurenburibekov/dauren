public class NoDrugs implements Drugable {
    @Override
    public void addDrug(Drug drug) {
        System.out.println("Sorry i can't add this drug "+ drug.getName());
    }

    @Override
    public boolean check() {
        return false;
    }
}
