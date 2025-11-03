package parking;

import java.time.LocalDate;

public class PublicUtilities {
    private double payment;
    private LocalDate payment_date;

    public PublicUtilities() { }

    public PublicUtilities(double payment, LocalDate date) {
        this.payment = payment;
        this.payment_date = date;
    }

    public double getPayment() {
        return payment;
    }

    public LocalDate getPayment_date() {
        return payment_date;
    }

    public void rewritePayment(double newPayment, LocalDate newDate) {
        this.payment = newPayment;
        this.payment_date = newDate;
    }

    public String toString() {
        return "PublicUtilities{payment=" + payment + ", date=" + payment_date + "}";
    }
}
