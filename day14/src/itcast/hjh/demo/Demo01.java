package itcast.hjh.demo;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class Demo01 {

    /*
     create database day14;
     use day14;
     create table users
     (
        id int primary key,
        name varchar(40),
        password varchar(40),
        email varchar(60),
        birthday date
     );
     insert into users(id,name,password,email,birthday) values(1,'zs','zs123','zs123@163.com','1980-01-01');
     insert into users(id,name,password,email,birthday) values(2,'ls','ls123','ls123@163.com','1981-02-02');
     insert into users(id,name,password,email,birthday) values(3,'ww','ww123','ww123@163.com','1982-03-03');
     */
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://139.88.4.133:3306/day14?serverTimezone=UTC";
        String username = "hjh";
        String password = "95599nba";

        //1.加载驱动
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //2.获取数据库连接
        Connection conn = DriverManager.getConnection(url,username,password);
        //3.获取向数据发sql语句的statment对象
        Statement st = conn.createStatement();
        //4.向数据库发送sql，获取数据库返回的结果集
        ResultSet rs = st.executeQuery("select * from users");
        //5.从结果集中获取数据
        while (rs.next()){
            System.out.println("id" + rs.getObject("id"));
            System.out.println("name" + rs.getObject("name"));
            System.out.println("password" + rs.getObject("password"));
            System.out.println("email" + rs.getObject("email"));
            System.out.println("birthday" + rs.getObject("birthday"));
        }

        //6.释放资源
        rs.close();
        st.close();
        conn.close();
    }
}
