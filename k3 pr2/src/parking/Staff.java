package parking;

public class Staff {
    private String name;
    private int age;
    private String workshift;
    private int work_experience;
    private String work_position;
    private String staff_kind;

    public Staff() {
        this.name = "";
        this.age = 0;
        this.workshift = "";
        this.work_experience = 0;
        this.work_position = "";
        this.staff_kind = "";
    }

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

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workshift='" + workshift + '\'' +
                ", work_experience=" + work_experience +
                ", work_position='" + work_position + '\'' +
                ", staff_kind='" + staff_kind + '\'' +
                '}';
    }
}
