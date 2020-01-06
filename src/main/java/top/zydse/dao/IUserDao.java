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
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 保存一个用户信息到数据库中
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新一个用户的信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据用户id删除一个记录
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据ID查询一条记录
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据模糊字符串查询所有匹配的记录
     * ！important 传入的参数要带有%%
     * @param uname
     * @return
     */
    List<User> findByName(String uname);

    /**
     * 查询记录总条数
     * @return
     */
    int findTotal();
}
