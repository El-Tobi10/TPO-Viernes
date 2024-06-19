import java.sql.*;

public class ConeccionSQL {
    public static void main(String[] args) {

        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://TobiasDB:1433;DatabaseName=TPO;user=toto;Password=tobias123";

        Connection conector = null;
        Statement stm = null;
        ResultSet resultado = null;

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
            conector = DriverManager.getConnection(connectionUrl);
            System.out.println("Coneccion exitosa papaaa");
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println("Error de coneccion " + e);
        }
    }
}
