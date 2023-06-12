package top.zxh.datasource;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description:Druid 连接池工厂类
 */
public class DruidDataSourceFactory extends UnpooledDataSourceFactory {

    @Override
    public DataSource getDataSource() {
        try {
            ((DruidDataSource)this.dataSource).init();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return this.dataSource;
    }

    public DruidDataSourceFactory(){
        this.dataSource = new DruidDataSource();
    }

}
