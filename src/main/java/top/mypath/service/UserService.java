package top.mypath.service;

import org.springframework.stereotype.Service;
import top.mypath.domain.User;

import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/22 18:05
 */

public interface UserService {

    public boolean insert(User user);

    public User findById(String uid);

    public boolean updateUser(User user);


}
