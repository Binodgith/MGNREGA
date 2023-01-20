package Dao;

import java.util.List;

import Exception.CredentialException;
import Exception.EmployeeException;
import Exception.GPMException;
import Exception.ProjectException;
import Model.Employee;
import Model.Employee_total;

public interface GPMDao {
	
	public String GMPLogin(String gphone,String password) throws CredentialException,GPMException;
	
	public String CreateEmployee(Employee employee) throws EmployeeException;
	
	public List<Employee> ListOfEmployee() throws EmployeeException;
	
	public String AssignProjectToEmployee(int pid,int eid) throws ProjectException,EmployeeException,GPMException;
	
	public List<Employee_total> EmployeeDayWages() throws EmployeeException;
	
	

}
