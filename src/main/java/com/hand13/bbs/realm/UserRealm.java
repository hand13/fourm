package com.hand13.bbs.realm;

import com.hand13.bbs.dao.UserDao;
import com.hand13.bbs.entity.User;
import com.hand13.bbs.service.UserBiz;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hd110 on 2017/10/25.
 * edited by hand13
 */
public class UserRealm extends AuthorizingRealm {

    private UserBiz userBiz;

    public UserBiz getUserBiz() {
        return userBiz;
    }

    @Autowired
    public void setUserBiz(UserBiz userBiz) {
        this.userBiz = userBiz;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo
            (PrincipalCollection principalCollection) {
        String username = (String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo
            (AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        User user = userBiz.findUserByName(username);
        if(user == null) {
            throw new UnknownAccountException();
        }
        if(user.getLocked() == 1) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(user.getCredentialsSalt()));
        return info;
    }
}
