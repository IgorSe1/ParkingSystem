package parking;

public class Driver {
    private String phonenumber;
    private String email;
    private String name;
    private String surname;
    private Transport transport;

    public Driver() {
        this.phonenumber = "";
        this.email = "";
        this.name = "";
        this.surname = "";
        this.transport = null;
    }

    public Driver(String phonenumber, String email, String name, String surname, Transport transport) {
        this.phonenumber = phonenumber;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.transport = transport;
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
        return transport;
    }

    void attachTransport(Transport t) {
        this.transport = t;
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

    @Override
    public String toString() {
        return "Driver{" +
                "phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", transport=" + transport +
                '}';
    }
}
