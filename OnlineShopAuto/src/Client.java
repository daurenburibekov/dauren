import java.util.ArrayList;

public class Client implements IClient{
    private String name;
    private int age;
    private ArrayList<Auto> cars;
    public Client(String name, int age) {
        this.name = name;
        this.age = age;
        this.cars = new ArrayList<Auto>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void subscribe(Auto auto){
        cars.add(auto);
        auto.subscribe(this);
    }
    @Override
    public void unSubscribe(Auto auto){
        cars.remove(auto);
        auto.unSubscribe(this);
    }
    @Override
    public void update(boolean availability, String s) {
        if (availability == true) {
            System.out.println(s + " subscribed by " + this.name);
        } else
            System.out.println(s + " not subscribed by " + this.name);
    }
}
