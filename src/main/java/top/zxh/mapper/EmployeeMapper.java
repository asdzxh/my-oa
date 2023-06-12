package top.zxh.mapper;

import top.zxh.entity.Employee;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description:
 */
public interface EmployeeMapper {
    /**
     *
     * @param employeeId 员工id
     * @return 雇员信息
     */
    Employee selectById(Long employeeId);
}
