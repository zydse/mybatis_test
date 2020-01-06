package top.zydse.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.zydse.domain.User;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Create by: zydse
 * CLassName: IUserDaoTest
 *
 * @Date: 2020/1/3
 */
public class IUserDaoTest {

    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        //读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //使用工厂生产SqlSession对象
        session = factory.openSession();
        //使用SqlSession创建Mapper接口的动态代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws Exception {
        session.commit();

        session.close();
        in.close();
    }

    @Test
    public void findAll() throws Exception{

        //使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void saveUser() throws  Exception {
        User user = new User();
        user.setUsername("Tom");
        user.setSex("男");
        user.setAddress("江苏南京");
        user.setBirthday(new Date());

        userDao.saveUser(user);
    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setId(8);
        user.setUsername("阿曼达");
        user.setSex("女");
        user.setAddress("江苏南京");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    @Test
    public void deleteUser(){
        userDao.deleteUser(4);
    }

    @Test
    public void findById(){
        User user = userDao.findById(3);
        System.out.println(user);
    }

    @Test
    public void findByName(){
        List<User> users = userDao.findByName("%王%");
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void findTotal(){
        int count = userDao.findTotal();
        System.out.println(count);
    }
}