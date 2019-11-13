public class Drug {
    private String name;
    private Boolean withRecept;

    private Drug(DrugBuilder drug) {
        this.name = drug.name;
        this.withRecept = drug.withRecept;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getWithRecept() {
        return withRecept;
    }
    public void setWithRecept(Boolean withRecept) {
        this.withRecept = withRecept;
    }

    public static class DrugBuilder{
        private String name;
        private boolean withRecept;

        public DrugBuilder(String name){
            this.name = name;
        }

        public DrugBuilder setWithRecept(boolean withRecept) {
            this.withRecept = withRecept;
            return this;
        }

        public Drug build(){ return new Drug(this);};
    }

}
