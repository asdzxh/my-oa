package top.zxh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.zxh.entity.Department;
import top.zxh.entity.Employee;
import top.zxh.entity.Node;
import top.zxh.service.DepartmentService;
import top.zxh.service.EmployeeService;
import top.zxh.service.NodeService;
import top.zxh.utils.ResponseUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description: UserInfoServlet
 */

@WebServlet("/api/user")
public class UserInfoServlet extends HttpServlet {
    private final EmployeeService employeeService = new EmployeeService();
    private final DepartmentService departmentService = new DepartmentService();
    private final NodeService nodeService = new NodeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取参数
        String uid = request.getParameter("uid");
        String eid = request.getParameter("eid");
        System.out.println(uid);
        System.out.println(eid);

        //查到员工信息，部门信息
        Employee employee = employeeService.selectById(Long.parseLong(eid));
        Department department = departmentService.selectById(employee.getDepartmentId());

        //查到数据表数据
        List<Node> nodes = nodeService.selectNodeByUserId(Long.parseLong(uid));
        //搞糟返回的数据结构
        List<Map<String,Object>> treeList = new ArrayList<>();
        //模块结构，可以put两组数据，一组是父节点对象，一组是子节点列表
        Map<String,Object> module = null;
        //遍历数据表查询结果，拼装成目标结构
        for (Node node : nodes){
            if (node.getNodeType() == 1){
                module = new LinkedHashMap<>();
                module.put("node",node);
                module.put("children",new ArrayList<>());
                treeList.add(module);
            }else if(node.getNodeType() ==2 ){
                assert module != null;
                List<Node> children = (List<Node>) module.get("children");
                children.add(node);
            }
        }
        //拼成一个JSON对象返回
        String json = new ResponseUtils()
                .put("employee",employee)
                .put("department",department)
                .put("nodeList",treeList).toJsonString();

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
