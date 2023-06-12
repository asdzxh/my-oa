package top.zxh.utils;

import org.junit.jupiter.api.Test;


/**
 * Date:2023/3/1
 * Author：zxh
 * Description:
 */
class MybstisUtilsTest {
    @Test
    void test(){

        String str = (String)MybstisUtils.executeQuery(sqlSession -> sqlSession.selectOne("test.sample"));
        System.out.println(str);
    }

}