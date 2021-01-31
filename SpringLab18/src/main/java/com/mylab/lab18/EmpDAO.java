package com.mylab.lab18;

import java.util.List;


public interface EmpDAO {
	
	 public List<Emp> selectEmployee();
	 public void insertEmployee(Emp emp);
	 public void editEmployee(Emp emp);
	 public void deleteEmployee(Emp emp);
}
