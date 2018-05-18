package fr.uni.institute.library.web.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;

public class IndexITTestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Properties props = new Properties();
		try {
			props.load(getClass().getClassLoader().getResourceAsStream("web-it.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final String ADDRESS = props.getProperty("ti.server.url");

		 	try {
					WebConversation webConversation = new WebConversation();
					WebResponse menuResponse = webConversation.getResponse(ADDRESS);
					assertEquals("UNI Institute - UNI Library - fr_FR", menuResponse.getTitle());
				} catch (SAXException  e) {
					fail("SAXException: " + e.getMessage());
				} catch (IOException e) {
					fail("IOException: " + e.getMessage());
				}
			
	}

}