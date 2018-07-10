public class Main {

    public static void main(String[] args) {
        RabbitsFarm rabbitsFarm = new RabbitsFarm();
        System.out.println("Months to reach rabbit limit: " + rabbitsFarm.simulate(0, 1, 10000));
    }
}
