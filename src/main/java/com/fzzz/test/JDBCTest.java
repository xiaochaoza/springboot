package com.fzzz.test;

import java.sql.*;

/**
 * jdbc 的方式实现数据库交互
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/springboot";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
            String sql = "select * from user where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数
            preparedStatement.setInt(1, 1);
            //执行查询
            resultSet = preparedStatement.executeQuery();
            // 处理结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getString("user_name"));
                System.out.println(resultSet.getString("pass_word"));
            }
        } finally {
            if (null != connection) {
                connection.close();
            }
            if (null != preparedStatement) {
                preparedStatement.close();
            }
            if (null != resultSet) {
                resultSet.close();
            }
        }
    }
}
