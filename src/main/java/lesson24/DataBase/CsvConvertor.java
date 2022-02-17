package lesson24.DataBase;

/*
1.Создать ресурсный CSV-файл, в котором хранятся данные о книгах и их авторах (атрибуты книги ISBN, название, ссылка на интернет-магазин, количество страниц, прочие атрибуты).
(ознакомиться с библиотекой open CSV)
2.Разработать класс-запускатель, задача которого перекладывать данные из файла в таблицу/таблицы* (если на момент запуска таблица была не пуста, то предварительно ее подчищать).
3.Разработать консольное приложение, позволяющее находить книги по названию или автору (через вхождение).
 */

import com.opencsv.CSVReader;
import lesson24.DataBase.dto.Book;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CsvConvertor {

    static List<Book> books = new ArrayList<>();

    public static void main(String[] args) throws IOException, SQLException {

        String fileName = "src/main/resources/books.csv";

        try {
            books = cvtCollectionConvertor(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Файл с данными не найден: " + e.getMessage());
        }

        String url = "jdbc:mysql://localhost:3306/db";
        String user = "user";
        String password = "password";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement st = connection.createStatement();
        int numberOfRows;
        try {
            ResultSet resultSet = st.executeQuery("SELECT COUNT(*) FROM books");
            resultSet.next();
            numberOfRows = resultSet.getInt(1);
            if (numberOfRows != 0) numberOfRows = 0;

        } catch (SQLSyntaxErrorException e) {

            numberOfRows = -1;
        }

        switch (numberOfRows) {
            case -1:
                System.out.println("Таблица не создана, необходимо запустить класс DbPrepare для подготовки.");
                break;
            case 0:
                st.execute("TRUNCATE TABLE books");
                System.out.println("В таблице были данные. Очещено.");
                st.close();
            case 1:
                System.out.println("Таблица заполнена данными из CSV файла.");
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT into books (isbn, name, author, link, pages, year, price) values (?,?,?,?,?,?,?);");

                for (Book i : books) {
                    preparedStatement.setString(1, i.getIsbn());
                    preparedStatement.setString(2, i.getName());
                    preparedStatement.setString(3, i.getAuthor());
                    preparedStatement.setString(4, i.getLink());
                    preparedStatement.setInt(5, i.getPages());
                    preparedStatement.setInt(6, i.getYear());
                    preparedStatement.setBigDecimal(7, i.getPrice());
                    preparedStatement.execute();
                }
                preparedStatement.close();

            default:
                connection.close();
        }

    }

    private static List<Book> cvtCollectionConvertor(String fileName) throws IOException {

        FileReader csvFileRead = new FileReader(fileName);

        CSVReader csvReader = new CSVReader(csvFileRead);
        List<String[]> csvCollection = csvReader.readAll();

        for (int i = 1; i < csvCollection.size(); i++) {
            String[] k = csvCollection.get(i);
            Book book = new Book();
            book.setIsbn(k[0]);
            book.setName(k[1]);
            book.setAuthor(k[2]);
            book.setLink(k[3]);
            book.setPages(Integer.parseInt(k[4]));
            book.setYear(Integer.parseInt(k[5]));
            book.setPrice(new BigDecimal(k[6]));
            books.add(book);
        }
        csvFileRead.close();
        return books;
    }

}

