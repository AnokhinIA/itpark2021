package lesson13;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class EmployeeUtils {
    public static void main(String[] args) {

        List<Employee> employee = new ArrayList<>();

        int numbers = 50; // Общее число сотрудников в компании

        for (int i = 0; i <= numbers; i++) {
            String fullName = "Ivanov" + i;
            int occupationalLife = (int) Math.round(Math.random() * 10) + 1;
            int employeeID = i + 1;
            employee.add(new Employee(fullName, employeeID, occupationalLife));
        }

        int workAge = 6; //искомое значение срока работы в компании

        System.out.println("Вывод списка сотрудников с возрастом работы в компании (год/лет): " + workAge);
        System.out.println("=============================================================================");

        ListIterator<Employee> employeeIterator = employee.listIterator();
        while (employeeIterator.hasNext()) {
            Employee item = employeeIterator.next();
            if (item.getOccupationalLife() == workAge) System.out.println(employeeIterator.nextIndex() + ". " + item);
        }

        System.out.println("");
        System.out.println("Удаление нечетных позиций списка и вывод всех оставшихся значений коллекции, из  " + employeeIterator.nextIndex() + " элементов");
        System.out.println("=============================================================================");


        if (employeeIterator.nextIndex() % 2 != 0) employeeIterator.remove();
        while (employeeIterator.hasPrevious()) {
            employeeIterator.previous();
            employeeIterator.previous();
            employeeIterator.remove();
        }

        while (employeeIterator.hasNext()) {
            System.out.println(employeeIterator.next());
        }

    }
}