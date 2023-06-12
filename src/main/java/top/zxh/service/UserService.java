package top.zxh.service;

import top.zxh.entity.User;
import top.zxh.mapper.UserMapper;
import top.zxh.utils.Md5Utils;
import top.zxh.service.exception.LoginException;
import top.zxh.utils.MybstisUtils;


/**
 * Date:2023/3/1
 * Author：zxh
 * Description: 用户服务
 */
public class UserService {
    private final UserMapper userMapper = new UserMapper();

    /**
     * 根据前端传的数据，进行登录验证
     *
     * @param username 前端输入的用户名
     * @param password 前端输入的密码
     * @return 登录用户对象
     * @throws LoginException 用户登录异常
     */
    public User login(String username, String password) {
        User user = userMapper.selectByUserName(username);
        if (user == null) {
            throw new LoginException("用户名不存在");
        }
        // 对 password 进行 md5 加 salt 加密，得到密文
        String md5Password = Md5Utils.md5Digest(password, user.getSalt());
        if (!md5Password.equals(user.getPassword())) {
            throw new LoginException("密码错误");
        }
        return user;
    }

    public static void main(String[] args) {
        String test = Md5Utils.md5Digest("test", 188);
        System.out.println(test);
    }
}
