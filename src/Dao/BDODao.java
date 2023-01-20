package Dao;

import java.util.List;

import Exception.BDOException;
import Exception.CredentialException;
import Exception.EmployeeException;
import Exception.GPMException;
import Exception.ProjectException;
import Model.Employee;
import Model.GPM;
import Model.Project;

public interface BDODao {
	
	public String BDOLogin(String phone,String password) throws CredentialException;
	
	public String CreateProject(Project project) throws ProjectException;
	
	public List<Project> ListOfProject() throws ProjectException;
	
	public String CreatGPM(GPM gpm) throws GPMException;
	
	public List<GPM> ListOfGPM() throws GPMException;
	
	public String AllocateProjectToGPM(int pid,int gpmid) throws ProjectException, GPMException, BDOException;
	
	public List<Employee> EmployeeOnProject(int pid) throws EmployeeException,ProjectException;

}
