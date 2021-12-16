package lesson13;

public class Employee {
    public String fullName;
    public int employeeID;
    public int occupationalLife;

    public Employee(String fullName, int employeeID, int occupationalLife) {
        this.fullName = fullName;
        this.employeeID = employeeID;
        this.occupationalLife = occupationalLife;
    }

    @Override
    public String toString() {
        String info = "ФИО: " + getFullName() + " | " + " Табельный номер: " + getEmployeeID()
                + " | " + "Стаж работы (год/лет): " + getOccupationalLife();
        return info;
    }

    public String getFullName() {
        return fullName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getOccupationalLife() {
        return occupationalLife;
    }
}
