public class Hatchback extends Auto implements IType {
    public Hatchback(AutoBuilder builder) {
        super(builder);
        setType("hatchback");
    }

    @Override
    public String type() { return getType(); }
}
