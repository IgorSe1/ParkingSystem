package parking;

public class Parking {
    private boolean isFree;
    private boolean isPaid;
    private String parkplace_info;

    public Parking() {
        this.isFree = true;
        this.isPaid = false;
        this.parkplace_info = "";
    }

    public Parking(boolean isFree, boolean isPaid, String parkplace_info) {
        this.isFree = isFree;
        this.isPaid = isPaid;
        this.parkplace_info = parkplace_info;
    }

    public String getParkplace_info() {
        return parkplace_info;
    }

    public void occupyPlace(String infoText) {
        this.isFree = false;
        this.isPaid = false;
        this.parkplace_info = infoText;
    }

    public void freePlace() {
        this.isFree = true;
        this.isPaid = false;
        this.parkplace_info = "";
    }

    void markPaidInsidePackage() {
        this.isPaid = true;
    }

    public boolean isFreeNow() {
        return isFree;
    }

    public boolean alreadyPaid() {
        return isPaid;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setParkplace_info(String parkplace_info) {
        this.parkplace_info = parkplace_info;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "isFree=" + isFree +
                ", isPaid=" + isPaid +
                ", parkplace_info='" + parkplace_info + '\'' +
                '}';
    }
}
