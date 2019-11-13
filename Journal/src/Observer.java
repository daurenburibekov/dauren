public interface Observer {
    public void addJournal(Journal j);

    public void removeJournal(Journal j);

    public void update(boolean a, String j);
}
