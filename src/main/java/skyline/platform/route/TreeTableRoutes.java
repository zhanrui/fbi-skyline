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
public class TreeTableRoutes implements RouteRegister {
    private static final Logger logger = LoggerFactory.getLogger(TreeTableRoutes.class);
    private static final String GET_TableTree = "/platform/tabletree";
    private static final String GET_Tree = "/platform/tree";

    @Override
    public void regist() {
        //tabletree
        get(GET_TableTree, (request, response) -> {
            Map records = new HashMap();
            List list = new ArrayList();
            logger.info(GET_METHOD + GET_TableTree + ":" + (String) request.queryParams("id"));
            String id =StringUtils.isBlank(request.queryParams("id")) ? "0" : request.queryParams("id");
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
            response.type("application/json");
            System.out.println("=======records=====" + records.toString());
            return records;
        }, new JsonTransformer());

        //Tree
        get(GET_Tree, (request, response) -> {
          String parent = request.queryParams("parentId");
          String node = request.queryParams("node");
          List rootList = new ArrayList();
          if("#".equals(parent)) {
              for (int i = 0; i < 5; i++) {
                  Map map = new HashMap();
                  map.put("id", "Node" + Math.random());
                  map.put("text", "Node#" + i);
                  map.put("icon", "fa fa-folder icon-lg icon-state-success");
                  map.put("children", true);
                  map.put("type", "root");
                  rootList.add(map);
              }
          }else{
              if(Math.random()*5==3){
                  Map map = new HashMap();
                  map.put("id", "Node" + Math.random());
                  map.put("text", "No childs");
                  map.put("icon", "fa fa-folder icon-lg icon-state-default");
                  map.put("children", false);
                  map.put("type", "root");
                  rootList.add(map);
              }else{
                  for (int i = 0; i < 4; i++) {
                      Map map = new HashMap();
                      map.put("id", "Node" + Math.random());
                      map.put("text", "Node"+i);
                      map.put("icon", "fa fa-folder icon-lg icon-state-warning");
                      map.put("children", false);
                      map.put("type", "root");
                      rootList.add(map);
                  }
              }
          }
          response.type("application/json");
          System.out.println("============"+rootList.toString());
          return rootList;
        },new JsonTransformer());



    }
}
