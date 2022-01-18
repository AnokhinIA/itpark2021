package lesson20.xml;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Employee {

     private int employeeID;
     private String login;
     private String fullName;
     private Department unit;
     private Position position;

     @Override  // для тестирования корректного заполнения
     public String toString() {

          return "табельный номер: " + this.employeeID + "|" +
                  "логин:" + this.login + "|" +
                  "ФИО: " + this.fullName + "|" +
                  "подразделение: " + this.unit.getUnit() + " в городе: " + this.unit.getTown() + "|";

     }
}
