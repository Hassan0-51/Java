import java.util.*;

// Abstract class Staff
abstract class Staff {
    protected String name;
    protected String id;
    protected String department;

    public Staff(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department;
    }
}

// Concrete class Professor
class Professor extends Staff {
    private double monthlySalary;

    public Professor(String name, String id, String department, double monthlySalary) {
        super(name, id, department);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + calculateSalary();
    }
}

// Concrete class Lecturer
class Lecturer extends Staff {
    private int lecturesDelivered;
    private double payPerLecture;

    public Lecturer(String name, String id, String department, int lecturesDelivered, double payPerLecture) {
        super(name, id, department);
        this.lecturesDelivered = lecturesDelivered;
        this.payPerLecture = payPerLecture;
    }

    @Override
    public double calculateSalary() {
        return lecturesDelivered * payPerLecture;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + calculateSalary();
    }
}

// Concrete class Administrator
class Administrator extends Staff {
    private double baseSalary;
    private double performanceBonus;

    public Administrator(String name, String id, String department, double baseSalary, double performanceBonus) {
        super(name, id, department);
        this.baseSalary = baseSalary;
        this.performanceBonus = performanceBonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + performanceBonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + calculateSalary();
    }
}

// Concrete class ResearchAssistant
class ResearchAssistant extends Staff {
    private double stipend;
    private double researchGrant;

    public ResearchAssistant(String name, String id, String department, double stipend, double researchGrant) {
        super(name, id, department);
        this.stipend = stipend;
        this.researchGrant = researchGrant;
    }

    @Override
    public double calculateSalary() {
        return stipend + researchGrant;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + calculateSalary();
    }
}

// Driver class
public class UniversityManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Staff[] staffArray = new Staff[10];
        int count = 0;

        System.out.print("Enter number of staff members: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Staff " + (i + 1) + ":");
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Department: ");
            String department = scanner.nextLine();
            
            System.out.println("Choose Role: 1. Professor 2. Lecturer 3. Administrator 4. Research Assistant");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Monthly Salary: ");
                    double monthlySalary = scanner.nextDouble();
                    staffArray[count++] = new Professor(name, id, department, monthlySalary);
                    break;
                case 2:
                    System.out.print("Enter Lectures Delivered: ");
                    int lecturesDelivered = scanner.nextInt();
                    System.out.print("Enter Pay Per Lecture: ");
                    double payPerLecture = scanner.nextDouble();
                    staffArray[count++] = new Lecturer(name, id, department, lecturesDelivered, payPerLecture);
                    break;
                case 3:
                    System.out.print("Enter Base Salary: ");
                    double baseSalary = scanner.nextDouble();
                    System.out.print("Enter Performance Bonus: ");
                    double performanceBonus = scanner.nextDouble();
                    staffArray[count++] = new Administrator(name, id, department, baseSalary, performanceBonus);
                    break;
                case 4:
                    System.out.print("Enter Stipend: ");
                    double stipend = scanner.nextDouble();
                    System.out.print("Enter Research Grant: ");
                    double researchGrant = scanner.nextDouble();
                    staffArray[count++] = new ResearchAssistant(name, id, department, stipend, researchGrant);
                    break;
                default:
                    System.out.println("Invalid choice! Skipping...");
                    break;
            }
            scanner.nextLine();
        }

        System.out.println("\nUniversity Staff Details and Salaries:");
        for (int i = 0; i < count; i++) {
            System.out.println(staffArray[i]);
        }
        
        scanner.close();
    }
}
