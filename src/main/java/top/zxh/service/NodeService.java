package top.zxh.service;

import top.zxh.entity.Node;
import top.zxh.mapper.NodeMapper;
import top.zxh.utils.MybstisUtils;

import java.util.List;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description:
 */
public class NodeService {
    public List<Node> selectNodeByUserId(Long userId){
        return (List<Node>) MybstisUtils.executeQuery(sqlSession -> {
            NodeMapper mapper = sqlSession.getMapper(NodeMapper.class);
            return mapper.selectNodeByUserId(userId);
        });

    }
}
