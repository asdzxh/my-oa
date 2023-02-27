package top.zxh.utils;

import org.junit.jupiter.api.Test;

import static top.zxh.utils.MyBatisUtils.executeQuery;


/**
 * Date:2023/2/27
 * Author：zxh
 * Description:
 */
class MyBatisUtilsTest {
    @Test
    public void testCase1(){
        String s = (String) executeQuery(sqlSession -> sqlSession.selectOne("test.sample"));
        System.out.println(s);
    }

}