package parking;

import java.time.LocalDate;

public class PublicUtilities {
    private double payment;
    private LocalDate payment_date;

    public PublicUtilities() {
        this.payment = 0.0;
        this.payment_date = null;
    }

    public PublicUtilities(double payment, LocalDate payment_date) {
        this.payment = payment;
        this.payment_date = payment_date;
    }

    public double getPayment() {
        return payment;
    }

    public LocalDate getPayment_date() {
        return payment_date;
    }

    public void rewritePayment(double newPayment, LocalDate newDate) {
        if (newPayment > 0) {
            this.payment = newPayment;
            this.payment_date = newDate;
        }
    }

    @Override
    public String toString() {
        return "PublicUtilities{" +
                "payment=" + payment +
                ", payment_date=" + payment_date +
                '}';
    }
}
