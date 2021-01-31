package com.mylab.lab18;

import java.util.List;

public interface EmpService {
	public void insertEmployee(Emp emp) throws Exception;
	public List<Emp> selectEmployee() throws Exception;
	public void editEmployee(Emp emp) throws Exception;
	public void deleteEmployee(Emp emp) throws Exception;
}
