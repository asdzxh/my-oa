package top.zxh.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.zxh.entity.Department;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description:
 */@Slf4j
class DepartmentServiceTest {
    DepartmentService departmentService = new DepartmentService();

    @Test
    void selectById() {
        Department department = departmentService.selectById(3L);
        log.info(String.valueOf(department));
    }
}