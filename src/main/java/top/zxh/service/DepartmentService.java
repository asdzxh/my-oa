package top.zxh.service;

import top.zxh.entity.Department;
import top.zxh.mapper.DepartmentMapper;
import top.zxh.utils.MybstisUtils;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description:
 */
public class DepartmentService {
    public Department selectById(Long departmentId){
        return (Department) MybstisUtils.executeQuery(sqlSession -> sqlSession.getMapper(DepartmentMapper.class).selectById(departmentId));
    }
}
