package top.zxh.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description:用户类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long userId;
    private String username;
    private String password;
    private Long employeeId;
    private Integer salt;
}
