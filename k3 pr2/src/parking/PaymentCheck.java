package parking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PaymentCheck {
    protected String id;
    protected boolean isPaid;
    protected boolean isPaidbyCash;
    protected LocalDateTime transaction_time;
    protected double amount_value;

    public PaymentCheck() { }

    public PaymentCheck(String id, double amount) {
        this.id = id;
        this.amount_value = amount;
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

    public void setTransaction_time(LocalDateTime t) {
        this.transaction_time = t;
    }

    public String toString() {
        return "PaymentCheck{id=" + id + ", amount=" + amount_value + ", paid=" + isPaid + "}";
    }

    public static PaymentCheck create(String id, double amount) {
        return new PaymentCheck(id, amount);
    }

    public static void printAll(PaymentCheck[] checks, int checkSize) {
        System.out.println("Список чеків:");
        if (checks == null || checkSize == 0) {
            System.out.println("Чеків нема");
            return;
        }
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        for (int i = 0; i < checkSize; i++) {
            PaymentCheck ch = checks[i];
            String status = ch.isPaidNow() ? "оплачено" : "не оплачено";
            String time = (ch.getTransaction_time() != null) ? ch.getTransaction_time().format(fmt) : "нема дати";
            System.out.println("Чек №" + (i + 1) + " | сума: " + ch.getAmount_value() + " грн | статус: " + status + " | дата: " + time);
        }
    }
}
