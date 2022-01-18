package lesson20.xml;

/*
1. Создать класс сотрудников Employee с атрибутами: табельный номер, логин, ФИО, подразделение и город
(в рамках объекта класса департамента), должность и зарплата (в рамках объекта класса должность)
2. Необходимо с помощью технологии JAXB произвести процедуру маршалинга состояния объектов данного класса
во внешний файл employee.xml.
3. С помощью XPath выражения найти всех сотрудников, у которых зарплата превышает среднее значение
4*. Преобразовать содержимое файла empolyee.xml в JSON-формат, получив на выходе employee.json
5*. С помощью Jackson получить список объектов Employee и вывести информацию о сотрудниках с нечетными индексами в списке.
 */


import java.util.Random;

public class JaxbRunner {
    public static void main(String[] args) {
       Position[] positions = {
               new Position("Специалист", 50000),
               new Position("Главный специалист", 80000),
               new Position("Руководитель", 150000),
               new Position("Директор", 300000)
        };
       Department[] departments = {
               new Department("Отдел кадров", "Москва"),
               new Department("Канцелярия", "Москва"),
               new Department("Упраление продаж", "Москва"),
               new Department("Транспортный отдел", "Москва"),
       };

       Employee[] employees = new Employee[20];
       for (int i = 0; i < 20; i++){
           int j = new Random().nextInt(4);
           employees[i] = new Employee(i,i+"2","Ivanov" +i,departments[j],positions[j]);
       }

        /* вывод в консоль для тестирования корректности заполнения
        for (Employee j: employees){
          System.out.println(j.toString());
        }
        */
    }
}
