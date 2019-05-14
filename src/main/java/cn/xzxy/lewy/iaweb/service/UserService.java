package cn.xzxy.lewy.iaweb.service;

import cn.xzxy.lewy.iaweb.dao.UserDao;
import cn.xzxy.lewy.iaweb.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserDao userDao;

    public User getById(int userId) {
        return userDao.findById(userId);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }
}
