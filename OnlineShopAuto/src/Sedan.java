public class Sedan extends Auto implements IType {
    public Sedan(AutoBuilder builder) {
        super(builder);
        setType("sedan");
    }

    @Override
    public String type() {
        return getType();
    }
}
