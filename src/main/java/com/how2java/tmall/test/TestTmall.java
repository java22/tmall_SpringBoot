package com.how2java.tmall.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 凌风的MI
 * 测试类
 */
public class TestTmall {

    public static void main(String[] args) {
        //准备分类测试数据:

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmall_springboot?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai", "root", "root");
                Statement s = c.createStatement();
                ) {
            for (int i=1; i<=10; i++){
                String sqlFormat = "insert into category values (null, '测试分类%d')";
                String sql = String.format(sqlFormat, i);
                s.execute(sql);
            }

            System.out.println("已经成功创建10条分类测试数据");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
