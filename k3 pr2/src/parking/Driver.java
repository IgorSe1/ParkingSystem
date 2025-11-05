package parking;

import java.util.Scanner;

public class Driver {
    protected String phonenumber;
    protected String email;
    protected String name;
    protected String surname;

    public static class NameInfo {
        public String name;
        public String surname;
        public NameInfo(String n, String s) { this.name = n; this.surname = s; }
    }

    public Driver() { }

    public Driver(String phone, String mail, String name, String surname) {
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

    public String getTransport_info() {
        return getFullName();
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
        return "Driver{" + getFullName() + "}";
    }

    public static Driver createFromUser(Scanner sc) {
        System.out.print("Введи ім'я водія: ");
        String n = sc.nextLine();
        System.out.print("Введи прізвище водія: ");
        String s = sc.nextLine();
        NameInfo ni = new NameInfo(n, s);
        System.out.print("Телефон водія: ");
        String phone = sc.nextLine();
        System.out.print("Email водія: ");
        String mail = sc.nextLine();
        Transport t = new Transport(phone, mail, ni.name, ni.surname, null, null, null, null);
        Transport.fillFromUser(t, sc);
        return t;
    }

    public static void printAll(Driver[] drivers, int driverSize) {
        System.out.println("Список водіїв:");
        if (drivers == null || driverSize == 0) {
            System.out.println("Водіїв нема");
            return;
        }
        for (int i = 0; i < driverSize; i++) {
            Driver d = drivers[i];
            String car = "авто=нема";
            if (d instanceof Transport) {
                Transport t = (Transport) d;
                String m = t.getCar_model();
                String g = t.getCar_govnumber();
                if (m == null) m = "";
                if (g == null) g = "";
                if (m.isEmpty() && g.isEmpty()) car = "авто=нема";
                else car = "авто=" + m + " [" + g + "]";
            }
            System.out.println("Водій №" + (i + 1) + " | " + d.getFullName() + " | телефон=" + d.phone() + " | " + car);
        }
    }
}
