public class Pharmacist extends Approver{
    private DrugStore drugStore = DrugStore.getInstance();
    @Override
    public void ProcessRequest(Patient patient, Drug drug) {
        if(!drug.getWithRecept()) {
            patient.addDrug(drug);
            drugStore.giveDrug(drug);
        }
        else if(check(patient, drug)) {
            patient.addDrug(drug);
            drugStore.giveDrug(drug);
        }
        else if(!check(patient, drug)) visor.ProcessRequest(patient, drug);
    }

    public boolean check(Patient patient, Drug drug){
        if(patient.getDrugsWithRecept().contains(drug)){
            return true;
        }
        return false;
    }
}
