package com.note.logic;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

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
public class BusinessLogic {

    static {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
    }

    public String login(String userName,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        try {
            subject.login(token);
        }catch (Exception e){
            return "fail";
        }

        if(subject.isAuthenticated()){
            return "success";
        }else{
            return "fail";
        }
    }

    public String hasRole(String userName,String password,String role){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        try {
            subject.login(token);
        }catch (Exception e){
            return "fail";
        }
        if(subject.hasRole(role)){
            return "有角色";
        }else{
            return "无角色";
        }

    }
    public String hasPermission(String userName,String password,String permission){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        try {
            subject.login(token);
        }catch (Exception e){
            return "fail";
        }
        if(subject.isPermitted(permission)){
            return "有权限";
        }else{
            return "无权限";
        }
    }


}
