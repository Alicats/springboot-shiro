package cn.xej.config;

import cn.xej.pojo.User;
import cn.xej.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();

        List<String> roles = userService.getRolesIdByUserId(user.getUserId());
        info.addRoles(roles);

        return info;
    }


    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User user = userService.findByUserId(token.getUsername());

        if(user==null){
            System.out.println("11");
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());

    }
}
