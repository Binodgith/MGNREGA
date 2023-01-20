package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Exception.BDOException;
import Exception.CredentialException;
import Exception.EmployeeException;
import Exception.GPMException;
import Exception.ProjectException;
import Model.Employee;
import Model.GPM;
import Model.Project;
import Utility.Utility;

public class BDODao_impl<Empoyee> implements BDODao{

	@Override
	public String BDOLogin(String phone, String password) throws CredentialException {
		
		String message="Invalid Phone & Password";
		
		if(phone.equals("9114167352") && password.equals("BDO_91141")) {
			message="Login Successfull ! Welcome to BDO Dashboard ";
		}
		else {
			throw new CredentialException(message);
		}
		
		
		return message;
		
	}

	
	
	
	
	@Override
	public String CreateProject(Project project) throws ProjectException {
		String message="Project Not Created";
		
		try(Connection con=Utility.ProvideConnection()){
			
			PreparedStatement ps=con.prepareStatement("insert into Project(pname,pcost,pduration) values(?,?,?)");
			ps.setString(1, project.getPname());
			ps.setInt(2, project.getPcost());
			ps.setInt(3,project.getPduration());
			
			int x=ps.executeUpdate();
			if(x>0) message="Proeject Created Successfully";
			else throw new ProjectException(message);
			
			
		}
		catch(SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		
		return message;
	}

	
	
	
	
	@Override
	public List<Project> ListOfProject() throws ProjectException {
		List<Project> list=new ArrayList<>();
		
		try(Connection con=Utility.ProvideConnection()){
			PreparedStatement ps=con.prepareStatement("Select * from Project");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				int pid=rs.getInt("pid");
				String pname=rs.getString("pname");
				int pcost=rs.getInt("pcost");
				int pduration=rs.getInt("pduration");
				int pgpmid=rs.getInt("pgpmid");
				
				list.add(new Project(pid,pname,pcost,pduration,pgpmid));
				
				
			}
			
		}
		catch(SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		if(list.isEmpty()) {
			throw new ProjectException("No Project Found");
		}
		
		
		return list;
	}

	
	
	
	
	@Override
	public String CreatGPM(GPM gpm) throws GPMException {
		String result ="! No Gram Panchayat Member Inserted.";
		
		try (Connection conn = Utility.ProvideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into grampanchayatmember (gpmname,gpmaddress,gpmphone,gpmpassword) values(?,?,?,?)");
			
			ps.setString(1, gpm.getGpmname());
			ps.setString(2, gpm.getGpmaddress());
			ps.setString(3, gpm.getGpmphone());
			ps.setString(4, gpm.getGpmpassword());
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				result = "Gram Panchayat Member data Inserted Successfully.";
			}else {
				throw new GPMException(result);
			}
			
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		return result;
	}






	@Override
	public List<GPM> ListOfGPM() throws GPMException {
		List<GPM> GPMList = new ArrayList<>();
		
		try (Connection conn = Utility.ProvideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from grampanchayatmember");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int gpmid = rs.getInt("gpmid");
				String gpmname = rs.getString("gpmname");
				String gpmaddress = rs.getString("gpmaddress");
				String gpmphone = rs.getString("gpmphone");
				String gpmpassword = rs.getString("gpmpassword");
				
				
				GPM g = new GPM(gpmid, gpmname, gpmaddress, gpmphone, gpmpassword);
				GPMList.add(g);
			}
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		if(GPMList.size() ==0) {
			throw new GPMException("Exception : No Gram Panchayat Member Found.");
		}
		
		return GPMList;
	}

	
	
	
	
	@Override
	public String AllocateProjectToGPM(int pid, int gpmid) throws ProjectException, GPMException, BDOException {
		String result = "Not allocated ";
		
		
		try (Connection conn = Utility.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from grampanchayatmember where gpmid = ?");
			ps.setInt(1, gpmid);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				PreparedStatement ps2 = conn.prepareStatement("select * from project where pid = ?");
				ps2.setInt(1,pid);
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					
					PreparedStatement ps3 = conn.prepareStatement("update project set pgpmid = ? where pid = ?");
					ps3.setInt(1, gpmid);
					ps3.setInt(2, pid);
					
					int x = ps3.executeUpdate();
					
					if(x > 0) {
						result = "Project with PID ID : " + pid +" Allocated to GPM with GPM ID : " +gpmid ;
						return result;
					}
	
				}else {
					throw new ProjectException("Project don't exist with PID : " + pid);	
				}

				
			}else {
				throw new GPMException("Gram Panchyat Member don't exist with GPID :" + gpmid);
			}
			
			
			
			
		} catch (SQLException e) {
			throw new BDOException(e.getMessage());
		}

		return result;
	}
	
	
	

	@Override
	public List<Employee> EmployeeOnProject(int pid) throws EmployeeException, ProjectException,BDOException {
		List<Employee> empList = new ArrayList<>();
		
		
		try (Connection conn = Utility.ProvideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from project where pid =?");
			ps.setInt(1, pid);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement("select * from employee e inner join project p on e.epid = p.pid where p.pid = ?");
				ps2.setInt(1, pid);
				
				ResultSet rs2 = ps2.executeQuery();
				
				while(rs2.next()) {

					int eid = rs2.getInt("eid");
					int egpmid = rs2.getInt("egpmid");
					int epid = rs2.getInt("epid");
					String ename = rs2.getString("ename");
					String eaddress = rs2.getString("eaddress");
					String ephone=rs2.getString("ephone");
					Date edate = rs2.getDate("edate");
					int ewage = rs2.getInt("ewage");
					
					
					Employee e = new Employee(eid, ename, eaddress, ephone, ewage, edate, egpmid,epid);
					empList.add(e);
		
				}
				
			}else {
				throw new ProjectException("No Project found with PID ID : " + pid);
			}
		
		} catch (SQLException e) {
			throw new BDOException(e.getMessage());
		}
		
		if(empList.size() ==0) {
			throw new EmployeeException("Exception : No Employee Found in the given PID : " + pid);
		}
			
		return empList;
	}

}
