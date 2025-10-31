package parking;

import java.time.LocalDateTime;

public class PaymentCheck {
    private String id;
    private boolean isPaid;
    private boolean isPaidbyCash;
    private LocalDateTime transaction_time;
    private double amount_value;

    public PaymentCheck() {
        this.id = "";
        this.isPaid = false;
        this.isPaidbyCash = false;
        this.transaction_time = null;
        this.amount_value = 0.0;
    }

    public PaymentCheck(String id, double amount_value) {
        this.id = id;
        this.isPaid = false;
        this.isPaidbyCash = false;
        this.transaction_time = null;
        this.amount_value = amount_value;
    }

    public boolean isPaidNow() {
        return isPaid;
    }

    public boolean paidCash() {
        return isPaidbyCash;
    }

    public double getAmount_value() {
        return amount_value;
    }

    void confirmPaid(boolean byCash, LocalDateTime time) {
        this.isPaid = true;
        this.isPaidbyCash = byCash;
        this.transaction_time = time;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getTransaction_time() {
        return transaction_time;
    }

    public void setTransaction_time(LocalDateTime transaction_time) {
        this.transaction_time = transaction_time;
    }

    @Override
    public String toString() {
        return "PaymentCheck{" +
                "id='" + id + '\'' +
                ", isPaid=" + isPaid +
                ", isPaidbyCash=" + isPaidbyCash +
                ", transaction_time=" + transaction_time +
                ", amount_value=" + amount_value +
                '}';
    }
}
