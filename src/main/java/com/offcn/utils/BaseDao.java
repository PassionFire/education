package com.offcn.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BaseDao<T> {

    QueryRunner queryRunner = new QueryRunner();

    //通用的增删改
    public int update(String sql, Object... params) {
        try {
            return queryRunner.update(JdbcUtils.getConnection(), sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        } finally {
            JdbcUtils.close();
        }
    }


    //通用查询单条
    public T getOne(String sql, Class clazz, Object... params) {
        try {
            T t = queryRunner.query(JdbcUtils.getConnection(), sql, new BeanHandler<T>(clazz), params);
            return t;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        } finally {
            JdbcUtils.close();
        }
    }

    //通用查询多条
    public List<T> getMore(String sql, Class clazz, Object... params) {
        try {
            List<T> list = queryRunner.query(JdbcUtils.getConnection(), sql, new BeanListHandler<T>(clazz), params);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        } finally {
            JdbcUtils.close();
        }
    }
}
