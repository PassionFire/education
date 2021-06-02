package com.offcn.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 封装连接池工具类
 * 目的： 让程序运行到结束都只有一个连接池对象
 * 作用： 用户可以从工具类获得数据库连接对象
 * 并发：
 */
public class JdbcUtils {
    private static ComboPooledDataSource dataSource;

    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    static{
        //创建连接池对象
        dataSource = new ComboPooledDataSource();
    }

    //获取数据库连接
    public static Connection getConnection() throws SQLException {
        //当前线程下是否有可以直接使用的数据库连接
        Connection connection = tl.get();
        if(connection==null){
            connection = dataSource.getConnection();
            tl.set(connection);
        }
        return connection;
    }

    //释放数据库连接
    public static void close(){
        try {
            //获取当前线程下的数据库连接
            Connection connection = tl.get();
            //脱离数据库连接和当前线程的关系
            tl.remove();
            //脱离后可以释放
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
