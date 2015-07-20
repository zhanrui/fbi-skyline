package skyline.platform.route;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import skyline.platform.common.JsonTransformer;
import java.text.SimpleDateFormat;
import java.util.*;

import static spark.Spark.get;

/**
 * Created by Administrator on 2015/7/17.
 */
@Component
public class TreeTableRoutes implements RouteRegister{
    private static final Logger logger = LoggerFactory.getLogger(TreeTableRoutes.class);
    private static final String GET_TreeTable = "/platform/tree/:id";

    @Override
    public void regist() {

        get(GET_TreeTable, (request, response) -> {
            Map records = new HashMap();
            List list = new ArrayList();
            //logger.info(GET_METHOD + GET_TreeTable + ":" + (String) request.params(":id"));
            String aa = request.params(":id");
            String id =StringUtils.isBlank(request.params(":id")) ? "0" : request.params(":id");
            int level = 1;
            if (!id.equals("0")) {
                String[] ids = id.split("\\:");
                level = Integer.parseInt(ids[1]) + 1;
            }
            for (int i = 1; i < 6; i++) {
                Map records2 = new HashMap();
                String id_ = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + String.valueOf(Math.random())+":"+level;
                records2.put("id",id_);
                records2.put("parent",id);
                records2.put("name","Node -"+level+"-"+i);
                records2.put("level",level);
                records2.put("type","folder");
                list.add(records2);
                records.put("nodes",list);
            }
            return records;
            //response.type("application/json");
        }, new JsonTransformer());
    }
}