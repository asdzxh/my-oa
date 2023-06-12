package top.zxh.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description: 员工
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    /**
     * 员工编号
     */
    private Long employeeId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 部门编号
     */
    private Long departmentId;
    /**
     * 头衔/职务
     */
    private String title;
    /**
     * 岗位级别
     */
    private Integer level;
}

