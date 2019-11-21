package study.mycat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.mycat.dao.master.UserMapper;
import study.mycat.model.UserModel;
import study.mycat.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserModel> getAllUser() {
        return userMapper.selectAll();
    }
}
