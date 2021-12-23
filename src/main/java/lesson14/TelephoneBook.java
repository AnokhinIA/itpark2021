package lesson14;

import java.util.List;

public class TelephoneBook implements Comparable<TelephoneBook> {
    private final String fullName;
    private final int phoneNumber;
    private List<Integer> associatePhone;
    private Integer[] associatePhone2;

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    private int frequency;

    public TelephoneBook(String fullName, int phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(TelephoneBook o2) {
        return o2.getFrequency() - this.getFrequency();
    }

    @Override
    public String toString() {
        return "ФИО: " + fullName + " | " + " Номер телефона: " + phoneNumber + " Встречается " + frequency;
    }


    public int getPhoneNumber() {
        return phoneNumber;
    }


    public List<Integer> getAssociatePhone() {
        return associatePhone;
    }

    public void setAssociatePhone(List<Integer> associatePhone) {
        this.associatePhone = associatePhone;
    }

    public void setAssociatePhone2(Integer[] associatePhone2) {
        this.associatePhone2 = associatePhone2;

    }

    public Integer[] getAssociatePhone2() {
        return associatePhone2;
    }
}
