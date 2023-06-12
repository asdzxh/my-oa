package top.zxh.mapper;

import top.zxh.entity.User;
import top.zxh.utils.MybstisUtils;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description:用户数据表持久层
 */
public class UserMapper {
    public User selectByUserName(String userName) {
        return (User) MybstisUtils.executeQuery(sqlSession -> sqlSession.selectOne("top.zxh.mapper.UserMapper.selectByUserName", userName));
    }
}
