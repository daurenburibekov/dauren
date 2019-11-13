import java.util.ArrayList;

public class Journal implements Observable {
    private String title;
    ArrayList<Observer> subscribers = new ArrayList<>();
    boolean availability;

    public Journal(String title) {
        this.title = title;
    }

    public boolean isAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
        notifyMe(availability);
    }


    @Override
    public void subscribe(Observer o) {
        subscribers.add(o);
        o.addJournal(this);
    }

    @Override
    public void unSubscribe(Observer o) {
        subscribers.remove(o);
        o.removeJournal(this);
    }

    @Override
    public void notifyMe(boolean a) {
        for (Observer o : subscribers) {
            o.update(a, this.title);
        }
    }
}
