package fr.uni.institute.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.dbunit.DBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoMock extends DBTestCase {
	Logger logger = LoggerFactory.getLogger(DaoMock.class);
	protected IDatabaseTester databaseTester;

	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.INSERT;
	}

	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.NONE;
	}

	public DaoMock(String name) {
		super(name);
		logger.warn(name);
	}

	private void createDatabaseIfNotExist(Connection cnx) {
		try {
			String sql = "CREATE TABLE T_CATEGORY (k_puid INTEGER, name VARCHAR(255), fk_puid_parent INTEGER);";
			PreparedStatement preparedStatement = cnx.prepareStatement(sql);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (Exception e) {

		}

	}

	protected void setUp() throws Exception {

		databaseTester =new JdbcDatabaseTester("org.hsqldb.jdbcDriver",
	            "jdbc:hsqldb:sample", "sa", "");
		createDatabaseIfNotExist(databaseTester.getConnection().getConnection());
		
		// initialize your dataset here
		IDataSet dataSet = getDataSet();
		// ...

		databaseTester.setDataSet(dataSet);
		// will call default setUpOperation
		databaseTester.onSetup();

	}

	protected void tearDown() throws Exception {
		// will call default tearDownOperation
		databaseTester.onTearDown();
	}

	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataFileLoader().getBuilder()
				.build(this.getClass().getClassLoader().getResource("dataset-" + getName() + ".xml"));

	}

}
