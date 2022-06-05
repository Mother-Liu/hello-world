package com.jdbc.test;

import java.sql.*;

public class DBConnection {
    static final String DB_url = "jdbc:mysql://localhost:3306/OnlineOrder";
    static final String username = "root";
    static final String password = "liuma";

    public void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_url,username,password);
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM customer";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + " " + name);
            }
            resultSet.close();
            statement.close();
            conn.close();
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}
