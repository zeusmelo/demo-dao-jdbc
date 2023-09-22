package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== Test 1: seller findById =====");
		Seller seller = sellerDao.findById(1);

		System.out.println(seller);

		System.out.println("\n === Test 2: seller findByDepartment=====");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);

	
		
		System.out.println("\n === Test 3: FindAllTest=====");
		
		list = sellerDao.findAll();
		
		list.forEach(System.out::println);
		
		System.out.println("\n === Test 4:INSERT SELLER=====");
		
		Seller newSeller = new Seller(null, "Derik", "Derik@gmail.com", new Date(), 4000.00, dep);
		
		sellerDao.insert(newSeller);
		
		
		System.out.println("\n === Test 5:UPDATE SELLER=====");
		
		seller = sellerDao.findById(1); //insert into the seller the one with the Id == 1;
		seller.setName("Bruce Wayne"); //change something
		
		sellerDao.update(seller); //update in Data Base
		
		System.out.println("\n === Test 5:DELETE SELLER=====");
		
		sellerDao.deleteById(5); //delete from db
		
		
		
	}

}
