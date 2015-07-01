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
 * ϵͳ�û���ȫ��֤����Ȩ
 */
@Component
public class SkylineShiroRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    /***
     * ��ȡ��Ȩ��Ϣ
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
                    //��Ȩ����Դ��ӵ��û���Ϣ
                    info.addStringPermission(each);
                }
                return info;
            }
        }
        return null;
    }

    /***
     * ��ȡ��֤��Ϣ
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // ͨ�������յ��û���
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
