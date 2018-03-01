package com.picc.dao;
import java.util.List;
import com.picc.bean.sys.RacRole;
public interface RacAcntRoleRelMapper {
	
	List<RacRole> listAllRoles();
	
	List<RacRole> listUserAcntRoles(String uerAcntId);
	 
}
