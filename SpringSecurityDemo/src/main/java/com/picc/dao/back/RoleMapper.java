package com.picc.dao.back;

import java.util.List;

import com.picc.bean.Authorities;

public interface RoleMapper {

    public List<Authorities> getRole(String username);
    
}
