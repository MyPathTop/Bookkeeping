package top.mypath.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mypath.dao.UserDao;
import top.mypath.domain.User;
import top.mypath.service.UserService;

import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/22 18:06
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public boolean insert(User user) {
        user.setMyBalance(0d);//初始金额0元
        user.setCancel(1);//代表启用
        return userDao.insert(user);
    }

    @Override
    public User findById(String uid) {
        return userDao.findById(uid);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.update(user);
    }


}
