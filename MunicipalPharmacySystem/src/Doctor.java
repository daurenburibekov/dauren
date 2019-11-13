public class Doctor extends Approver {
    DrugStore drugStore = DrugStore.getInstance();
    @Override
    public void ProcessRequest(Patient patient, Drug drug) {
        patient.setDrugsWithRecept(drug);
        System.out.println("Doctor give recepts for drugs " + drug.getName());
        patient.addDrug(drug);
        drugStore.giveDrug(drug);
    }
}
