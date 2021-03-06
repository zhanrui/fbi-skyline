package skyline.platform.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import spark.servlet.SparkApplication;

import static spark.Spark.after;

/**
 * 路由容器-注册所有路由和未定义路由
 * 注意：切忌在此容器注册具体路由地址
 * RouteMultiplexer 有权指定各路由的业务实现方式(service)
 * 作者：zhangxiaobo
 */
public class RouteMultiplexer implements SparkApplication {

    private static final Logger logger = LoggerFactory.getLogger(RouteMultiplexer.class);

    @Override
    public void init() {

        // SparkBase.awaitInitialization();

        // 路由扫描
        routeScan();

        // TODO after filter (for all routes)...
        after((request, response) -> {
            response.header("header", "value");
        });
    }

    private void routeScan() {
        WebApplicationContext springContext = ContextLoader.getCurrentWebApplicationContext();
        String[] beanNames = springContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object object = springContext.getBean(beanName);
            if (object instanceof RouteRegister) {
                RouteRegister route = (RouteRegister) object;
                route.regist();
            }
        }
    }
}
