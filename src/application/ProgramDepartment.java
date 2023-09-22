package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDepartment {

	public static void main(String[] args) {
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		depDao.insert(new Department(null,"Configuration")); //working
		
		Department depFound = depDao.findById(1);
		
		System.out.println(depFound.getName()); //okay
		
		List<Department> listDep = depDao.findAll();
		
		listDep.forEach(System.out::println);
		
		depDao.deleteById(3);

	}

}
