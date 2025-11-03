package parking;

public class Staff {
    protected String name;
    protected int age;
    protected String workshift;
    protected int work_experience;
    protected String work_position;
    protected String staff_kind;

    public Staff() { }

    public Staff(String name, int age, String workshift, int work_experience, String work_position, String staff_kind) {
        this.name = name;
        this.age = age;
        this.workshift = workshift;
        this.work_experience = work_experience;
        this.work_position = work_position;
        this.staff_kind = staff_kind;
    }

    public String getName() {
        return name;
    }

    public String getWork_position() {
        return work_position;
    }

    public int getWork_experience() {
        return work_experience;
    }

    protected void changeShift(String newShift) {
        this.workshift = newShift;
    }

    void promoteTo(String newPos) {
        this.work_position = newPos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkshift(String workshift) {
        this.workshift = workshift;
    }

    public void setWork_experience(int work_experience) {
        this.work_experience = work_experience;
    }

    public void setWork_position(String work_position) {
        this.work_position = work_position;
    }

    public void setStaff_kind(String staff_kind) {
        this.staff_kind = staff_kind;
    }

    public String toString() {
        return "Staff{" + name + ", pos=" + work_position + ", shift=" + workshift + "}";
    }

    public static void startShift() {
        System.out.println("Денна зміна зайшла на роботу. Нічна готується до чергування.");
    }

    public static void endShift() {
        System.out.println("Денна зміна передає чергування. Нічна зміна заступає на пост.");
    }
}
