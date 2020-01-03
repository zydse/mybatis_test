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
 * CLassName: IUserMapperTest
 *
 * @Date: 2020/1/3
 */
public class IUserMapperTest {

    @Test
    public void findAll() throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        IUserMapper userMapper = session.getMapper(IUserMapper.class);
        List<User> users = userMapper.findAll();
        for (User user :
                users) {
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}