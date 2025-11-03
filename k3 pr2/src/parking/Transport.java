package parking;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Transport {
    protected String car_model;
    protected String car_govnumber;
    protected LocalDateTime enter_date;
    protected LocalDateTime exit_date;

    public Transport() { }

    public Transport(String model, String gov, LocalDateTime in, LocalDateTime out) {
        this.car_model = model;
        this.car_govnumber = gov;
        this.enter_date = in;
        this.exit_date = out;
    }

    public String getTransport_info() {
        return car_model + " [" + car_govnumber + "]";
    }

    public void enterNow(LocalDateTime t) {
        this.enter_date = t;
        this.exit_date = null;
    }

    public void exitNow(LocalDateTime t) {
        this.exit_date = t;
    }

    public boolean isNowInParking() {
        return enter_date != null && exit_date == null;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getCar_govnumber() {
        return car_govnumber;
    }

    public void setCar_govnumber(String car_govnumber) {
        this.car_govnumber = car_govnumber;
    }

    public LocalDateTime getEnter_date() {
        return enter_date;
    }

    public void setEnter_date(LocalDateTime enter_date) {
        this.enter_date = enter_date;
    }

    public LocalDateTime getExit_date() {
        return exit_date;
    }

    public void setExit_date(LocalDateTime exit_date) {
        this.exit_date = exit_date;
    }

    public String toString() {
        return getTransport_info();
    }

    public static void fillFromUser(Transport t, Scanner sc) {
        System.out.print("Модель машини: ");
        String carModel = sc.nextLine();
        System.out.print("Держ номер машини: ");
        String carNumber = sc.nextLine();
        t.setCar_model(carModel);
        t.setCar_govnumber(carNumber);
        t.enterNow(LocalDateTime.now());
    }
}
