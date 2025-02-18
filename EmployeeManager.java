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

    public String toString() {
        return id + " " + name + " " + salary;
    }
}

public class EmployeeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("1. Add 2. Update 3. Remove 4. Search 5. Exit");
            int choice = scanner.nextInt();
            if (choice == 5) break;
            
            switch (choice) {
                case 1:
                    System.out.println("Enter ID, Name, Salary:");
                    employees.add(new Employee(scanner.nextInt(), scanner.next(), scanner.nextDouble()));
                    break;
                case 2:
                    System.out.println("Enter ID to update:");
                    int id = scanner.nextInt();
                    for (Employee e : employees) {
                        if (e.id == id) {
                            System.out.println("Enter new Name and Salary:");
                            e.name = scanner.next();
                            e.salary = scanner.nextDouble();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter ID to remove:");
                    employees.removeIf(e -> e.id == scanner.nextInt());
                    break;
                case 4:
                    System.out.println("Enter ID to search:");
                    int searchId = scanner.nextInt();
                    employees.stream().filter(e -> e.id == searchId).forEach(System.out::println);
                    break;
            }
        }
    }
}