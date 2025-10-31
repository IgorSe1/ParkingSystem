package parking;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Скільки місць створити: ");
        int placesCount;
        try {
            placesCount = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            placesCount = 0;
        }

        Parking[] places = new Parking[placesCount];
        for (int i = 0; i < placesCount; i++) {
            places[i] = new Parking();
        }

        Driver[] drivers = new Driver[100];
        Transport[] transports = new Transport[100];
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
            if (hasAnyDriver == false) {
                System.out.println("1 - створити і припаркувати водія");
                System.out.println("2 - показати всі місця");
                System.out.println("3 - показати всі оплати (чеки)");
                System.out.println("4 - показати всіх водіїв");
                System.out.println("0 - вихід");
            } else {
                System.out.println("1 - створити і припаркувати водія");
                System.out.println("2 - оплатити місце");
                System.out.println("3 - показати всі місця");
                System.out.println("4 - показати всі оплати (чеки)");
                System.out.println("5 - показати всіх водіїв");
                System.out.println("0 - вихід");
            }

            System.out.print("Вибір: ");
            String choice = sc.nextLine();

            if (choice.equals("0")) {
                System.out.println("Вихід");
                break;
            }

            if (hasAnyDriver == false) {

                if (choice.equals("1")) {
                    System.out.print("Введи ім'я водія: ");
                    String name = sc.nextLine();
                    System.out.print("Введи прізвище водія: ");
                    String surname = sc.nextLine();
                    System.out.print("Телефон водія: ");
                    String phone = sc.nextLine();
                    System.out.print("Email водія: ");
                    String mail = sc.nextLine();

                    System.out.print("Модель машини: ");
                    String carModel = sc.nextLine();
                    System.out.print("Держ номер машини: ");
                    String carNumber = sc.nextLine();

                    Transport t = new Transport(carModel, carNumber, LocalDateTime.now(), null);
                    Driver d = new Driver(phone, mail, name, surname, t);

                    System.out.print("Куди ставимо (індекс місця від 1 до " + placesCount + "): ");
                    int idxPlace;
                    try {
                        idxPlace = Integer.parseInt(sc.nextLine()) - 1;
                    } catch (Exception e) {
                        idxPlace = -1;
                    }

                    if (idxPlace >= 0 && idxPlace < placesCount) {
                        if (places[idxPlace].isFreeNow()) {
                            places[idxPlace].occupyPlace(t.getTransport_info() + " / " + d.getFullName());
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
                        transports[driverSize] = t;
                        driverSize = driverSize + 1;
                    } else {
                        System.out.println("Ми більше не зберігаєм водіїв");
                    }
                }

                else if (choice.equals("2")) {
                    printPlacesHuman(places, placeDriverIndex, placeCheckIndex, drivers);
                }

                else if (choice.equals("3")) {
                    printChecksHuman(checks, checkSize);
                }

                else if (choice.equals("4")) {
                    printDriversHuman(drivers, driverSize);
                }

                else {
                    System.out.println("нема такого пункту");
                }

            } else {

                if (choice.equals("1")) {
                    System.out.print("Введи ім'я водія: ");
                    String name = sc.nextLine();
                    System.out.print("Введи прізвище водія: ");
                    String surname = sc.nextLine();
                    System.out.print("Телефон водія: ");
                    String phone = sc.nextLine();
                    System.out.print("Email водія: ");
                    String mail = sc.nextLine();

                    System.out.print("Модель машини: ");
                    String carModel = sc.nextLine();
                    System.out.print("Держ номер машини: ");
                    String carNumber = sc.nextLine();

                    Transport t = new Transport(carModel, carNumber, LocalDateTime.now(), null);
                    Driver d = new Driver(phone, mail, name, surname, t);

                    System.out.print("Куди ставимо (індекс місця від 1 до " + placesCount + "): ");
                    int idxPlace;
                    try {
                        idxPlace = Integer.parseInt(sc.nextLine()) - 1;
                    } catch (Exception e) {
                        idxPlace = -1;
                    }

                    if (idxPlace >= 0 && idxPlace < placesCount) {
                        if (places[idxPlace].isFreeNow()) {
                            places[idxPlace].occupyPlace(t.getTransport_info() + " / " + d.getFullName());
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
                        transports[driverSize] = t;
                        driverSize = driverSize + 1;
                    } else {
                        System.out.println("Ми більше не зберігаєм водіїв");
                    }
                }

                else if (choice.equals("2")) {
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
                                PaymentCheck ch = new PaymentCheck(checkId, sum);
                                ch.confirmPaid(true, LocalDateTime.now());

                                if (checkSize < checks.length) {
                                    checks[checkSize] = ch;
                                    placeCheckIndex[payIdx] = checkSize;
                                    checkSize = checkSize + 1;
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
                }

                else if (choice.equals("3")) {
                    printPlacesHuman(places, placeDriverIndex, placeCheckIndex, drivers);
                }

                else if (choice.equals("4")) {
                    printChecksHuman(checks, checkSize);
                }

                else if (choice.equals("5")) {
                    printDriversHuman(drivers, driverSize);
                }

                else {
                    System.out.println("нема такого пункту");
                }
            }
        }
    }

    static void printPlacesHuman(Parking[] places, int[] placeDriverIndex, int[] placeCheckIndex, Driver[] drivers) {
        System.out.println("Список місць:");
        for (int i = 0; i < places.length; i++) {
            boolean free = places[i].isFreeNow();
            boolean paid = places[i].alreadyPaid();
            int drvIdx = placeDriverIndex[i];

            String who;
            if (free) {
                who = "місце вільно";
            } else {
                if (drvIdx >= 0) {
                    who = "зайнято водієм №" + (drvIdx + 1);
                } else {
                    who = "зайнято";
                }
            }

            String payText;
            if (free) {
                payText = "оплата: нема";
            } else {
                if (paid) {
                    payText = "оплата: оплачено";
                } else {
                    payText = "оплата: не оплачено";
                }
            }

            System.out.println("Місце " + (i + 1) + ": " + who + ", " + payText);
        }
    }

    static void printChecksHuman(PaymentCheck[] checks, int checkSize) {
        System.out.println("Список чеків:");
        if (checkSize == 0) {
            System.out.println("Чеків нема");
        }
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        for (int i = 0; i < checkSize; i++) {
            PaymentCheck ch = checks[i];
            String status = ch.isPaidNow() ? "оплачено" : "не оплачено";
            String time = (ch.getTransaction_time() != null)
                    ? ch.getTransaction_time().format(fmt)
                    : "нема дати";
            System.out.println(
                    "Чек №" + (i + 1)
                            + " | сума: " + ch.getAmount_value() + " грн"
                            + " | статус: " + status
                            + " | дата: " + time
            );
        }
    }

    static void printDriversHuman(Driver[] drivers, int driverSize) {
        System.out.println("Список водіїв:");
        if (driverSize == 0) {
            System.out.println("Водіїв нема");
        }
        for (int i = 0; i < driverSize; i++) {
            Driver d = drivers[i];
            System.out.println(
                    "Водій №" + (i + 1)
                            + " | " + d.getFullName()
                            + " | телефон=" + d.phone()
            );
        }
    }
}
