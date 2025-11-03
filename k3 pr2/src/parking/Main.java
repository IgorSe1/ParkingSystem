package parking;

import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Staff.startShift();

        System.out.print("Скільки місць створити: ");
        int placesCount;
        try {
            placesCount = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            placesCount = 0;
        }

        Parking[] places = new Parking[placesCount];
        for (int i = 0; i < placesCount; i++) places[i] = new Parking();

        Driver[] drivers = new Driver[100];
        PaymentCheck[] checks = new PaymentCheck[100];

        int[] placeDriverIndex = new int[placesCount];
        int[] placeCheckIndex = new int[placesCount];
        for (int i = 0; i < placesCount; i++) {
            placeDriverIndex[i] = -1;
            placeCheckIndex[i] = -1;
        }

        int driverSize = 0;
        int checkSize = 0;
        boolean hasAnyDriver = false;

        while (true) {
            System.out.println();
            System.out.println("===== МЕНЮ =====");
            if (!hasAnyDriver) {
                System.out.println("1 - створити і припаркувати водія");
                System.out.println("2 - показати всі місця");
                System.out.println("3 - показати всі оплати (чеки)");
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

            if (!hasAnyDriver) {
                if (choice.equals("1")) {
                    Driver d = Driver.createFromUser(sc);
                    System.out.print("Куди ставимо (індекс місця від 1 до " + placesCount + "): ");
                    int idxPlace;
                    try {
                        idxPlace = Integer.parseInt(sc.nextLine()) - 1;
                    } catch (Exception e) {
                        idxPlace = -1;
                    }
                    if (idxPlace >= 0 && idxPlace < placesCount) {
                        if (places[idxPlace].isFreeNow()) {
                            places[idxPlace].occupy(d);
                            placeDriverIndex[idxPlace] = driverSize;
                            System.out.println("Поставлено на місце " + (idxPlace + 1));
                            hasAnyDriver = true;
                        } else {
                            System.out.println("Це місце вже зайнято");
                        }
                    } else {
                        System.out.println("нема такого місця");
                    }
                    if (driverSize < drivers.length) {
                        drivers[driverSize] = d;
                        driverSize++;
                    } else {
                        System.out.println("Ми більше не зберігаєм водіїв");
                    }
                    Transport tt = d;
                } else if (choice.equals("2")) {
                    Parking.printAll(places, placeDriverIndex, placeCheckIndex, drivers);
                } else if (choice.equals("3")) {
                    PaymentCheck.printAll(checks, checkSize);
                } else if (choice.equals("4")) {
                    Driver.printAll(drivers, driverSize);
                } else {
                    System.out.println("нема такого пункту");
                }
            } else {
                if (choice.equals("1")) {
                    Driver d = Driver.createFromUser(sc);
                    System.out.print("Куди ставимо (індекс місця від 1 до " + placesCount + "): ");
                    int idxPlace;
                    try {
                        idxPlace = Integer.parseInt(sc.nextLine()) - 1;
                    } catch (Exception e) {
                        idxPlace = -1;
                    }
                    if (idxPlace >= 0 && idxPlace < placesCount) {
                        if (places[idxPlace].isFreeNow()) {
                            places[idxPlace].occupy(d);
                            placeDriverIndex[idxPlace] = driverSize;
                            System.out.println("Поставлено на місце " + (idxPlace + 1));
                        } else {
                            System.out.println("Це місце вже зайнято");
                        }
                    } else {
                        System.out.println("нема такого місця");
                    }
                    if (driverSize < drivers.length) {
                        drivers[driverSize] = d;
                        driverSize++;
                    } else {
                        System.out.println("Ми більше не зберігаєм водіїв");
                    }
                    Transport tt = d;
                } else if (choice.equals("2")) {
                    System.out.print("Яке місце оплатити (1.." + placesCount + "): ");
                    int payIdx;
                    try {
                        payIdx = Integer.parseInt(sc.nextLine()) - 1;
                    } catch (Exception e) {
                        payIdx = -1;
                    }
                    if (payIdx >= 0 && payIdx < placesCount) {
                        if (places[payIdx].isFreeNow()) {
                            System.out.println("Місце пусте, там нема машини, оплатити не можна");
                        } else {
                            if (places[payIdx].alreadyPaid()) {
                                System.out.println("Вже оплачено раніше");
                            } else {
                                System.out.print("Сума оплати (грн): ");
                                double sum;
                                try {
                                    sum = Double.parseDouble(sc.nextLine());
                                } catch (Exception e) {
                                    sum = 0.0;
                                }
                                String checkId = "PAY" + (checkSize + 1);
                                PaymentCheck ch = PaymentCheck.create(checkId, sum);
                                ch.confirmPaid(true, LocalDateTime.now());
                                if (checkSize < checks.length) {
                                    checks[checkSize] = ch;
                                    placeCheckIndex[payIdx] = checkSize;
                                    checkSize++;
                                } else {
                                    System.out.println("Ліміт чеків");
                                }
                                places[payIdx].markPaidInsidePackage();
                                System.out.println("Оплата зроблена");
                            }
                        }
                    } else {
                        System.out.println("нема такого місця");
                    }
                } else if (choice.equals("3")) {
                    Parking.printAll(places, placeDriverIndex, placeCheckIndex, drivers);
                } else if (choice.equals("4")) {
                    PaymentCheck.printAll(checks, checkSize);
                } else if (choice.equals("5")) {
                    Driver.printAll(drivers, driverSize);
                } else {
                    System.out.println("нема такого пункту");
                }
            }
        }

        Staff.endShift();
    }
}
