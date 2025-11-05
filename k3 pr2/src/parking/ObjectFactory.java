package parking;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ObjectFactory {
    public static Driver newDriverFromUser(Scanner sc) {
        return Driver.createFromUser(sc);
    }

    public static PaymentCheck newPayment(double sum, int nextIndex) {
        String id = "PAY" + nextIndex;
        return PaymentCheck.create(id, sum);
    }

    public static void parkDriverAt(Driver d, int placeIndex) {
        if (DataStore.places == null || placeIndex < 0 || placeIndex >= DataStore.places.length) {
            System.out.println("нема такого місця");
            return;
        }
        if (!DataStore.places[placeIndex].isFreeNow()) {
            System.out.println("Це місце вже зайнято");
            return;
        }
        DataStore.places[placeIndex].occupy(d);
        if (DataStore.driverSize < DataStore.drivers.length) {
            DataStore.drivers[DataStore.driverSize] = d;
            DataStore.placeDriverIndex[placeIndex] = DataStore.driverSize;
            DataStore.driverSize++;
        } else {
            System.out.println("Ми більше не зберігаєм водіїв");
        }
    }

    public static void payPlace(int placeIndex, double sum) {
        if (DataStore.places == null || placeIndex < 0 || placeIndex >= DataStore.places.length) {
            System.out.println("нема такого місця");
            return;
        }
        Parking p = DataStore.places[placeIndex];
        if (p.isFreeNow()) {
            System.out.println("Місце пусте, там нема машини, оплатити не можна");
            return;
        }
        if (p.alreadyPaid()) {
            System.out.println("Вже оплачено раніше");
            return;
        }
        PaymentCheck ch = newPayment(sum, DataStore.checkSize + 1);
        ch.confirmPaid(true, LocalDateTime.now());
        if (DataStore.checkSize < DataStore.checks.length) {
            DataStore.checks[DataStore.checkSize] = ch;
            DataStore.placeCheckIndex[placeIndex] = DataStore.checkSize;
            DataStore.checkSize++;
        } else {
            System.out.println("Ліміт чеків");
        }
        p.markPaidInsidePackage();
        System.out.println("Оплата зроблена");
    }

    public static void printAllPlaces() {
        Parking.printAll(DataStore.places, DataStore.placeDriverIndex, DataStore.placeCheckIndex, DataStore.drivers);
    }

    public static void printAllChecks() {
        PaymentCheck.printAll(DataStore.checks, DataStore.checkSize);
    }

    public static void printAllDrivers() {
        Driver.printAll(DataStore.drivers, DataStore.driverSize);
    }
}
