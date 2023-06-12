package top.zxh.service;

import top.zxh.entity.Employee;
import top.zxh.mapper.EmployeeMapper;
import top.zxh.utils.MybstisUtils;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description:
 */
public class EmployeeService {
    public Employee selectById(Long employeeId){
        return (Employee) MybstisUtils.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            return mapper.selectById(employeeId);
        });
    }
}
