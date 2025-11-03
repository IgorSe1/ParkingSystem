package parking;

import java.time.LocalDateTime;

public class Parking extends PaymentCheck {
    private boolean isFree = true;
    private String parkplace_info = "";

    public Parking() { }

    public Parking(boolean isFree, boolean paid, String info) {
        this.isFree = isFree;
        this.parkplace_info = info;
        if (paid) {
            confirmPaid(true, LocalDateTime.now());
        }
    }

    public String getParkplace_info() {
        return parkplace_info;
    }

    public void occupy(Driver d) {
        this.isFree = false;
        if (d != null) this.parkplace_info = d.getTransport_info();
        else this.parkplace_info = "занято";
    }

    public void freePlace() {
        this.isFree = true;
        this.parkplace_info = "";
    }

    void markPaidInsidePackage() {
        this.isPaid = true;
        this.transaction_time = LocalDateTime.now();
    }

    public boolean isFreeNow() {
        return isFree;
    }

    public boolean alreadyPaid() {
        return isPaidNow();
    }

    public String toString() {
        return "Parking{free=" + isFree + ", paid=" + isPaid + ", info='" + parkplace_info + "'}";
    }

    public static void printAll(Parking[] places, int[] placeDriverIndex, int[] placeCheckIndex, Driver[] drivers) {
        System.out.println("Список місць:");
        if (places == null || places.length == 0) {
            System.out.println("Місць нема");
            return;
        }
        for (int i = 0; i < places.length; i++) {
            boolean free = places[i].isFreeNow();
            boolean paid = places[i].alreadyPaid();
            int drvIdx = placeDriverIndex[i];
            String who;
            if (free) {
                who = "місце вільно";
            } else {
                if (drvIdx >= 0 && drvIdx < drivers.length && drivers[drvIdx] != null) {
                    who = "зайнято водієм №" + (drvIdx + 1);
                } else {
                    who = "зайнято";
                }
            }
            String payText;
            if (free) {
                payText = "оплата: нема";
            } else {
                if (paid) payText = "оплата: оплачено";
                else payText = "оплата: не оплачено";
            }
            System.out.println("Місце " + (i + 1) + ": " + who + ", " + payText);
        }
    }
}
