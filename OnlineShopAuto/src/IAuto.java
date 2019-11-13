public interface IAuto {
    void subscribe(Client c);
    void unSubscribe(Client c);
    void notifyMe(boolean a);
}
