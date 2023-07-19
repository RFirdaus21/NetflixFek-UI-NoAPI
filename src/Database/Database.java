package Database;

import java.sql.*;

public class Database {
    private static Database instance;
    private Connection connection;

    private Database() {
        // Private constructor to prevent direct instantiation
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/netflix";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connection Successfully");
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
        return connection;
    }

    public ResultSet resultQuery(String query) {
        try {
            Connection c = getInstance().getConnection();
            PreparedStatement p = c.prepareStatement(query);
            return p.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public String resultQuery(String query, String columnName) {
        try {
            Connection c = getInstance().getConnection();
            PreparedStatement p = c.prepareStatement(query);
            return p.executeQuery().getString(columnName);
        } catch (SQLException e) {
            System.out.println(e);
            return "";
        }
    }

    public boolean manipulationQuery(String query) {
        try {
            Connection c = getInstance().getConnection();
            PreparedStatement p = c.prepareStatement(query);
            p.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}
