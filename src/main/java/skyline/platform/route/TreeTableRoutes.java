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
    private static final String GET_TableTree = "/platform/tabletree/:id";
    private static final String GET_Tree = "/platform/tree";

    @Override
    public void regist() {
        //²Ëµ¥tabletree
        get(GET_TableTree, (request, response) -> {
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

        //²Ëµ¥Tree
        get(GET_Tree, (request, response) -> {
            System.out.print("11111111111111111---");
            String parent = request.params("parent");
            List list = new ArrayList();
            String[] states = new String[]{"success", "info", "danger", "warning"};

            if (StringUtils.isBlank(parent)) {
                for (int i = 0; i < 5; i++) {
                    Map data2 = new HashMap();
                    data2.put("id", "Node" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + String.valueOf(Math.random()));
                    data2.put("text", "Node " + i);
                    data2.put("icon", "fa fa-folder icon-lg icon-state-" + states[1]);
                    data2.put("children", true);
                    data2.put("type", "root");
                    list.add(data2);
                }
            } else {
                if ("3".equals(String.valueOf(Math.random() * 5))) {
                    Map data = new HashMap();
                    data.put("id", "Node" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + String.valueOf(Math.random()));
                    data.put("text", "No childs ");
                    data.put("icon", "fa fa-file fa-large icon-state-default");
                    data.put("children", false);
                    data.put("state", new HashMap().put("disabled", true));
                    list.add(data);
                } else {
                    for (int i = 0; i < 4; i++) {
                        Map data = new HashMap();
                        data.put("id", "Node" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + String.valueOf(Math.random()));
                        data.put("text", "Node " + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
                        data.put("icon", (Math.random() * 3 == 2 ? "fa fa-file icon-lg" : "fa fa-folder icon-lg icon-state-" + (states[2])));
                        data.put("children", Math.random() * 3 == 2 ? false : true);
                        list.add(data);
                    }
                }
            }
            //response.type("application/json");
            return list;
        }, new JsonTransformer());



    }
}
