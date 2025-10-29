package parking;

public class Salary {
    private double salary_rate;
    private double salary_supplement;

    public Salary() {
        this.salary_rate = 0.0;
        this.salary_supplement = 0.0;
    }

    public Salary(double salary_rate, double salary_supplement) {
        this.salary_rate = salary_rate;
        this.salary_supplement = salary_supplement;
    }

    public double salary_compute() {
        return salary_rate + salary_supplement;
    }

    public void addBonus(double x) {
        if (x > 0) {
            this.salary_supplement = this.salary_supplement + x;
        }
    }

    protected void changeBase(double newRate) {
        if (newRate > 0) {
            this.salary_rate = newRate;
        }
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

    @Override
    public String toString() {
        return "Salary{" +
                "salary_rate=" + salary_rate +
                ", salary_supplement=" + salary_supplement +
                ", total=" + salary_compute() +
                '}';
    }
}
