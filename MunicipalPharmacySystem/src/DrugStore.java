public class DrugStore{
    public static DrugStore drugStore;

    public static DrugStore getInstance(){
        if(drugStore == null) return new DrugStore();
        return drugStore;
    }

    public void giveDrug(Drug drug){
        System.out.println(drug.getName() + " add to patient");
    }
}
