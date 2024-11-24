import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShopDatabase {
    private static final String URL = "jdbc:postgresql://localhost:5432/shop";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver"); // Load the PostgreSQL driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("PostgreSQL driver not found.");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}