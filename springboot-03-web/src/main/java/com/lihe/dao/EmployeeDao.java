package com.lihe.dao;

import com.lihe.pojo.Department;
import com.lihe.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.security.mscapi.CPublicKey;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>(); // 创建一个部门表
        employees.put(1001, new Employee(1001, "AA", "911562554@qq.com", 0, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "AB", "912562554@qq.com", 0, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "AC", "913562554@qq.com", 0, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "AD", "914562554@qq.com", 0, new Department(104, "运行部")));
        employees.put(1005, new Employee(1005, "AE", "915562554@qq.com", 0, new Department(105, "后勤部")));
    }
    private static Integer initId = 1006;
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);


    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }

}
