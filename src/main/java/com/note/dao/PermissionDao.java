package com.note.dao;

import com.note.entity.PermissionEntity;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2017/11/21
 * @since 1.0
 */
public class PermissionDao {

    public PermissionEntity createPermission(PermissionEntity permissionEntity){
        permissionEntity = new PermissionEntity();
        permissionEntity.setId(1L);
        permissionEntity.setPermission("admin");
        permissionEntity.setDescription("管理员角色");
        permissionEntity.setAvaliable(1);
        return permissionEntity;
    }

    public void deletePermission(Long id){

    }

}
