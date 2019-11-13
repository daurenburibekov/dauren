public class Jeep extends Auto implements IType {
    public Jeep(AutoBuilder builder) {
        super(builder);
        setType("jeep");
    }
    @Override
    public String type() {
        return getType();
    }
}
