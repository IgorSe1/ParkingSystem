package parking;

public abstract class Customer {
    protected String id;

    public abstract String getCommonInfo();
    public abstract void showInfo();
    public abstract String getCustomerRole();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return getCommonInfo();
    }
}
