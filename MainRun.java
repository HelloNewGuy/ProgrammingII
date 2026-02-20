// Superclass
class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public double calculateSalary() {
        return 3000.0; // Base salary for all employees
    }
}

// Subclass
class Manager extends Employee {
    private double bonus;

    public Manager(String name, double bonus) {
        super(name); // Call to superclass constructor
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + bonus;
    }
}

// Main class
public class MainRun {
    public static void main(String[] args) {

        Employee employee = new Employee("Alice");
        Employee manager = new Manager("Bob", 1500.0);

        System.out.println(employee.name + " salary: $" + employee.calculateSalary());
        System.out.println(manager.name + " salary: $" + manager.calculateSalary());
    }
}

