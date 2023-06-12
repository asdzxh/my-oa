package top.zxh.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.zxh.entity.Employee;



/**
 * Date:2023/3/1
 * Author：zxh
 * Description:
 */
@Slf4j
class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService();

    @Test
    void selectById() {
        Employee employee = employeeService.selectById(3L);
        log.info(String.valueOf(employee));


    }
}