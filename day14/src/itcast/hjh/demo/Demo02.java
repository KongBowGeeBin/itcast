package itcast.hjh.demo;

import itcast.hjh.domain.User;

import java.sql.*;
import java.lang.Class;

public class Demo02 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://139.88.4.133:3306/day14?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
        String username = "hjh";
        String password = "95599nba";

        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取数据库连接
        Connection conn = DriverManager.getConnection(url,username,password);

        //3.获取向数据发sql语句的statment对象
        Statement st = conn.createStatement();

        //4.向数据库发送sql，获取数据库返回的结果集
        ResultSet rs = st.executeQuery("select * from users");

        //5.从结果集中获取数据
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setBirthday(rs.getDate("birthday"));
        }

        //6.释放资源
        rs.close();
        st.close();
        conn.close();
    }
}
