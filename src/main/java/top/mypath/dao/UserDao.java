package top.mypath.dao;

import org.springframework.stereotype.Repository;
import top.mypath.domain.User;

import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/22 16:17
 */
@Repository
public interface UserDao {
    public List<User> findAll();

    public User findById(String id);

    public boolean update(User user);

    public boolean insert(User user);

    public boolean updateMyBalance(Double balance,String userId);




}
