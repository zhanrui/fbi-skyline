package skyline.platform.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import skyline.platform.common.JsonTransformer;
import skyline.platform.repository.model.Ptdept;
import skyline.platform.service.PtdeptService;

import java.util.List;

import static spark.Spark.get;

/**
 * ����·������
 * <p>
 * ���ߣ�zhangxiaobo
 */
@Component
public class PtdeptRoutes implements RouteRegister {

    private static final Logger logger = LoggerFactory.getLogger(PtdeptRoutes.class);

    private static final String GET_QRY_DEPTS = "/platform/ptdept";
    private static final String GET_QRY_DEPT_BY_ID = "/platform/ptdept/:id";

    @Autowired
    private PtdeptService ptdeptService;

    @Override
    public void regist() {

        // ��ѯ���л����б�
        get(GET_QRY_DEPTS, (request, response) -> {

            List<Ptdept> depts = ptdeptService.qryDepts();
            logger.info(GET_METHOD + GET_QRY_DEPTS);

            response.status(200);
            return depts;
        }, new JsonTransformer());

        // ��ѯ���л����б�
        get(GET_QRY_DEPT_BY_ID, (request, response) -> {

            Ptdept dept = ptdeptService.qryDeptById((String) request.params(":id"));
            logger.info(GET_METHOD + GET_QRY_DEPTS);
            response.status(200);
            return dept;
        }, new JsonTransformer());
    }
}
