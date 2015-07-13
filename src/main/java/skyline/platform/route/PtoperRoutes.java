package skyline.platform.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import skyline.platform.repository.model.Ptoper;
import skyline.platform.service.PtoperService;
import skyline.platform.common.JsonTransformer;

import java.util.List;

import static spark.Spark.get;

/**
 * �û���Ϣ��ز�����·������
 *
 * ���ߣ�zhangxiaobo
 */
@Component
public class PtoperRoutes implements RouteRegister {

    private static final Logger logger = LoggerFactory.getLogger(PtoperRoutes.class);

    private static final String GET_QRY_OPER_BY_ID = "/platform/ptoper/:id";
    private static final String GET_QRY_OPERS = "/platform/ptoper";

    @Autowired
    private PtoperService ptoperService;

    @Override
    public void regist() {

        // ���û�ID��ѯ�û���Ϣ
        get(GET_QRY_OPER_BY_ID, (request, response) -> {

            logger.info(GET_METHOD + GET_QRY_OPER_BY_ID + ":" + (String) request.params(":id"));
            // response.type("application/json");
            return ptoperService.qryOperById((String) request.params(":id"));
        }, new JsonTransformer());

        // ��ѯ�����û��б�
        get(GET_QRY_OPERS, (request, response) -> {

            logger.info(GET_METHOD + GET_QRY_OPERS);
            List<Ptoper> opers = ptoperService.qryOpers();
            // return response
            response.status(200);
            return opers;
        }, new JsonTransformer());
    }
}
