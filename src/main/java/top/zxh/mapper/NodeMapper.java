package top.zxh.mapper;

import top.zxh.entity.Node;

import java.util.List;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description:
 */
public interface NodeMapper {
    /**
     *
     * @param userId 用户id
     * @return List<Node>权限列表
     */
    List<Node> selectNodeByUserId(Long userId);
}
