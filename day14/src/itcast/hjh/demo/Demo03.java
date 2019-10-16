package itcast.hjh.demo;

import itcast.hjh.domain.User;
import itcast.hjh.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Demo03 {
    @Test
    public void insert() throws SQLException {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
            int num = st.executeUpdate("insert into users (id,name,password,email,birthday) values (4,'zl','zl123','zl123@qq.com','2010-02-03') ");
            if (num>0) {
                System.out.println("插入成功！！");
            }
        } finally {
            JDBCUtils.release(conn,st,rs);
        }

    }

    @Test
    public void update() throws SQLException {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
            int num = st.executeUpdate("update users set birthday = '2003-12-31' where id = '3'");
            if (num>0) {
                System.out.println("更新成功！！");
            }
        }finally {
            JDBCUtils.release(conn,st,rs);
        }
    }

    public void delete() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
            int num = st.executeUpdate("delete from users where id = '4'");
            if (num>0) {
                System.out.println("删除成功！！");
            }
        }finally {
            JDBCUtils.release(conn,st,rs);
        }
    }

    public void find() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select id,name,password,email,birthday from users where id = '1'");
            if (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
            }

        }finally {
            JDBCUtils.release(conn,st,rs);
        }
    }
    @Test
    public void getAll() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select id,name,password,email,birthday from users");
            List list = new ArrayList();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
                list.add(user);
            }
        }finally {
            JDBCUtils.release(conn,st,rs);
        }
    }

}
