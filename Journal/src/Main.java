import javafx.collections.ObservableArray;

public class Main {
    public static void main(String[] args) {
        Observable karavan = new Journal("Karavan");
        Observer galya = new User("Galya");
        Observable belyi = new Journal("Belyi");
        Observer tanya = new User("Tanya");

        karavan.subscribe(galya);
        belyi.subscribe(tanya);

        karavan.notifyMe(true);
        belyi.notifyMe(true);
    }
}
