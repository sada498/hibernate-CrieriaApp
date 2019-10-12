package com.sada.hibernate.DAO;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.sada.hibernate.Util.HibernateUtil;
import com.sada.hibernate.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	SessionFactory factory;
	public EmployeeDAOImpl() {
	 factory=HibernateUtil.getSessionFactory();
	}
		@Override
	public void findEmp(int deptno) {
	Session	session =factory.openSession();
	Criteria crit=session.createCriteria(Employee.class);
	Criterion c1=Restrictions.eq("deptNumber", deptno);
	crit.add(c1);
	List list=crit.list();
	Iterator itr=list.iterator();
	while(itr.hasNext())
	{
		Employee e=(Employee)itr.next();
		System.out.println(e.getEmployeeNumber() +" "+ e.getEmployeeName()+" "+e.getEmployeeSalary()+" "+e.getDeptNumber());
	}
		session.close();
	
	}
	@Override
	public void findNames(int deptno) {
		Session session=factory.openSession();
		Criteria crit=session.createCriteria(Employee.class);
		Projection p1=Projections.property("employeeName");
		Criterion c1=Restrictions.eq("deptNumber",deptno);
		crit.setProjection(p1);
		crit.add(c1);
		List list=crit.list();
		for(Object o:list)
		{
			String s=(String)o;
			System.out.println(s);
		}
		session.close();
	}
}
