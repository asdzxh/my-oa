package top.zxh.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    private Long departmentId;
    private String departmentName;
}
