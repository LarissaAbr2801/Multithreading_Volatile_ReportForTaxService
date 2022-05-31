import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static int SHOP_QUANTITY = 3;
    public static int NUMBER_OF_CASH_FLOWS = 10;
    public static int ARRAY_START = 0;
    public static int ARRAY_END = 100_000;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(SHOP_QUANTITY);

        Shop shop1 = new Shop();
        Shop shop2 = new Shop();
        Shop shop3 = new Shop();

        countRevenue(service, shop1);
        countRevenue(service, shop2);
        countRevenue(service, shop3);

        System.out.println("Выручка первого магазина составила: " + shop1.countRevenue());
        System.out.println("Выручка второго магазина составила: " + shop2.countRevenue());
        System.out.println("Выручка третьего магазина составила: " + shop3.countRevenue());

    }

    public static int[] generatingIntegerArray(int[] array) {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(ARRAY_START, ARRAY_END);
        }
        return array;
    }

    public static void countRevenue(ExecutorService service, Shop shop) {
        Arrays.stream(generatingIntegerArray(new int[NUMBER_OF_CASH_FLOWS]))
                .forEach(i -> service.submit(() -> shop.addMoneyToRevenue(i)));
    }
}
