package com.example.crudlogintest1.controller;

import com.example.crudlogintest1.dao.DepartmentDao;
import com.example.crudlogintest1.dao.EmployeeDao;
import com.example.crudlogintest1.entities.Department;
import com.example.crudlogintest1.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee>employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        //classpath:/templates/xx.html
        return "emp/list";
    }
    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面前，要查所有的部门
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    //员工添加功能
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee=employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面 add 是一个修改添加二合一的页面
        return "emp/add";
    }
    @PutMapping("emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
