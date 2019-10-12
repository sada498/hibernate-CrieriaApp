package com.sada.hibernate.DAO;

public class EmployeeDAOFactory {
	public 	static EmployeeDAO getInstance()
	{
		return new EmployeeDAOImpl();
	}
}
