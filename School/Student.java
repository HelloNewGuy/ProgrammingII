package School;

public class Student {

    private int rollno;
    private String name;
    private String address;

    public Student(int rollno, String name, String address) {

        if (rollno <= 0) {
            throw new IllegalArgumentException("Roll number must be positive.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "roll No: " + rollno +
                ", Name: " + name +
                ", Address: " + address;
    }
}
