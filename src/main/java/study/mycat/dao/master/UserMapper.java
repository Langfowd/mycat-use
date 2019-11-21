package study.mycat.dao.master;

import study.mycat.base.IKMapper;
import study.mycat.model.UserModel;

import java.util.List;

public interface UserMapper extends IKMapper<UserModel> {

    List<UserModel> getAllUser();
}
