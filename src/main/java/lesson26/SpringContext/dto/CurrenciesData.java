package lesson26.SpringContext.dto;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data

public class CurrenciesData {
    private Date Date;
    private Date PreviousDate;
    private String PreviousURL;
    private Date Timestamp;
    private Map<String, Valute> Valute;

    public void searchCurrency(String currency) {
        System.out.println("На дату: " + this.Date + this.Valute.get(currency));

    }
}

