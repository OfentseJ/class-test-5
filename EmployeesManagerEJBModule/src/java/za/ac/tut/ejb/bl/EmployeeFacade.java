/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.ejb.bl;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.entities.Employee;

/**
 *
 * @author user
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeLocal {

    @PersistenceContext(unitName = "EmployeesManagerEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }
    @RolesAllowed("secretary")
    @Override
    public void createEmployee(Employee employee) {
        create(employee);
    }

    @RolesAllowed("manager")
    @Override
    public void removeEmployee(Employee employee) {
        remove(employee);
    }

    @RolesAllowed("manager")
    @Override
    public List<Employee> findAllEmployees(String department) {
        Query query = em.createQuery("SELECT s FROM Employee s WHERE s.department = :departmentTarget");
        query.setParameter("departmentTarget", department);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @RolesAllowed("manager")
    @Override
    public Employee highestPaidEmployee() {
        Query query = em.createQuery("SELECT s FROM Employee s WHERE s.salary = (SELECT MAX(c.salary) FROM Employee c)");
        Employee emp = (Employee)query.getSingleResult();
        return emp;
    }

    
}
