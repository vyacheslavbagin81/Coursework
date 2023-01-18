public class EmployeeBook {
    private final Employee[] employees;
    private int size;
    private int id = 0;

    public Employee[] getEmployees() {
        return employees;
    }

    public int getSize() {
        return size;
    }

    public int getId() {
        return id;
    }

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    //    Реализуем метод addEmployee (добовить сотрудника)
    public void addEmployee(String fullName, int department, double salary) {
        if (size >= employees.length) {
            System.out.println("Нельзя добавить данные, закончилось место");
        }
        Employee newEmployee = new Employee(fullName, department, salary);
        id++;
        newEmployee.setId(id);
        employees[size++] = newEmployee;
    }

    // Реализуем метод removeEmployee (удалить сотрудника)
    // Метод сдвигает массив влево на ячейку, удаляя ячейку под номером i
    public void removeEmployee(String name, int id) {
        System.out.println();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullName().equals(name) || employees[i].getId() == id) {
                System.out.println(employees[i].getFullName() + " удален");
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return;
            }
        }
    }

    //    Реализуем метод printAllEmployees (распечатать список всех сотрудников)
    public void printAllEmployees() {
        System.out.println();
        System.out.println("Список сотрудников:");
        printSeparator();
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            System.out.println(employee);
        }
        printSeparator();
    }

    //    Реализуем метод printAllFullNames (распечатать список ФИО всех сотрудников)
    public void printAllFullNames() {
        System.out.println();
        System.out.println("Список ФИО всех сотрудников:");
        printSeparator();
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            System.out.println(employee.getFullName());
        }
        printSeparator();
    }

    //   Реализуем метод sumSalary для подсчета суммы затрат на зарплаты в месяц
    private double sumSalary() {
        double sumSalary = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            sumSalary = sumSalary + employee.getSalary();
        }
        return sumSalary;
    }

    public void printSumSalary() {
        System.out.println();
        System.out.println("Сумма затрат на заработную плату за месяц: " + sumSalary());
        printSeparator();
    }

    //   Реализуем метод averageSalary для нахождения среднего значения зарплаты в месяц
    private double averageSalary() {
        double sum = sumSalary();
        return sum / size;
    }

    public void printAverageSalary() {
        System.out.println();
        System.out.println("Среднее значение заработной платы в месяц: " + averageSalary());
        printSeparator();
    }

    //    Реализуем метод minSalary (находим сотрудника с минимальной зарплатой)
    private double minSalary() {
        double min = employees[0].getSalary();
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() < min) {
                min = employee.getSalary();
            }
        }
        return min;
    }

    //    Реализуем метод maxSalary (находим сотрудника с максимальной зарплатой)
    private double maxSalary() {
        double max = employees[0].getSalary();
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() > max) {
                max = employee.getSalary();
            }
        }
        return max;
    }

    // Реализуем метод printSalaryEmployee для вывода зарплаты сотрудника
    private void printSalaryEmployee(double x) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() == x) {
                System.out.println(employee.getFullName() + " зароботная плата " + employee.getSalary());
            }
        }
    }

    //    Метод для вывода списка сотрудников с минимальной заработной платой
    public void printMinSalary() {
        System.out.println();
        System.out.println("Сотрудники с минимальной заработной платой: ");
        printSeparator();
        printSalaryEmployee(minSalary());
        printSeparator();
    }

    //    Метод для вывода списка сотрудников с максимальной заработной платой
    public void printMaxSalary() {
        System.out.println();
        System.out.println("Сотрудники с максимальной заработной платой: ");
        printSeparator();
        printSalaryEmployee(maxSalary());
        printSeparator();
    }

    // Метод для изменения зарплаты
    public void changeSalary(int salaryIncreaseRatio) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            employee.setSalary(employee.getSalary() + employee.getSalary() * salaryIncreaseRatio / 100);
        }
    }

    //    Метод для поиска сотрудников с зарплатой ниже заданной
    public void searchForASalaryBelow(double parameter) {
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

    //    Метод для поиска сотрудников с зарплатой выше или равной заданной
    public void searchForAHigherSalary(double parameter) {
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

    //    Изменяем зарплату по ФИО
    public void changingSalaryByName(String fullName, int salaryIncreaseRatio) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (fullName.equals(employee.getFullName())) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * salaryIncreaseRatio / 100);
                System.out.println("Заработная плата сотрудника " + employee.getFullName() + " увеличена на " + salaryIncreaseRatio + "% и составляет " + employee.getSalary());
                printSeparator();
                break;
            }
        }

    }

    // Изменяем отдел по ФИО
    public void changingDepartmentByName(String fullName, int department) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (fullName.equals(employee.getFullName())) {
                employee.setDepartment(department);
                System.out.println("Сотрудник " + employee.getFullName() + " переведен в " + department + " отдел");
                printSeparator();
                break;
            }
        }
    }

    //    Выводим список всех сотрудников по отделам
    public void printAllEmployeesDepartament() {
        int j = 1;
        System.out.println();
        System.out.println("Список сотрудников отдела по отделам");
        printSeparator();
        while (j < 6) {
            System.out.println("Отдел №" + j);
            for (int i = 0; i < size; i++) {
                Employee employee = employees[i];
                if (j == employees[i].getDepartment()) {
                    System.out.println(employee);
                }
            }
            j++;
            printSeparator();
        }
    }

    private void printSeparator() {
        System.out.println("-------------------------------");
    }
}
