package com.subin.framework.mybatis.my;

import com.subin.framework.mybatis.beans.Test;

import java.sql.*;

/**
 * @author: subiin
 * @date: 2018/2/28 上午10:26
 * @description:
 */
public class SimpleExecutor implements Executor {
    public <E> E query(String sql, Object parameter) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(String.format(sql, Integer.valueOf(String.valueOf(parameter))));
            ResultSet resultSet = preparedStatement.executeQuery();
            Test test = new Test();
            while (resultSet.next()) {
                test.setId(resultSet.getInt(1));
                test.setName(resultSet.getString(2));
            }
            return (E) test;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Connection getConnection() throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/em?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
