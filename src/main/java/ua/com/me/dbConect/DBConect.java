package ua.com.me.dbConect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConect {

    String url="jdbc:mysql://localhost/db?autoReconnect=true&useSSL=false" ;
    String username = "root";
    String password = "root";

    Connection connection;


    public DBConect() {
        try {
            this.connection = DriverManager.getConnection(url,username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public void saveUser(String userName, String lastName){

    try {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER (NAME) VALUES ('"+ userName +" ')");
      preparedStatement = connection.prepareStatement("INSERT INTO USER (LASTNAME) VALUES ('"+ lastName +" ')");
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public  List<String> select(){
    List<String> users = new ArrayList<String>();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
        String id = resultSet.getString(1);
        String name = resultSet.getString(2);
        String lastName = resultSet.getString(3);
        String user = id + " " + name + " " + lastName ;
        users.add(user);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
return users;

}



}
