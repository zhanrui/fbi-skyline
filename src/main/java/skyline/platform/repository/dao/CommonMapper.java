package skyline.platform.repository.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import skyline.platform.repository.common.MenuItem;

import java.util.List;

/**
 * Created by admin on 2015-7-27.
 */
@Repository
public interface CommonMapper {

    @Select(" SELECT distinct  " +
            "                m.menuid AS menuItemId,  " +
            "                m.parentmenuid AS menuItemPId,  " +
            "                m.menuLevel AS menuLevel,  " +
            "                m.menulabel AS menuItemLabel,  " +
            "                m.isleaf AS menuItemIsLeaf,  " +
            "                m.menuaction AS menuItemUrl,  " +
            "                m.menudesc AS menuItemDescription,  " +
            "                m.Levelidx as levelidx,m.targetmachine  " +
            "                ,(select count(ptmenu.MENULABEL) FROM ptoperrole, ptroleres , ptresource , ptmenu  " +
            "                WHERE ptoperrole.operid = #{operid}  and ptroleres.roleid =ptoperrole.roleid and  " +
            "                ptresource.resid = ptroleres.resid and ptresource.restype = '4' and  " +
            "                rtrim(ptmenu.menuid) = ptresource.resname  and ptmenu.PARENTMENUID=m.MENUID) as childcount " +
            "                 FROM ptoperrole r,  " +
            "                ptroleres rs,  " +
            "                ptresource s,  " +
            "                ptmenu m  " +
            "                WHERE r.operid = #{operid}  " +
            "                and rs.roleid = r.roleid  " +
            "                and s.resid = rs.resid  " +
            "                and s.restype = '4'  " +
            "                and rtrim(m.menuid) = s.resname" +
            "                 order by m.menuLevel,m.Levelidx")
    List<MenuItem> qryMenus(@Param("operid") String operid);
}
