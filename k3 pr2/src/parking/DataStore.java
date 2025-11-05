package parking;

public class DataStore {
    public static Parking[] places;
    public static int[] placeDriverIndex;
    public static int[] placeCheckIndex;

    public static Driver[] drivers = new Driver[100];
    public static PaymentCheck[] checks = new PaymentCheck[100];

    public static int driverSize = 0;
    public static int checkSize = 0;

    public static void initPlaces(int n) {
        if (n < 0) n = 0;
        places = new Parking[n];
        placeDriverIndex = new int[n];
        placeCheckIndex = new int[n];
        for (int i = 0; i < n; i++) {
            places[i] = new Parking();
            placeDriverIndex[i] = -1;
            placeCheckIndex[i] = -1;
        }
    }

    public static boolean hasAnyDriver() {
        return driverSize > 0;
    }

    public static double sumPaid() {
        double s = 0.0;
        for (int i = 0; i < checkSize; i++) {
            PaymentCheck ch = checks[i];
            if (ch != null && ch.isPaidNow()) s += ch.getAmount_value();
        }
        return s;
    }

    public static int totalCars() {
        return driverSize;
    }
}
