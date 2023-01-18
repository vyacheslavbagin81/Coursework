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

        // Метод для изменения зарплаты, передаем параметр int salaryIncreaseRatio - на какой процент меняем зарплату
        changeSalary(employee, 10);
        // Выводим список с новыми зарплатами
        printAllEmployees(employee);

        // Новый класс для работы с отделом
        WorkingWithTheDepartment workingWithTheDepartment = new WorkingWithTheDepartment(employee, size);

        // Метод для вывода списка сотрудников с минимальной зарплатой по отделу, задаем в параметре номер отдела
        workingWithTheDepartment.minSalaryByDepartment(1);

        // Метод для вывода списка сотрудников с максимальной зарплатой по отделу, задаем в параметре номер отдела
        workingWithTheDepartment.maxSalaryByDepartment(1);

        // Реализуем метод printSumSalaryDepartment для вывода суммы затрат на зарплаты в месяц по отделу, задаем в параметре номер отдела
        workingWithTheDepartment.printSumSalaryDepartment(1);

        //Реализуем метод printAverageSalary для нахождения среднего значения зарплаты в месяц по отделу, задаем в параметре номер отдела
        workingWithTheDepartment.printAverageSalary(1);

        // Метод для изменения зарплаты, задаем в параметре номер отдела
        // и передаем параметр int salaryIncreaseRatioOfDepartment - на какой процент меняем зарплату
        workingWithTheDepartment.changeSalary(1, 10);
        // Выводим список с новыми зарплатами
        workingWithTheDepartment.printAllEmployeesDepartment(1);


        //    Метод для поиска сотрудников с зарплатой ниже заданной, в параметре передаем значение для сравнения
        searchForASalaryBelow(employee, averageSalary(employee));

        //    Метод для поиска сотрудников с зарплатой выше или равной заданной, в параметре передаем значение для сравнения
        searchForAHigherSalary(employee, averageSalary(employee));

    }


    //    Реализуем метод addEmployee (добовить сотрудника)
    public static Employee addEmployee(Employee[] employees, String fullName, int department, double salary) {
        if (size >= employees.length) {
            System.out.println("Нельзя добавить данные, закончилось место");
        }
        Employee newEmployee = new Employee(fullName, department, salary);
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

    // Метод для изменения зарплаты
    public static void changeSalary(Employee[] employees, int salaryIncreaseRatio) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            employee.setSalary(employee.getSalary() + employee.getSalary() * salaryIncreaseRatio / 100);
        }
    }

    //    Метод для поиска сотрудников с зарплатой ниже заданной
    public static void searchForASalaryBelow(Employee[] employees, double parameter) {
        System.out.println();
        System.out.println("Список сотрудников с заработной платой менее " + parameter + " ");
        printSeparator();
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() < parameter) {
                System.out.println("id-" + employee.getId() + " " + employee.getFullName() + " Заработная плата: " + employee.getSalary());
            }
        }
        printSeparator();
    }

    //    Метод для поиска сотрудников с зарплатой выше заданной
    public static void searchForAHigherSalary(Employee[] employees, double parameter) {
        System.out.println();
        System.out.println("Список сотрудников с заработной платой выше " + parameter + " ");
        printSeparator();
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() >= parameter) {
                System.out.println("id-" + employee.getId() + " " + employee.getFullName() + " Заработная плата: " + employee.getSalary());
            }
        }
        printSeparator();
    }

    public static void printSeparator() {
        System.out.println("----------------------------");
    }
}