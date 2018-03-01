package com.picc.dao;

import com.picc.bean.user.UserAccount;

public interface UserAccountMapper {

    public UserAccount getUserAcount(UserAccount userAcnt);
    
    public UserAccount getUserAcountByLoginName(String userName);
}
