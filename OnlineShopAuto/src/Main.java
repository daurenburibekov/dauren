public class Main {
    public static void main(String[] args) {

        AutoFactory af = AutoFactory.getInstance();

        Auto sedan = af.createAuto(AutoType.SEDAN, "Lada", "2107", 0.9, 1000000, 1, 2016).setRailingEnabled(true).build();
        af.addCar(sedan);
        Auto hatchback = af.createAuto(AutoType.HATCHBACK, "Hyundai", "Accent", 1.6,10000000, 100, 2016).build();
        af.addCar(hatchback);
        Auto jeep = af.createAuto(AutoType.JEEP, "Lexus", "LX570", 5.7,100000000, 100, 2016).build();
        af.addCar(jeep);

        Client client = new Client("Dauren Buribekov", 20);

        sedan.sale();
        hatchback.sale(101);
        client.subscribe(sedan);
        client.subscribe(hatchback);
        client.subscribe(jeep);

        System.out.println(sedan.getCount());
        sedan.entered(10);
        System.out.println(sedan.getCount());
        sedan.notifyMe(true);
        hatchback.notifyMe(true);
        jeep.notifyMe(true);

        client.unSubscribe(hatchback);
        hatchback.notifyMe(true);

        System.out.println(sedan);
        System.out.println(hatchback);
        System.out.println(jeep);
    }
}
