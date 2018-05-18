package fr.uni.institute.library.web.tests;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;

import fr.uni.institute.library.web.ServletTitleDetail;

public class ServletTitleDetailTest{
	
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClass(ServletTitleDetail.class)
            ;
    }
	
	

	   @Test
	    public void should_create_greeting() {
		   ServletTitleDetail servletTitleDetail = new ServletTitleDetail();
	        Assert.assertEquals("Hello, Earthling!",
	        		servletTitleDetail.getServletName());
	        
	    }
}
