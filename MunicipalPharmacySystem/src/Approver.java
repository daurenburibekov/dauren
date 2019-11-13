public abstract class Approver {
    protected Approver visor;

    public void setSupervisor(Approver visor)
    {
        this.visor = visor;
    }

    public abstract void ProcessRequest(Patient patient, Drug drug);
}
