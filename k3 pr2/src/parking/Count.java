package parking;

public class Count {
    private int alltime_customers;
    private int inDay_customers;
    private int inMonth_customers;
    private int inHalfyear_customers;
    private int inYear_customers;

    public Count() {
        this.alltime_customers = 0;
        this.inDay_customers = 0;
        this.inMonth_customers = 0;
        this.inHalfyear_customers = 0;
        this.inYear_customers = 0;
    }

    public Count(int alltime_customers, int inDay_customers, int inMonth_customers, int inHalfyear_customers, int inYear_customers) {
        this.alltime_customers = alltime_customers;
        this.inDay_customers = inDay_customers;
        this.inMonth_customers = inMonth_customers;
        this.inHalfyear_customers = inHalfyear_customers;
        this.inYear_customers = inYear_customers;
    }

    public void addVisit() {
        alltime_customers = alltime_customers + 1;
        inDay_customers = inDay_customers + 1;
        inMonth_customers = inMonth_customers + 1;
        inHalfyear_customers = inHalfyear_customers + 1;
        inYear_customers = inYear_customers + 1;
    }

    public int getAlltime_customers() {
        return alltime_customers;
    }

    public int getInDay_customers() {
        return inDay_customers;
    }

    public int getInMonth_customers() {
        return inMonth_customers;
    }

    public int getInHalfyear_customers() {
        return inHalfyear_customers;
    }

    public int getInYear_customers() {
        return inYear_customers;
    }

    @Override
    public String toString() {
        return "Count{" +
                "alltime_customers=" + alltime_customers +
                ", inDay_customers=" + inDay_customers +
                ", inMonth_customers=" + inMonth_customers +
                ", inHalfyear_customers=" + inHalfyear_customers +
                ", inYear_customers=" + inYear_customers +
                '}';
    }
}
