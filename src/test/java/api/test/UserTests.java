package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	public Logger logger;
	
	@BeforeClass
	public void setupData()
	{
		faker=new Faker();
		userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setName(faker.name().fullName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setGender("Male");
		userPayload.setStatus("active");

		//logs
		
		logger=LogManager.getLogger(this.getClass());
		logger.debug("debugging");
	}
	
	@Test(priority=1)
	public void postUser()
	{
		logger.info("*****************************Creating Users**************************************");
		Response res=UserEndPoints.createUser(userPayload);
		res.then().log().all();
		 int userId = res.jsonPath().getInt("id");
		    userPayload.setId(userId);	
		Assert.assertEquals(res.getStatusCode(), 201);
		logger.info("*****************************Users Created Successfully**************************************");

	}
	
	@Test(priority = 2)
	public void getUserById() {
		
		
		logger.info("*****************************Get Users**************************************");

	    int retries = 5;
	    int waitMillis = 1000;
	    Response response = null;

	    for (int i = 0; i < retries; i++) {
	        response = UserEndPoints.getUser(this.userPayload.getId());
	        if (response.getStatusCode() == 200) {
	            break;
	        }

	        try {
	            Thread.sleep(waitMillis);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    response.then().log().all();
	    Assert.assertEquals(response.getStatusCode(), 200, "User not found after retries.");
	    
		logger.info("*****************************Users Displayed**************************************");

	}
	
	@Test(priority=3)
	public void updateUser()
	{
		logger.info("*****************************Updating Users**************************************");

		userPayload.setStatus("inactive");

		Response response = UserEndPoints.updateUser(userPayload,this.userPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*****************************Users updated**************************************");

	}
	
	@Test(priority=4)
	public void deleteUser()
	{
		logger.info("*****************************Deleting Users**************************************");

		Response response=UserEndPoints.deleteUser(this.userPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 204);
		
		logger.info("*****************************Users deleted**************************************");

	}
}
