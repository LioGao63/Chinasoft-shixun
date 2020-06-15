package com.chinasoft.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/csi?characterEncoding=UTF-8",
				"root", "12345678"); Statement s = c.createStatement();) {

			String sql = "select * from user";

			// 执行查询语句，并把结果集返回给ResultSet
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);// 可以使用字段名
				String name = rs.getString(2);// 也可以使用字段的顺序
				System.out.println(id+' '+name);
			}
			// 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
			// rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
