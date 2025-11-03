package parking;

public class Salary extends Staff {
    protected double salary_rate;
    protected double salary_supplement;

    public Salary() { }

    public Salary(String name, int age, String workshift, int experience, String position, String kind, double rate, double supp) {
        super(name, age, workshift, experience, position, kind);
        this.salary_rate = rate;
        this.salary_supplement = supp;
    }

    public double salary_compute() {
        return salary_rate + salary_supplement;
    }

    public void addBonus(double x) {
        this.salary_supplement += x;
    }

    protected void changeBase(double newRate) {
        this.salary_rate = newRate;
    }

    @Override
    void promoteTo(String newPos) {
        this.work_position = newPos;
        this.salary_supplement += 100;
    }

    public double getSalary_rate() {
        return salary_rate;
    }

    public double getSalary_supplement() {
        return salary_supplement;
    }

    public void setSalary_rate(double salary_rate) {
        this.salary_rate = salary_rate;
    }

    public void setSalary_supplement(double salary_supplement) {
        this.salary_supplement = salary_supplement;
    }

    public String toString() {
        return "Salary{staff=" + name + ", pos=" + work_position + ", sum=" + salary_compute() + "}";
    }
}
