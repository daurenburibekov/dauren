import java.util.ArrayList;

public class Auto implements IAuto{

    private String name;
    private String model;
    private String type;
    private double volume;
    private double price;
    private int count;
    private int year;
    private boolean railingIsEnabled;
    private ArrayList<Client> subscribers;

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getModel() {
        return model;
    }
    public double getVolume() {
        return volume;
    }
    public double getPrice() {
        return price;
    }
    public int getCount() {
        return count;
    }
    public int getYear() {
        return year;
    }
    public boolean isRailingIsEnabled() {
        return railingIsEnabled;
    }
    public ArrayList<Client> getSubscribers() {
        return subscribers;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setRailingIsEnabled(boolean railingIsEnabled) {
        this.railingIsEnabled = railingIsEnabled;
    }
    private void setSubscribers(ArrayList<Client> subscribers) {
        this.subscribers = subscribers;
    }

    public void sale(){
        if(this.count>0) count--;
        else System.out.println("There is no car of this type");
    }
    public void sale(int count){
        if(this.count>0 && this.count>count) this.count = this.count - count;
        else System.out.println("There is no car of this type " + count + ", we have only - " + this.count);
    }
    public void entered(int count){
        this.count = this.count + count;
    }

    public Auto(AutoBuilder builder){
        this.name = builder.name;
        this.model = builder.model;
        this.volume = builder.volume;
        this.price = builder.price;
        this.count = builder.count;
        this.year = builder.year;
        this.railingIsEnabled = builder.railingIsEnabled;
        this.subscribers = new ArrayList<Client>();
    }
    public static class AutoBuilder{

        private String name;
        private String model;
        private double volume;
        private double price;
        private int count;
        private int year;
        private boolean railingIsEnabled;

        public AutoBuilder(String name ,String model, double volume, double price, int count, int year){
            this.name = name;
            this.model = model;
            this.volume = volume;
            this.price = price;
            this.count = count;
            this.year = year;
        }

        public AutoBuilder setRailingEnabled(boolean isRailingEnabled) {
            this.railingIsEnabled = isRailingEnabled;
            return this;
        }

        public Auto build(){ return new Auto(this); }
    }

    @Override
    public String toString() {
        return "Auto{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", volume=" + volume +
                ", price=" + price +
                ", count=" + count +
                ", year=" + year +
                ", railingIsEnabled=" + railingIsEnabled +
                ", subscribers=" + subscribers +
                '}';
    }

    @Override
    public void subscribe(Client client){
        subscribers.add(client);
    }
    @Override
    public void unSubscribe(Client client){
        subscribers.remove(client);
    }
    @Override
    public void notifyMe(boolean availability){
        for (Client o : subscribers) {
            o.update(availability, this.name +" "+ this.model +" "+ this.volume);
        }
    }
}
