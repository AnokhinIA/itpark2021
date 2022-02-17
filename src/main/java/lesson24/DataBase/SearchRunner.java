package lesson24.DataBase;

import lesson24.DataBase.dto.Book;

import java.sql.*;
import java.util.Scanner;

public class SearchRunner {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/db";
        String user = "user";
        String password = "password";
        Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement st = connection.prepareStatement("SELECT * FROM books WHERE author LIKE ?;");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите автора для поиска: ");
        String authorName = "%" + scanner.next() + "%";
        st.setString(1, authorName);

        try {
            ResultSet resultSet = st.executeQuery();
            int i = 1;
            System.out.println("\n Найдены следующие книги: ");
            while (resultSet.next()) {
                Book book = new Book();
                book.setIsbn(resultSet.getString(2));
                book.setName(resultSet.getString(3));
                book.setAuthor(resultSet.getString(4));
                book.setLink(resultSet.getString(5));
                book.setPages(resultSet.getInt(6));
                book.setYear(resultSet.getInt(7));
                book.setPrice(resultSet.getBigDecimal(8));
                System.out.println(i + ". " + book);
                i++;
            }

        } catch (SQLSyntaxErrorException e) {
            System.out.println("Таблица не создана, необходимо запустить класс DbPrepare для подготовки." + e.getMessage());
        }

        connection.close();
        st.close();
    }
}
