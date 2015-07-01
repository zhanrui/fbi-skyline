package skyline.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import skyline.platform.repository.model.Ptoper;
import skyline.platform.service.LoginService;

import java.util.List;

/**
 * 系统用户安全验证和授权
 */
@Component
public class SkylineShiroRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    /***
     * 获取授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.fromRealm(getName()).iterator().next();
        if (username != null) {
            List<String> pers = loginService.getPermissionsByUserName(username);
            if (pers != null && !pers.isEmpty()) {
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                for (String each : pers) {
                    //将权限资源添加到用户信息
                    info.addStringPermission(each);
                }
                return info;
            }
        }
        return null;
    }

    /***
     * 获取验证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 通过表单接收的用户名
        String username = token.getUsername();

        if (!StringUtils.isEmpty(username)) {
            Ptoper oper = loginService.qryOper(username);
            if (oper != null) {
                return new SimpleAuthenticationInfo(oper.getOperid(), oper.getOperpasswd(), getName());
            }
        }

        return null;
    }
}
