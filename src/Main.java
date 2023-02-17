public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        /** Метод addEmployee для добавления сотрудника */
        employeeBook.addEmployee("Иванов Иван Иванович", 1, 51500);
        employeeBook.addEmployee("Сидоров Олег Петрович", 5, 150500);
        employeeBook.addEmployee("Петров Петр Петрович", 3, 50500);
        employeeBook.addEmployee("Капустина Марина Ивановна", 2, 75500);
        employeeBook.addEmployee("Поликарпов Инокентий Винеаминович", 1, 75500);
        employeeBook.addEmployee("Берлиоз Михаил Александрович", 4, 75500);
        employeeBook.addEmployee("Соков Андрей Фокич", 5, 45500);
        employeeBook.addEmployee("Босой Никанор Иванович", 4, 64000);
        employeeBook.addEmployee("Лиходеев Степан Богданович", 3, 45500);
        employeeBook.addEmployee("Римский Григорий Данилович", 2, 64000);

        /** Метод printAllEmployees() для вывода списка сотрудников */
        employeeBook.printAllEmployees();

        /** Метод printAllEmployees() для вывода суммы затрат на заработную плату за месяц */

        employeeBook.printSumSalary();

        /** Метод printAverageSalary() для вывода средней заработной платы за месяц */
        employeeBook.printAverageSalary();

        /** Метод printMinSalary() для вывода списка сотрудников с минимальной заработной платой*/
        employeeBook.printMinSalary();

        /** Метод printMaxSalary() для вывода списка сотрудников с максимальной заработной платой*/
        employeeBook.printMaxSalary();

        /** Метод printAllFullNames() для вывода ФИО сотрудников */
        employeeBook.printAllFullNames();

        /** Метод changeSalary() для изменения зароботной платы сотрудников
         * в параметре задаем процент изменения */
        System.out.println();
        employeeBook.changeSalary(20);
        System.out.println("Данные после индексации заработной платы");
        employeeBook.printAllEmployees();

        /** Класс WorkingWithTheDepartment для работы с отделом */
        WorkingWithTheDepartment workingWithTheDepartment = new WorkingWithTheDepartment(employeeBook.getEmployees(), employeeBook.getSize());

        /** Метод minSalaryByDepartment() для вывода списка сотрудников с минимальной заработной платой по отделу
         * в качестве параметра задается номер отдела*/
        workingWithTheDepartment.minSalaryByDepartment(1);

        /** Метод minSalaryByDepartment() для вывода списка сотрудников с максимальной заработной платой по отделу
         * в качестве параметра задается номер отдела*/
        workingWithTheDepartment.maxSalaryByDepartment(1);

        /** Метод printSumSalaryDepartment() для вывода суммы затрат на заработную плату за месяц по отделу
         * в качестве параметра задается номер отдела */
        workingWithTheDepartment.printSumSalaryDepartment(1);

        /** Метод printAverageSalary() для вывода средней заработной платы за месяц по отделу
         * в качестве параметра задается номер отдела */
        workingWithTheDepartment.printAverageSalary(1);

        /** Метод changeSalary() для изменения зароботной платы сотрудников по отделу
         * в параметре задаем номер отдела процент изменения */
        System.out.println();
        workingWithTheDepartment.changeSalary(1, 10);
        System.out.println("Данные после индексации заработной платы");
        workingWithTheDepartment.printAllEmployeesDepartment(1);

        /** Метод searchForASalaryBelow для вывода списка сотрудников с заработной платой ниже заданной
         * в параметре задаем данные для сравнения */
        employeeBook.searchForASalaryBelow(70000);

        /** Метод searchForAHigherSalary для вывода списка сотрудников с заработной платой выше или равной заданной
         * в параметре задаем данные для сравнения */
        employeeBook.searchForAHigherSalary(70000);

        /** Метод removeEmployee для удаления сотрудника по ФИО или id
         * в параметрах задаем ФИО и id */
        employeeBook.removeEmployee("Петров Петр Петрович", 3);

        /** Метод printAllEmployees() для вывода списка сотрудников */
        employeeBook.printAllEmployees();

        /** Метод changingSalaryByName() для изменению заработной платы сотрудника
         * в параметрах задаем ФИО и процнет изменения зарплаты */
        employeeBook.changingSalaryByName("Поликарпов Инокентий Винеаминович", 10);

        /** Метод changingDepartmentByName() для перевода сотрудника в другой отдел
         * в параметрах задаем ФИО и номер нового отдела*/
        employeeBook.changingDepartmentByName("Римский Григорий Данилович", 3);
    }
}