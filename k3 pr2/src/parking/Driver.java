package parking;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Driver extends Transport {
    private String phonenumber;
    private String email;
    private String name;
    private String surname;

    public Driver() { }

    public Driver(String phone, String mail, String name, String surname, String carModel, String carNumber, LocalDateTime in) {
        super(carModel, carNumber, in, null);
        this.phonenumber = phone;
        this.email = mail;
        this.name = name;
        this.surname = surname;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public String phone() {
        return phonenumber;
    }

    public void changePhone(String newPhone) {
        this.phonenumber = newPhone;
    }

    public Transport getTransport() {
        return this;
    }

    void attachTransport(Transport t) {
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String toString() {
        return "Driver{" + getFullName() + ", " + super.getTransport_info() + "}";
    }

    @Override
    public String getTransport_info() {
        return super.getTransport_info() + " / " + getFullName();
    }

    public static Driver createFromUser(Scanner sc) {
        System.out.print("Введи ім'я водія: ");
        String name = sc.nextLine();
        System.out.print("Введи прізвище водія: ");
        String surname = sc.nextLine();
        System.out.print("Телефон водія: ");
        String phone = sc.nextLine();
        System.out.print("Email водія: ");
        String mail = sc.nextLine();
        Driver d = new Driver();
        d.name = name;
        d.surname = surname;
        d.phonenumber = phone;
        d.email = mail;
        Transport.fillFromUser(d, sc);
        return d;
    }

    public static void printAll(Driver[] drivers, int driverSize) {
        System.out.println("Список водіїв:");
        if (drivers == null || driverSize == 0) {
            System.out.println("Водіїв нема");
            return;
        }
        for (int i = 0; i < driverSize; i++) {
            Driver d = drivers[i];
            System.out.println("Водій №" + (i + 1) + " | " + d.getFullName() + " | телефон=" + d.phone());
        }
    }
}
