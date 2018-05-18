package fr.uni.institute.library.dao;

import java.sql.SQLException;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.uni.institute.library.dao.jdbc.CategoryDaoJdbc;

public class CategoryDaoTest extends DaoMock {
	Logger logger = LoggerFactory.getLogger(CategoryDaoTest.class);

	
	public CategoryDaoTest(String name) {
		super(name);
		logger.warn(name);

	}

	
	@Test
	
	public void testResearchAllCategories() {


		try {
			CategoryDao categoryDao = new CategoryDaoJdbc(databaseTester.getConnection().getConnection());
			assertNotNull(categoryDao.researchAllCategories());
			assertEquals(2, categoryDao.researchAllCategories().size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
