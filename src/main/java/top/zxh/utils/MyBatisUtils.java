package top.zxh.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;

/**
 * Date:2023/2/27
 * Author：zxh
 * Description:MyBatis 工具类
 */
public class MyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行查询操作
     * @param func 需要执行查询的代码块
     * @return 查询结果
     */
    public static Object executeQuery(Function<SqlSession,Object> func){
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        return func.apply(sqlSession);

    }

    /**
     * 执行增，删，改
     * @param func 需要执行的语句代码块
     * @return 更新操作的返回结果
     */
    public static Object executeUpdate(Function<SqlSession,Object> func){
        //手动提交/回滚事务
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
           Object obj = func.apply(sqlSession);
           //手动提交事务
           sqlSession.commit();
           return obj;
       }catch (Exception e){
           sqlSession.rollback();
           throw e;
       }finally {
            //关闭连接
            sqlSession.close();
        }
    }


}
