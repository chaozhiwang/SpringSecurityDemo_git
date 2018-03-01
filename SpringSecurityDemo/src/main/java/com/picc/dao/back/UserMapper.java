package com.picc.dao.back;

import com.picc.bean.MyUser;

public interface UserMapper {

    public MyUser findUserByLoginName(String username);
    
}
