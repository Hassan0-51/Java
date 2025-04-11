/*import java.util.*;

abstract class staff{
    String name;
    String id;
    String dept;

    public staff(name,id,dept) {
        this.name=name;
        this.id=id;
        this.dept=dept;

    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "ID:" +id+ "  Name: "+name+"  Department: "+dept;

    }
}

class Professor extends staff{
    private double monthlySalary;

    public Professor(String name, String id, String dept, double monthlySalary){
        super(name,id,dept);
        this.monthlySalary=monthlySalary;
    }

    @Override
    public String toString(){
        return super.toString() + "  Salary: "+monthlySalary();

    }
}

class Lecturer extends staff{
    private int lecturesDelivered;
    private double payPerLecture;

    public Lecturer(String name, String id, String dept, int lecturesDelivered,double payPerLecture){
        super(name,id,dept);
        this.lecturesDelivered=lecturesDelivered;
        this.payPerLecture=payPerLecture;

    }

    @Override
    public double calculateSalary(){
        return lecturesDelivered*payPerLecture;
    }

    @Override 
    public String toString(){
        return super.toString()+ "  Salary: "+calculateSalary();
    }
}


class Administrator extends staff{
    private double baseSalary ;
    private double performanceBonus;

    public Lecturer(String name, String id, String dept, double baseSalary,double performanceBonus){
        super(name,id,dept);
        this.baseSalary=baseSalary;
        this.performanceBonus=performanceBonus;

    }

    @Override
    public double calculateSalary(){
        return baseSalary+performanceBonus;
    }

    @Override 
    public String toString(){
        return super.toString()+ "  Salary: "+calculateSalary();
    }
}


class ResearchAssistant extends staff{
    private double stipend;
    private double researchGrant;

    public Lecturer(String name, String id, String dept, double stipend,double researchGrant){
        super(name,id,dept);
        this.stipend=stipend;
        this.researchGrant=researchGrant;

    }

    @Override
    public double calculateSalary(){
        return stipend+researchGrant;
    }

    @Override 
    public String toString(){
        return super.toString()+ "  Salary: "+calculateSalary();
    }
}

public class lab2UniManagementSystem{
    public static void main(String args[]){
        Scanner scanner =new Scanner(System.in);
        Staff[] staffArray=new staff[10];
        int count=0;
        
    }
}*/