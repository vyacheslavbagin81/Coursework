public class Main {
    static int id = 0;
    static int size;

    public static void main(String[] args) {
        Employee[] employee = new Employee[10];
        employee[0] = addEmployee(employee, "Иванов Иван Иванович", 1, 51500);
        employee[1] = addEmployee(employee, "Сидоров Олег Петрович", 5, 150500);
        employee[2] = addEmployee(employee, "Петров Петр Петрович", 3, 50500);
        employee[3] = addEmployee(employee, "Капустина Марина Ивановна", 2, 75500);
        employee[4] = addEmployee(employee, "Поликарпов Инокентий Винеаминович", 1, 75500);
        employee[5] = addEmployee(employee, "Берлиоз Михаил Александрович", 4, 75500);
        employee[6] = addEmployee(employee, "Соков Андрей Фокич", 5, 45500);
        employee[7] = addEmployee(employee, "Босой Никанор Иванович", 4, 64000);
        employee[8] = addEmployee(employee, "Лиходеев Степан Богданович", 3, 45500);
        employee[9] = addEmployee(employee, "Римский Григорий Данилович", 2, 64000);

        printAllEmployees(employee);//    Реализуем метод printAllEmployees (распечатать список всех сотрудников)

        //   Реализуем метод sumSalary для подсчета суммы затрат на зарплаты в месяц
        System.out.println();
        System.out.println("Сумма затрат на заработную плату за месяц: " + sumSalary(employee));
        printSeparator();

        //    Реализуем метод minSalary (находим сотрудника с минимальной зарплатой)
        minSalary(employee);

        //    Реализуем метод maxSalary (находим сотрудника с максимальной зарплатой)
        maxSalary(employee);

        //   Реализуем метод averageSalary для нахождения среднего значения зарплаты в месяц
        System.out.println();
        System.out.println("Среднее значение заработной платы в месяц: " + averageSalary(employee));
        printSeparator();

        //    Реализуем метод printAllFullNames (распечатать список ФИО всех сотрудников)
        printAllFullNames(employee);
    }


    //    Реализуем метод addEmployee (добовить сотрудника)
    public static Employee addEmployee(Employee[] employees, String fullName, int department, double salary) {
        if (size >= employees.length) {
            System.out.println("Нельзя добавить данные, закончилось место");
        }
        Employee newEmployee = new Employee(fullName, department, salary);
        id++;
        newEmployee.setId(id);
        employees[size++] = newEmployee;
        return newEmployee;
    }

    //    Реализуем метод printAllEmployees (распечатать список всех сотрудников)
    public static void printAllEmployees(Employee[] employees) {
        System.out.println();
        System.out.println("Список сотрудников:");
        printSeparator();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        printSeparator();
    }

    //   Реализуем метод sumSalary для подсчета суммы затрат на зарплаты в месяц
    private static double sumSalary(Employee[] employees) {
        double sumSalary = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            sumSalary = sumSalary + employee.getSalary();
        }
        return sumSalary;
    }

    //    Реализуем метод minSalary (находим сотрудника с минимальной зарплатой)
    private static void minSalary(Employee[] employees) {
        double min = employees[0].getSalary();
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() < min) {
                min = employee.getSalary();
            }
        }
        System.out.println();
        System.out.println("Сотрудники с минимальной заработной платой: ");
        printSeparator();
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() == min) {
                System.out.println(employee.getFullName() + " зароботная плата " + employee.getSalary());
            }
        }
        printSeparator();
    }

    //    Реализуем метод maxSalary (находим сотрудника с максимальной зарплатой)
    private static void maxSalary(Employee[] employees) {
        double max = employees[0].getSalary();
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() > max) {
                max = employee.getSalary();
            }
        }
        System.out.println();
        System.out.println("Сотрудники с максимальной заработной платой: ");
        printSeparator();
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() == max) {
                System.out.println(employee.getFullName() + " зароботная плата " + employee.getSalary());
            }
        }
        printSeparator();
    }

    //   Реализуем метод averageSalary для нахождения среднего значения зарплаты в месяц
    private static double averageSalary(Employee[] employees) {
        double sum = sumSalary(employees);
        return sum / size;
    }

    //    Реализуем метод printAllFullNames (распечатать список ФИО всех сотрудников)
    public static void printAllFullNames(Employee[] employees) {
        System.out.println();
        System.out.println("Список ФИО всех сотрудников:");
        printSeparator();
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            System.out.println(employee.getFullName());
        }
        printSeparator();
    }

    public static void printSeparator() {
        System.out.println("----------------------------");
    }
}