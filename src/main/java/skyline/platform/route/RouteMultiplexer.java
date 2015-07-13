package skyline.platform.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import spark.servlet.SparkApplication;

import static spark.Spark.after;

/**
 * ·������-ע������·�ɺ�δ����·��
 * ע�⣺�м��ڴ�����ע�����·�ɵ�ַ
 * RouteMultiplexer ��Ȩָ����·�ɵ�ҵ��ʵ�ַ�ʽ(service)
 * ���ߣ�zhangxiaobo
 */
public class RouteMultiplexer implements SparkApplication {

    private static final Logger logger = LoggerFactory.getLogger(RouteMultiplexer.class);

    @Override
    public void init() {

        // SparkBase.awaitInitialization();

        // ·��ɨ��
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
