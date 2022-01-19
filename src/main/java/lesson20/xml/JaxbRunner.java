package lesson20.xml;

/*
(+) 1. Создать класс сотрудников Employee с атрибутами: табельный номер, логин, ФИО, подразделение и город
(в рамках объекта класса департамента), должность и зарплата (в рамках объекта класса должность)
(+) 2. Необходимо с помощью технологии JAXB произвести процедуру маршалинга состояния объектов данного класса
во внешний файл employee.xml.
(+) 3. С помощью XPath выражения найти всех сотрудников, у которых зарплата превышает среднее значение
(-) 4*. Преобразовать содержимое файла empolyee.xml в JSON-формат, получив на выходе employee.json
(-) 5*. С помощью Jackson получить список объектов Employee и вывести информацию о сотрудниках с нечетными индексами в списке.
 */

import jakarta.xml.bind.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JaxbRunner {
    public static void main(String[] args) throws JAXBException, IOException {
        Position[] positions = {
                new Position("Специалист", 50000),
                new Position("Главный специалист", 80000),
                new Position("Руководитель", 150000),
                new Position("Директор", 300000)
        };
        Department[] departments = {
                new Department("Отдел кадров", "Казань"),
                new Department("Канцелярия", "Воронеж"),
                new Department("Упраление продаж", "Владивосток"),
                new Department("Транспортный отдел", "Ялта"),
        };

        Employee[] employees = new Employee[20];
        for (int i = 0; i < 10; i++) {
            int j = new Random().nextInt(4);
            employees[i] = new Employee();
            employees[i].setEmployeeID(i);
            employees[i].setLogin(i + "2");
            employees[i].setFullName("Ivanov" + i);
            employees[i].setPosition(positions[j]);
            employees[i].setUnit(departments[j]);
        }

        EmployeeWrapper employeeWrapper = new EmployeeWrapper();
        employeeWrapper.setEmployeeList(Arrays.asList(employees));

        JAXBContext xmlText = JAXBContext.newInstance(EmployeeWrapper.class);
        Marshaller marshaller = xmlText.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter outString = new StringWriter();
        marshaller.marshal(employeeWrapper, outString);

        String result = outString.toString();
        FileWriter xmlFile = new FileWriter("src/main/resources/employee.xml");
        xmlFile.write(result);
        xmlFile.close();

        FileReader xmlFileRead = new FileReader("src/main/resources/employee.xml");
        Scanner scan = new Scanner(xmlFileRead);
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
    }
}