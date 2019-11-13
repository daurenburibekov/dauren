import java.util.ArrayList;

public class AutoFactory {
    private static AutoFactory af;

    public static ArrayList<Auto> getCars() {
        return cars;
    }
    public static void addCar(Auto auto) {
        cars.add(auto);
    }
    private static ArrayList<Auto> cars = new ArrayList<Auto>();
    private AutoFactory(){ }

    public static AutoFactory getInstance(){
        if(af == null) return new AutoFactory();
        return af;
    }

    public static Auto.AutoBuilder createAuto(AutoType type, String name, String model, double volume, double price, int count, int year){
        Auto.AutoBuilder a = null;
        switch (type) {
            case HATCHBACK:
                a = new Auto.AutoBuilder( name, model, volume, price, count, year);
                break;
            case SEDAN:
                a = new Auto.AutoBuilder( name, model, volume, price, count, year);
                break;
            case JEEP:
                a = new Auto.AutoBuilder( name, model, volume, price, count, year);
                break;
        }
        return a;
    }
}
