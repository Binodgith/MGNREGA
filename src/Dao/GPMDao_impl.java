package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import Exception.CredentialException;
import Exception.EmployeeException;
import Exception.GPMException;
import Exception.ProjectException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Employee;
import Model.Employee_total;
import Utility.Utility;

public class GPMDao_impl implements GPMDao{

	@Override
	public String GMPLogin(String gpmphone, String gpmpassword) throws CredentialException,GPMException {
		String message="Invalid Input !";
		
		try(Connection con=Utility.ProvideConnection()){
			
			PreparedStatement ps=con.prepareStatement("select * from grampanchayatmember");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				String phone=rs.getString("gpmphone");
				String password=rs.getString("gpmpassword");
				
				if(gpmphone.equals(phone) && gpmpassword.equals(password)) {
					message="Login Successfull ! Welcome to Gram Panchayt Member Dashboard";
					return message;
					
				}
			}
			
			message="Wrong Credentia !";
			throw new CredentialException(message);
			
			
		}
		catch(SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		
		
	}

	
	
	
	@Override
	public String CreateEmployee(Employee employee) throws EmployeeException {
		String result ="Employee Not Created";
		
		try (Connection conn = Utility.ProvideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into employee(ename,eaddress,ephone,edate,ewage) values(?,?,?,curdate(),?)");
			ps.setString(1, employee.getEname());
			ps.setString(2, employee.getEaddress());
			ps.setString(3, employee.getEphone());
			ps.setInt(4, employee.getEwage());
			
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				result = "Employee Created Successfully";
			}else {
				throw new EmployeeException(result);
			}
			
		} catch (SQLException s) {
			throw new EmployeeException(s.getMessage());
		}
		
		return result;
		
		
	}

	




	@Override
	public List<Employee> ListOfEmployee() throws EmployeeException {
		List<Employee> empList = new ArrayList<>();
		
		try (Connection conn = Utility.ProvideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("eid");
				int egmpid = rs.getInt("egpmid");
				int epid = rs.getInt("epid");
				String ename = rs.getString("ename");
				String ephone=rs.getString("ephone");
				String eaddress = rs.getString("eaddress");
				Date edate = rs.getDate("edate");
				int ewage = rs.getInt("ewage");
				
				
				Employee e = new Employee(eid, ename, eaddress,ephone,  ewage,edate,egmpid, epid);
				empList.add(e);
			}
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		if(empList.size() ==0) {
			throw new EmployeeException("Exception : No Employeet Found.");
		}
		
		return empList;
	}

	
	
	
	
	@Override
	public String AssignProjectToEmployee(int pid, int eid) throws ProjectException, EmployeeException, GPMException {
		
		String result = "Employee not assinged to project";
		
		
		try (Connection conn = Utility.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where eid = ?");
			ps.setInt(1, eid);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("select * from project where pid = ? ");
				ps2.setInt(1, pid);
				
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()){
					
					PreparedStatement ps3 = conn.prepareStatement("update employee set epid = ? where eid =?");
					ps3.setInt(1, pid);
					ps3.setInt(2, eid);
					
					int x = ps3.executeUpdate();
					
					if(x>0) {
						result = "Project with PID ID : " + pid + " assigned to employee with EID ID : " + eid;
						return result;
					}
					
					
					
				}else {
					throw new ProjectException("Either Project don't exist or NOT assinged to Logined Gram Panchayat Member Account by BDO");
				}
				
				
			}else {
				throw new EmployeeException("Either employee don't exist or assigned by different Gram Panchayat Member ");
			}
			
			
			
			
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
	
		return result;
	}

	
	
	
	
	
	@Override
	public List<Employee_total> EmployeeDayWages() throws EmployeeException {
		List<Employee_total> dayandWageList = new ArrayList<>();
		
		
		try (Connection conn = Utility.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(" select e.eid,e.ename,p.pid,p.pname,e.edate,datediff(curdate(),e.edate) days,e.ewage,datediff(curdate(),e.edate)*e.ewage total from employee e inner join project p on e.epid = p.pid group by e.eid");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				Date date = rs.getDate("edate");
				int days = rs.getInt("days");
				int wage = rs.getInt("ewage");
				int total = rs.getInt("total");
				
				Employee_total empWageTotal = new Employee_total(eid, ename, pid, pname, date, days, wage, total);
				dayandWageList.add(empWageTotal);	
				
			}
			
			
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		
		if(dayandWageList.size() ==0) {
			throw new EmployeeException("Exception : No employee Found in DataBase");
		}
			
		return dayandWageList;
	}
	
	

}
