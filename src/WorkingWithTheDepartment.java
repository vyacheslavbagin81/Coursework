public record WorkingWithTheDepartment(Employee[] employees, int size) {

    //    Реализуем метод printAllEmployees (распечатать список всех сотрудников)
    public void printAllEmployeesDepartment(int departmentNumber) {
        System.out.println();
        System.out.println("Список сотрудников отдела №" + departmentNumber);
        printSeparator();
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (departmentNumber == employees[i].getDepartment()) {
                System.out.println("id-" + employee.getId() + " " + employee.getFullName() + " Заработная плата: " + employee.getSalary());
            }
        }
        printSeparator();
    }

    // Сортировка по отделу вывод минимальной зарплаты
    public void minSalaryByDepartment(int departmentNumber) {
        System.out.println();
        System.out.println("Сотрудники с минимальной заработной платой в отделе " + departmentNumber);
        printSeparator();
        double min = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == departmentNumber) {
                min = employee.getSalary();
                break;
            }
        }
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == departmentNumber) {
                if (employee.getSalary() < min) {
                    min = employee.getSalary();
                }
            }
        }
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == departmentNumber) {
                if (employee.getSalary() == min) {
                    System.out.println(employee.getFullName() + " зароботная плата " + employee.getSalary());
                }
            }
        }
        printSeparator();
    }

    // Сортировка по отделу вывод максимальной зарплаты
    public void maxSalaryByDepartment(int departmentNumber) {
        System.out.println();
        System.out.println("Сотрудники с максимальной заработной платой в отделе " + departmentNumber);
        printSeparator();
        double max = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == departmentNumber) {
                max = employee.getSalary();
                break;
            }
        }
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == departmentNumber) {
                if (employee.getSalary() > max) {
                    max = employee.getSalary();
                }
            }
        }
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == departmentNumber) {
                if (employee.getSalary() == max) {
                    System.out.println(employee.getFullName() + " зароботная плата " + employee.getSalary());
                }
            }
        }
        printSeparator();
    }

    //   Реализуем метод sumSalary для подсчета суммы затрат на зарплаты в месяц
    private double sumSalary(int departmentNumber) {

        double sumSalary = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (departmentNumber == employee.getDepartment()) {
                sumSalary = sumSalary + employee.getSalary();
            }
        }
        return sumSalary;
    }

    // Выводим сумму затраз на заработную плату за месяц
    public void printSumSalaryDepartment(int departmentNumber) {
        System.out.println();
        System.out.println("Сумма затрат на заработную плату за месяц по отделу N" + departmentNumber + " " + sumSalary(departmentNumber));
    }

    //   Реализуем метод averageSalary для нахождения среднего значения зарплаты в месяц
    private double averageSalary(int departmentNumber) {
        double sum = sumSalary(departmentNumber);
        int j = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (departmentNumber == employee.getDepartment()) {
                j++;
            }
        }
        return sum / j;
    }

    // Выводим среднее значение заработной платы в месяц по отделу
    public void printAverageSalary(int departmentNumber) {
        System.out.println();
        System.out.println("Среднее значение заработной платы в месяц по отделу N" + departmentNumber + " " + averageSalary(departmentNumber));
    }

    // Метод для изменения зарплаты
    public void changeSalary(int departmentNumber, int salaryIncreaseRatioOfDepartment) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (departmentNumber == employee.getDepartment()) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * salaryIncreaseRatioOfDepartment / 100);
            }
        }
    }

    private void printSeparator() {
        System.out.println("-------------------------------");
    }
}
