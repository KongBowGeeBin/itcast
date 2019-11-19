package itcast.hjh.dao.impl;

import itcast.hjh.domain.User;
import itcast.hjh.utils.XmlUtils;
import org.dom4j.Document;
import org.dom4j.Element;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class UserDaoImpl implements itcast.hjh.dao.UserDao {

    @Override
    public void add(User user){
        try {
            Document document = XmlUtils.getDocument();
            Element root = document.getRootElement();
            Element user_tag = root.addElement("user");
            user_tag.setAttributeValue("id",user.getId());
            user_tag.setAttributeValue("username",user.getUsername());
            user_tag.setAttributeValue("password",user.getPassword());
            user_tag.setAttributeValue("birthday",user.getBirthday()==null? "":user.getBirthday().toLocaleString());
            user_tag.setAttributeValue("email",user.getEmail());
            user_tag.setAttributeValue("nickname",user.getNickname());
            XmlUtils.write2Xml(document);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User find(String username, String password){
        try {
            Document document = XmlUtils.getDocument();
            Element element = (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
            if (element==null){
                return null;
            }
            User user = new User();
            user.setId(element.attributeValue("id"));
            user.setUsername(element.attributeValue("username"));
            user.setPassword(element.attributeValue("password"));
            user.setEmail(element.attributeValue("email"));
            String date = element.attributeValue("birthday");
            if (date ==null || date =="") {
                user.setBirthday(null);
            }else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                user.setBirthday(sdf.parse(date));
            }
            user.setNickname(element.attributeValue("nickname"));
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean find(String username){
        try {
            Document document = XmlUtils.getDocument();
            Element element = (Element)document.selectSingleNode("//user[@username='"+username+"']");
            if (element==null){
                return false;
            }else {
            return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
