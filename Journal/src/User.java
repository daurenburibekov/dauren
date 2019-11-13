import java.util.ArrayList;

public class User implements Observer {

    public String name;
    ArrayList<Observable> journals = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    @Override
    public void addJournal(Journal j) {
        journals.add(j);
    }

    @Override
    public void removeJournal(Journal j) {
        journals.remove(j);
    }

    @Override
    public void update(boolean availability, String j) {
        if (availability == true) {
            System.out.println(j + " subscribed by " + this.name);
        } else
            System.out.println(j + " not subscribed by " + this.name);
    }
}
