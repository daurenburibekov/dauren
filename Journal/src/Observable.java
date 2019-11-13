public interface Observable {
    public void subscribe(Observer o);

    public void unSubscribe(Observer o);

    public void notifyMe(boolean a);
}
