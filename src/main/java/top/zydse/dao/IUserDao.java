package top.zydse.dao;

import top.zydse.domain.User;

import java.util.List;

/**
 * Create by: zydse
 * CLassName: IUserDao
 * 基于xml文件开发的mapper
 * @Date: 2020/1/3
 */
public interface IUserDao {
    List<User> findAll();
}
