package skyline.platform.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import skyline.platform.common.JsonTransformer;
import skyline.platform.service.LoginService;

import static spark.Spark.post;
import static spark.Spark.get;
/**
 * µÇÂ¼
 *
 * ×÷Õß£ºzhangxiaobo
 */
@Component
public class LoginRoutes implements RouteRegister {

    private static final Logger logger = LoggerFactory.getLogger(LoginRoutes.class);

    private static final String POST_LOGIN = "/platform/login";
    private static final String GET_MENUS = "/platform/menus";

    @Autowired
    private LoginService loginService;

    @Override
    public void regist() {

        // µÇÂ¼
        post(POST_LOGIN, (request, response) -> {

            logger.info(POST_METHOD + POST_LOGIN + ":" + (String) request.attribute("operid"));
            // response.type("application/json");
            return loginService.login("", "");
        }, new JsonTransformer());

        get(GET_MENUS, (request, response) -> {

            logger.info(GET_MENUS);

//            return loginService.qryMenus((String) request.params(":operid"));
            return loginService.qryMenus("9999");

        }, new JsonTransformer());

    }
}
