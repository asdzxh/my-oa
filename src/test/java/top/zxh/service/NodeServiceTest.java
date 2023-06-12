package top.zxh.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.zxh.entity.Node;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



/**
 * Date:2023/3/1
 * Author：zxh
 * Description:
 */
@Slf4j
class NodeServiceTest {
private final NodeService nodeService = new NodeService();

    @Test
    void selectNodeByUserId() {
        List<Node> nodes = nodeService.selectNodeByUserId(3L);

        List<Map<String,Object>> treeList = new ArrayList<>();

        Map<String,Object> module = null;

        for (Node node : nodes){
            if (node.getNodeType() == 1){
                module = new LinkedHashMap<>();
                module.put("node",node);
                module.put("children",new ArrayList<>());
                treeList.add(module);
            }else if(node.getNodeType() ==2 ){
                List<Node> children = (List<Node>) module.get("children");
                children.add(node);
            }
        }
        log.info(treeList.toString());

    }
}