/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.ejb.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entities.Employee;

/**
 *
 * @author user
 */
@Local
public interface EmployeeFacadeLocal {

    void createEmployee(Employee employee);

    void edit(Employee employee);

    void removeEmployee(Employee employee);

    Employee find(Object id);

    List<Employee> findAll();
    
    List<Employee> findAllEmployees(String department);

    List<Employee> findRange(int[] range);

    int count();
    
    Employee highestPaidEmployee();
    
}
