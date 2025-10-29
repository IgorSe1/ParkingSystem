package parking;

import java.time.LocalDateTime;

public class Transport {
    private String car_model;
    private String car_govnumber;
    private LocalDateTime enter_date;
    private LocalDateTime exit_date;

    public Transport() {
        this.car_model = "";
        this.car_govnumber = "";
        this.enter_date = null;
        this.exit_date = null;
    }

    public Transport(String car_model, String car_govnumber, LocalDateTime enter_date, LocalDateTime exit_date) {
        this.car_model = car_model;
        this.car_govnumber = car_govnumber;
        this.enter_date = enter_date;
        this.exit_date = exit_date;
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

    @Override
    public String toString() {
        return "Transport{" +
                "car_model='" + car_model + '\'' +
                ", car_govnumber='" + car_govnumber + '\'' +
                ", enter_date=" + enter_date +
                ", exit_date=" + exit_date +
                '}';
    }
}
