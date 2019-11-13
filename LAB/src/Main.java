public class Main {

    public static void main(String [] args){
        Client a = new Legal("Company", "1234", 1234);
        Client b = new Individual("Dauren", "123", 123);
        System.out.println(a.toString());
        a.getType();
        a.getPercent();
        System.out.println();
        System.out.println(b.toString());
        b.getType();
        b.getPercent();
    }
}
