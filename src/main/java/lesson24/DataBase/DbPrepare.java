package lesson24.DataBase;
import java.sql.*;

public class DbPrepare {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/db";
        String user = "user";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement st = connection.createStatement();
            try {
                st.execute("""
                        CREATE TABLE books (id SERIAL,
                                            isbn VARCHAR(50),
                                            name VARCHAR(500),
                                            author VARCHAR(200),
                                            link VARCHAR(1000),
                                            pages INT,
                                            year INT,
                                            price DECIMAL(8,2),
                                            PRIMARY KEY (id))
                                            ENGINE InnoDB CHARACTER SET utf8;
                        """);
                System.out.println("Таблица создана");
            } catch (SQLSyntaxErrorException e) {
                System.out.println("Ошибка при создании таблицы: " + e.getMessage());
                ResultSet resultSet = st.executeQuery("SELECT COUNT(*) FROM books");
                System.out.println(resultSet.getInt(1));
            }
        }
    }
}
