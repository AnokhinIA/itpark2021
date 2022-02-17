package lesson24.DataBase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Book {
    private String isbn = "";
    private String name = "";
    private String author = "";
    private String link = "";
    private int pages = 0;
    private int year = 0;
    private BigDecimal price = BigDecimal.valueOf(0.00);

    @Override
    public String toString() {
        return  "Название книги: " + name + " |" +
                "ISBN: " + isbn + " |" +
                "Автор: " + author + " |" +
                "Количество страниц: " + pages + " |" +
                "Год выпуска: " + year + " |" +
                "Цена: " + price + " рублей" + " |" + "\n" +
                "Ссылка на интернет магазин: " + link;
    }
}
