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
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JaxbRunner {
    public static void main(String[] args) throws Exception {
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
        for (int i = 0; i < 20; i++) {
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

        //С помощью XPath выражения найти всех сотрудников, у которых зарплата превышает среднее значение

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File("src/main/resources/employee.xml"));

        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();

        double avg = (Double) xpath.compile("sum(//Position/salary) div count(//Position/salary)").evaluate(doc, XPathConstants.NUMBER);

        System.out.println(" ");
        System.out.println("Среднее значение зарплаты: " + avg);
        System.out.println(" " );
        System.out.println("Сотрудники с заработной платой выше средней: " );

        XPathExpression expr = xpath.compile("//Employee/Position[salary >" + avg +"]");
        Object resultXls = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) resultXls;

        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(i + 1 + ". " +
                               nodes.item(i).
                               getParentNode().
                               getChildNodes().
                               item(5).
                               getTextContent() +
                               nodes.item(i).getTextContent());

        }


    }
}