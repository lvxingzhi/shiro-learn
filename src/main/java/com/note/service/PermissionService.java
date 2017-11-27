package com.note.service;

import com.note.dao.PermissionDao;
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
public class PermissionService {

    private PermissionDao permissionDao;

    public PermissionEntity createPermission(PermissionEntity permissionEntity){
        return permissionDao.createPermission(permissionEntity);
    }

    public void deletePermission(Long id){

    }

}
