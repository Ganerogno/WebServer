package com.example.test;

import com.example.test.Controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

@SpringBootApplication
@ConfigurationProperties(prefix = "prod")
public class WebApplication {

//	public static final String USER_NAME = "root";
//	public static final String PASSWORD = "root";
//	public static final String URL = "jdbc:mysql://localhost:3306/mysql";
//	public static Statement statement;
//	public static Connection connection;
//	static {
//		try{
//			connection = DriverManager.getConnection(URL,USER_NAME, PASSWORD);
//		} catch (SQLException throwables){
//			throwables.printStackTrace();
//			throw new RuntimeException();
//		}
//	}
//	static {
//		try{
//			statement = connection.createStatement();
//		} catch (SQLException throwables){
//			throwables.printStackTrace();
//			throw new RuntimeException();
//		}
//	}
	@Autowired
	private UserController userController;
	public static void main(String[] args) throws  ClassNotFoundException, SQLException{

		SpringApplication.run(WebApplication.class, args);
//		System.out.println(path.toAbsolutePath());
//		Class.forName("com.mysql.cj.jdbc.Driver");
//
//		statement.executeUpdate("USE online_store");
//		statement.executeUpdate("CREATE TABLE carShop (" +
//				"id int auto_increment primary key," +
//				"name varchar(30) not null," +
//				"quantity varchar(10) not null," +
//				"price varchar(10) not null)");
//		statement.executeUpdate("INSERT INTO carShop (name, quantity, price) value ('Patrol','12','12')");
//		ResultSet resultSet = statement.executeQuery("SELECT * FROM carShop");
//		while(resultSet.next()){
//			System.out.println(resultSet.getString(2) + " " +
//					resultSet.getString(3) + " " +
//					resultSet.getString(4));
		//}
	}

}
