package com.nyl.CSSpringBootJPA.repository;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.nyl.CSSpringBootJPA.entity.Employee;

public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {
	
	@Autowired
    EntityManager entityManager;

	public Long getMaxEmpId() {
		 try {
	            String sql = "SELECT coalesce(max(e.id), 0) FROM Employee e";
	            Query query = entityManager.createQuery(sql);
	            return (Long) query.getSingleResult();
	        } catch (NoResultException e) {
	            return 0L;
	        }
	
	}

	public long updateEmployee(Long empId, String fullName, Date hireDate) {
		 Employee e = entityManager.find(Employee.class, empId);
	        if (e == null) {
	            return 0;
	        }
	        e.setFullName(fullName);
	        e.setHireDate(hireDate);
	        entityManager.flush();
	        return 1;
	}

}
