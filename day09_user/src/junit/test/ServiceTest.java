package junit.test;

import itcast.hjh.Exception.UserExistException;
import itcast.hjh.domain.User;
import itcast.hjh.service.impl.BusinessServiceImpl;
import org.junit.Test;

import java.util.Date;

public class ServiceTest {

    @Test
    public void testRegist(){
        User user = new User();
        user.setId("234");
        user.setUsername("lisi");
        user.setPassword("234");
        user.setEmail("234@163.com");
        user.setBirthday(new Date());
        user.setNickname("李四");

        BusinessServiceImpl service = new BusinessServiceImpl();
        try {
            service.register(user);
            System.out.println("注册成功！");
        } catch (UserExistException e) {
            System.out.println("用户已存在！");
        }
    }
    @Test
    public void testLogin(){
        BusinessServiceImpl service = new BusinessServiceImpl();
        User user = service.login("lisi","234");
        System.out.println(user);
    }
}
