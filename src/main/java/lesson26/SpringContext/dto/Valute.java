package lesson26.SpringContext.dto;

import java.math.BigDecimal;

public class Valute {
    private String ID;
    private Integer NumCode;
    private String CharCode;
    private String Nominal;
    private String Name;
    private BigDecimal Value;
    private BigDecimal Previous;

    @Override
    public String toString() {
        return
                "\nКурс валюты " + Name +
                        ": " + Value +
                        " рублей.";
    }
}
