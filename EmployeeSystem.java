import java.util.*;

class Employee {

    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println(id + " " + name + " " + salary);
    }
}

public class EmployeeSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> emp = new ArrayList<>();
        int choice;

        do {

            System.out.println("\n1.Add Employee");
            System.out.println("2.Display Employee");
            System.out.println("3.Search Employee");
            System.out.println("4.Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    emp.add(new Employee(id,name,salary));
                    break;

                case 2:
                    for(Employee e: emp)
                        e.display();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();

                    for(Employee e: emp)
                        if(e.id == sid)
                            e.display();
                    break;
            }

        } while(choice != 4);

        sc.close();
    }
}