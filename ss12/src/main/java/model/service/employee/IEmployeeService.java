package model.service.employee;

import model.entity.Employee;
import model.service.IGenericService;

import java.util.List;

public interface IEmployeeService extends IGenericService<Employee, Integer> {
    List<Employee> findByName (String eName);
}
