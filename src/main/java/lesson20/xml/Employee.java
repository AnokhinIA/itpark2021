package lesson20.xml;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data

public class Employee {
    private int employeeID;
    private String login;
    private String fullName;
    @XmlElement(name = "Department")
    private Department unit;
    @XmlElement(name = "Position")
    private Position position;

    @Override  // для тестирования корректного заполнения
    public String toString() {

        return "табельный номер: " + this.employeeID + "|" +
                "логин:" + this.login + "|" +
                "ФИО: " + this.fullName + "|" +
                "подразделение: " + this.unit.getUnit() + " в городе: " + this.unit.getTown() + "|" +
                "должность: " + this.position.getPosition() + " c зарплатой: " + this.position.getSalary() + "|";

    }


}
