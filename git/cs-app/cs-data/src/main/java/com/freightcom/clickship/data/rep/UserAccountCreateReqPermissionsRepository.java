package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.UserAccountCreateReq;
import com.freightcom.clickship.data.entity.UserAccountCreateReqPermissions;


@Repository
public interface UserAccountCreateReqPermissionsRepository extends JpaRepository<UserAccountCreateReqPermissions, String> {
	
	public void deleteByUserAccountCreateReq(UserAccountCreateReq obj);
	
	public List<UserAccountCreateReqPermissions> findByUserAccountCreateReq(UserAccountCreateReq req);
	
	public List<UserAccountCreateReqPermissions> findByUserAccountCreateReqAndPermissionType(UserAccountCreateReq req, String permissionType);
	
	public List<UserAccountCreateReqPermissions> findByUserAccountCreateReqAndPermissionTypeAndPermissionName(UserAccountCreateReq req, String type, String name);
	
}
