package top.zydse.dao;

import org.apache.ibatis.annotations.Select;
import top.zydse.domain.User;

import java.util.List;

/**
 * Create by: zydse
 * CLassName: IUserMapper
 * 基于注解开发mapper
 * @Date: 2020/1/3
 */
public interface IUserMapper {
    @Select("select * from user")
    public List<User> findAll();
}
