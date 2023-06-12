package top.zxh.mapper;

import top.zxh.entity.Department;


/**
 * Date:2023/3/1
 * Author：zxh
 * Description:DepartmentMapper
 */

public interface DepartmentMapper {
    /**
     *
     * @param departmentId 部门id
     * @return 部门信息
     */
   Department selectById(Long departmentId);
}
