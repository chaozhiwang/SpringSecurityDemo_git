package com.picc.dao;

import java.util.List;

import com.picc.bean.sys.RacPrivilege;

public interface RacPrivilegeMapper {

    List<RacPrivilege> listPrivilegeByRoleId(String roleId);
}
