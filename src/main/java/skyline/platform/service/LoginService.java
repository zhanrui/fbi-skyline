package skyline.platform.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skyline.platform.common.enumeration.ReturnCode;
import skyline.platform.repository.common.MenuItem;
import skyline.platform.repository.dao.CommonMapper;
import skyline.platform.repository.dao.PtoperMapper;
import skyline.platform.repository.model.Ptoper;
import skyline.platform.repository.model.PtoperExample;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于shiro的登录验证和授权
 */
@Service
public class LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private PtoperMapper ptoperMapper;

    @Autowired
    private CommonMapper commonMapper;

    /**
     * 登录验证
     *
     * @param operid
     * @param password
     * @return
     */
    public List<String> login(String operid, String password) {

        List<String> msgs = new ArrayList<>();

        Ptoper oper = qryOper(operid);
        if (oper == null) {
            msgs.add(ReturnCode.PTOPER_NOT_EXIST.getCode());
            msgs.add(ReturnCode.PTOPER_NOT_EXIST.getTitle());
        } else if (!password.equals(oper.getOperpasswd())) {
            msgs.add(ReturnCode.PTOPER_PWD_ERROR.getCode());
            msgs.add(ReturnCode.PTOPER_PWD_ERROR.getTitle());
        } else {
            msgs.add(ReturnCode.PTOPER_PWD_ERROR.getCode());
            msgs.add(ReturnCode.PTOPER_PWD_ERROR.getTitle());

            SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
            // 登录后将用户信息存入token
            UsernamePasswordToken token = new UsernamePasswordToken(operid, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        }
        return msgs;
    }

    public Ptoper qryOper(String operid) {
        PtoperExample example = new PtoperExample();
        example.createCriteria().andOperenabledEqualTo("1").andOperidEqualTo(operid);
        List<Ptoper> opers = ptoperMapper.selectByExample(example);
        if (opers != null && !opers.isEmpty()) {
            return opers.get(0);
        } else return null;
    }

    public List<MenuItem> qryMenus(String operid) {
        List<MenuItem> items = new ArrayList<>();




       /* MenuItem item2 = new MenuItem();
        item2.setLevelidx("10");
        item2.setMenuItemIsLeaf("1");
        item2.setMenuItemId("1");
        item2.setMenuLevel("1");
        item2.setMenuItemPId("0");
        item2.setMenuItemLabel("机构管理");
        item2.setMenuItemUrl("#/ptdept.html");
        items.add(item2);


        MenuItem item3 = new MenuItem();
        item3.setLevelidx("10");
        item3.setMenuItemIsLeaf("1");
        item3.setMenuItemId("1");
        item3.setMenuLevel("1");
        item3.setMenuItemPId("0");
        item3.setMenuItemLabel("用户管理");
        item3.setMenuItemUrl("#/file_upload.html");
        items.add(item3);*/
        return commonMapper.qryMenus(operid);
    }

}
