import java.util.concurrent.atomic.LongAdder;

public class Shop {

    private LongAdder revenue = new LongAdder();

    public long countRevenue() {
        return revenue.sum();
    }

    public void addMoneyToRevenue(int sum) {
        revenue.add(sum);
    }

}
