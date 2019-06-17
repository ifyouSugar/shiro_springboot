package com.Still.config;


import com.Still.domain.Permission;
import com.Still.domain.Role;
import com.Still.domain.User;
import com.Still.service.ILoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Mr.Still
 * @program: shiro_demo
 * @create: 2019-06-16 21:42
 **/
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private ILoginService loginService;


    /**
     * 角色权限和对应权限添加    授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登陆用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        //查询用户名称
        User user = loginService.findByName(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : user.getRoles()) {
            //添加用户角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            for (Permission permission : role.getPermissions()) {
                //添加权限
                simpleAuthorizationInfo.addStringPermission(permission.getPermission());
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证  鉴定
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求 如果用户名为空 返回null
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }

        //获取用户信息
        String username = authenticationToken.getPrincipal().toString();
        User user = loginService.findByName(username);
        if (user == null){
            return null;
        }else {
            /*
            * 第一个参数 用户名 第二个参数 数据库中 获取的密码 ，第三个参数 为房前realm的名称
            * */
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username,user.getName(),getName());
            return simpleAuthenticationInfo;
        }

    }
}
