package lesson20.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@XmlRootElement(name = "Employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeWrapper {
    @XmlElement(name = "Employee")
    List<Employee> employeeList;

}
