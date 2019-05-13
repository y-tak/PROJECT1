package db;

import java.sql.*;

public class JDBCExample {

    public static void main(String[] args) {
        try {
            createTable();
            insertIntoBook("Book1",123);
            insertIntoBook("Book2",133);
            insertIntoBook("Book3",121);
            insertIntoBook("Book4",12);
            insertIntoBook("Book5",120);
            selectAll();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable() throws ClassNotFoundException {
        String sqlCreate;

        sqlCreate = "CREATE TABLE IF NOT EXIST" +
                "BookShop (  id SERIAL PRIMARY KEY," +
                "            title TEXT NOT NULL," +
                "            pageCount INTEGER NOT NULL) ";
        ////подключаем класс
        Class.forName("org.postgresql.Driver");

        ///Class.forName("org.sqllite.Driver");
        //"jdbc:sqllite:example.db"


        try (Connection connection
                     = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exampleDB", "root", "root")) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sqlCreate);
                System.out.println(" statement.executeUpdate(sqlCreate)");

                ///  statement.executeUpdate();//вернет число - сколько было изменено строк, не надо получать данные
                ////   statement.executeQuery();//вернет набор данных
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void insertIntoBook(String title, int pagecount) throws ClassNotFoundException, SQLException {
        String sqlInsert;
        sqlInsert = "INSERT INTO BookShop (title,pagecount) VALUE (?,?)";
        Class.forName("org.postgresql.Driver");
        try (Connection connection
                     = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exampleDB", "root", "root")) {
            try (PreparedStatement statement = connection.prepareStatement(sqlInsert)) {
                 statement.setString(1,title);
                 statement.setInt(2,pagecount);
                 ///---добавили данные-----------
                 int res=statement.executeUpdate();

                }
            } catch (SQLException e1){

                e1.printStackTrace();
            }


    }

    public  static void selectAll()
    {
        String sqlInsert;
        sqlInsert = "SELECT * FROM BookShop ";
        String sqlInsert1 = "SELECT * FROM BookShop WHERE id=2";
        String sqlInsert2 = "SELECT * FROM BookShop WHERE pageCount>89";
        String sqlInsert3 = "SELECT * FROM BookShop WHERE pageCount BETWEEN 34 AND 89";


      //  String sqlDELET = "DELETE  FROM BookShop WHERE pageCount BETWEEN 34 AND 89";

      //  String sqlUpdate = "UPDATE  FROM BookShop WHERE pageCount =34";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection
                     = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exampleDB", "root", "root")) {

            try (Statement statement=connection.createStatement())
            {
                ResultSet resultSet=statement.executeQuery(sqlInsert);
                while (resultSet.next())
                {
                    String title=resultSet.getString("title");
                    int pageCount=resultSet.getInt("pageCount");
                    System.out.println("pageCount = " + pageCount);
                    System.out.println("title = " + title);
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}



