package parking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Staff.startShift();
        PublicUtilities.startCounters();

        System.out.print("Скільки місць створити: ");
        int placesCount;
        try {
            placesCount = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            placesCount = 0;
        }
        DataStore.initPlaces(placesCount);

        while (true) {
            System.out.println();
            System.out.println("===== МЕНЮ =====");
            if (!DataStore.hasAnyDriver()) {
                System.out.println("1 - створити і припаркувати водія");
                System.out.println("2 - показати всі місця");
                System.out.println("3 - показати всі оплати");
                System.out.println("4 - показати всіх водіїв");
                System.out.println("0 - вихід");
            } else {
                System.out.println("1 - створити і припаркувати водія");
                System.out.println("2 - оплатити місце");
                System.out.println("3 - показати всі місця");
                System.out.println("4 - показати всі оплати");
                System.out.println("5 - показати всіх водіїв");
                System.out.println("0 - вихід");
            }

            System.out.print("Вибір: ");
            String choice = sc.nextLine();

            if (choice.equals("0")) {
                System.out.println("Вихід");
                break;
            }

            if (!DataStore.hasAnyDriver()) {
                if (choice.equals("1")) {
                    Driver d = ObjectFactory.newDriverFromUser(sc);
                    System.out.print("Куди ставимо (індекс місця від 1 до " + (DataStore.places == null ? 0 : DataStore.places.length) + "): ");
                    int idxPlace;
                    try {
                        idxPlace = Integer.parseInt(sc.nextLine()) - 1;
                    } catch (Exception e) {
                        idxPlace = -1;
                    }
                    ObjectFactory.parkDriverAt(d, idxPlace);
                } else if (choice.equals("2")) {
                    ObjectFactory.printAllPlaces();
                } else if (choice.equals("3")) {
                    ObjectFactory.printAllChecks();
                } else if (choice.equals("4")) {
                    ObjectFactory.printAllDrivers();
                } else {
                    System.out.println("нема такого пункту");
                }
            } else {
                if (choice.equals("1")) {
                    Driver d = ObjectFactory.newDriverFromUser(sc);
                    System.out.print("Куди ставимо (індекс місця від 1 до " + DataStore.places.length + "): ");
                    int idxPlace;
                    try {
                        idxPlace = Integer.parseInt(sc.nextLine()) - 1;
                    } catch (Exception e) {
                        idxPlace = -1;
                    }
                    ObjectFactory.parkDriverAt(d, idxPlace);
                } else if (choice.equals("2")) {
                    System.out.print("Яке місце оплатити (1.." + DataStore.places.length + "): ");
                    int payIdx;
                    try {
                        payIdx = Integer.parseInt(sc.nextLine()) - 1;
                    } catch (Exception e) {
                        payIdx = -1;
                    }
                    System.out.print("Сума оплати (грн): ");
                    double sum;
                    try {
                        sum = Double.parseDouble(sc.nextLine());
                    } catch (Exception e) {
                        sum = 0.0;
                    }
                    ObjectFactory.payPlace(payIdx, sum);
                } else if (choice.equals("3")) {
                    ObjectFactory.printAllPlaces();
                } else if (choice.equals("4")) {
                    ObjectFactory.printAllChecks();
                } else if (choice.equals("5")) {
                    ObjectFactory.printAllDrivers();
                } else {
                    System.out.println("нема такого пункту");
                }
            }
        }

        Salary.payFromRevenue();
        PublicUtilities.payUtilitiesAtEnd();
        Staff.endShift();
    }
}
