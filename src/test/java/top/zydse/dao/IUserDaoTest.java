package top.zydse.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import top.zydse.domain.User;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Create by: zydse
 * CLassName: IUserDaoTest
 *
 * @Date: 2020/1/3
 */
public class IUserDaoTest {

    @Test
    public void findAll() throws Exception{
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //使用SqlSession创建Mapper接口的动态代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //释放资源
        session.close();
        in.close();
    }
}