package com.note.service;

import com.note.entity.UserEntity;

import java.util.HashSet;
import java.util.Set;

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
public class UserService {

    /**
     * 获取用户信息
     * @param userName
     * @return
     */
    public UserEntity findByUserName(String userName){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUserName("admin");
        userEntity.setPassword("418e9d16650774573bf1329bbf0ca5b2");
        userEntity.setSalt("note");
        userEntity.setLocked(0);
        return userEntity;
    }

    /**
     * 获取角色信息
     * @param userName
     * @return
     */
    public Set<String> findRoles(String userName){
        Set<String> set = new HashSet<>();
        set.add("admin");
        set.add("guest");
        set.add("b");
        return set;
    }

    /**
     * 获取权限信息
     * @param userName
     * @return
     */
    public Set<String> findPermissions(String userName){
        Set<String> set = new HashSet<>();
        set.add("all");
        set.add("main");
        return set;
    }

}
