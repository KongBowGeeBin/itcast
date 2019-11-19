package junit.test;

import itcast.hjh.dao.impl.UserDaoImpl;
import itcast.hjh.domain.User;
import org.junit.Test;

import java.util.Date;

public class UserDaoTest {

    @Test
    public void testAdd(){
        User user = new User();
        user.setId("234");
        user.setUsername("李四");
        user.setPassword("234");
        user.setEmail("234@163.com");
        user.setBirthday(new Date());
        user.setNickname("li si");

        UserDaoImpl dao = new UserDaoImpl();
        dao.add(user);
    }

    @Test
    public void testFind(){
        User user1 = new User();
        User user2 = new User();
        UserDaoImpl dao = new UserDaoImpl();
        user1 = dao.find("张三","123");
        user2 = dao.find("李四","312");
    }

    @Test
    public void testFindByUsername(){
        UserDaoImpl dao = new UserDaoImpl();

        System.out.println(dao.find("李四"));
    }

}
