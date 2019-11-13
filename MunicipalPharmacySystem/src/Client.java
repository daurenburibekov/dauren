public class Client {
    public static void main(String[] args) {
        Approver pharmacist = new Pharmacist();
        Approver doctor = new Doctor();

        pharmacist.setSupervisor(doctor);

        Drug drugOne = new Drug.DrugBuilder("drugOne").build();
        Drug drugTwo = new Drug.DrugBuilder("drugTwo").setWithRecept(true).build();

        Patient patient = new Patient("Patient");
        pharmacist.ProcessRequest(patient, drugOne);
        pharmacist.ProcessRequest(patient, drugTwo);

    }
}
