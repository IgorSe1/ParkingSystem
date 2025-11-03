package parking;

public class Count {
    private int alltime_customers;
    private int inDay_customers;
    private int inMonth_customers;
    private int inHalfyear_customers;
    private int inYear_customers;

    public Count() { }

    public Count(int a, int d, int m, int h, int y) {
        this.alltime_customers = a;
        this.inDay_customers = d;
        this.inMonth_customers = m;
        this.inHalfyear_customers = h;
        this.inYear_customers = y;
    }

    public void addVisit() {
        alltime_customers++;
        inDay_customers++;
        inMonth_customers++;
        inHalfyear_customers++;
        inYear_customers++;
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

    public String toString() {
        return "Count{all=" + alltime_customers + ", day=" + inDay_customers + ", month=" + inMonth_customers + "}";
    }
}
