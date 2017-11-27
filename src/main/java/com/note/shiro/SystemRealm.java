package com.note.shiro;

import com.note.entity.UserEntity;
import com.note.service.UserService;
import com.note.util.PasswordUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

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
public class SystemRealm extends AuthorizingRealm { // 只认证可实现Realm接口即可

    private UserService userService = new UserService();

    /**
     * 获取角色信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> rolesSet = userService.findRoles(userName);
        Set<String> permissionSet = userService.findPermissions(userName);
        simpleAuthorizationInfo.setRoles(rolesSet);
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 获取认证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String)authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
        UserEntity userEntity = userService.findByUserName(userName);
        if(userEntity==null){
            throw new UnknownAccountException();// 异常体系-用户错误
        }
        if(!PasswordUtil.encrypt(password,userEntity.getSalt()).equals(userEntity.getPassword())){
            throw new IncorrectCredentialsException(); // 异常体系-密码错误
        }
        return new SimpleAuthenticationInfo(userName,password,userEntity.getUserName());
    }

}
