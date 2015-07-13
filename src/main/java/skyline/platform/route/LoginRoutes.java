package skyline.platform.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import skyline.platform.service.LoginService;
import skyline.platform.common.JsonTransformer;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * µÇÂ¼
 *
 * ×÷Õß£ºzhangxiaobo
 */
@Component
public class LoginRoutes implements RouteRegister {

    private static final Logger logger = LoggerFactory.getLogger(LoginRoutes.class);

    private static final String POST_LOGIN = "/platform/login";

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

    }
}
