package bean;

import java.sql.Array;
import java.util.ArrayList;

/* Bean class for Departments */

public class DepartmentBean {

	public String DepartmentName;
	public String DepartmentCode;
	public String Dean;
	public int flag=0;
	public ArrayList store;
	
	public String getDepartmentCode() {
		return DepartmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		DepartmentCode = departmentCode;
	}
	public String getDean() {
		return Dean;
	}
	public void setDean(String dean) {
		Dean = dean;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public ArrayList getStore() {
		return store;
	}
	public void setStore(ArrayList store) {
		this.store = store;
	}
	
	
	
	
	
	}