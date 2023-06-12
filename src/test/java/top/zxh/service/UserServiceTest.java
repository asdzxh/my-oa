package top.zxh.service;

import org.junit.jupiter.api.Test;
import top.zxh.entity.User;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description:
 */
class UserServiceTest {

    private final UserService userService = new UserService();

    @Test
    void login1() {
        User user = userService.login("m8", "test");
        System.out.println(user);
    }

    @Test
    void login2() {
        User user = userService.login("t77", "test");
        System.out.println(user);
    }

    @Test
    void login3() {
        User user = userService.login("t7", "test11");
        System.out.println(user);
    }
}