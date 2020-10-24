package server;

import java.sql.*;

public class SQLHendler {
    static Connection connection;
    static Statement statement;


    public static void connectToDb() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Подключение не удалось");
        }
        System.out.println("Сервер подключен к mainDB");
    }

    public static void disconnect() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Не удалось отсоеденить БД");
        }
        System.out.println("SQLite отсоеденена");
    }

    public static void clearTable(){
        try {
            statement.executeUpdate("DELETE FROM Users;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void delete(String login){
        try {
            statement.executeUpdate("DELETE FROM Users WHERE login = '"+ login +"';");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void insert(String login, String password, String nickname){
        try {
            statement.executeUpdate("INSERT INTO Users (login, password, nickname) " +
                    "VALUES ('"+login+"', '"+password+"', '"+nickname+"');");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean updateNick(String currentNickname, String newNickname){
        try {
            statement.executeUpdate("UPDATE Users SET nickname='"+newNickname+"' WHERE nickname='"+currentNickname+"';");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public static boolean readUser(String login, String password){
        try {
            System.out.println("Читаю данные юзера из БД");
            ResultSet resultSet = statement.executeQuery("SELECT "+login+", "+password+" FROM Users");
            System.out.println("Считано успешно");
            return true;
        } catch (SQLException throwables) {
            System.out.println("Ошибка");
            return false;
        }
    }

}
