package api.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviderClass;
import io.restassured.response.Response;

public class DataDrivenTesting {

    static List<Integer> createdUserIds = new ArrayList<>();

User userPayload;
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviderClass.class)
	public void createUser(String Id,String name,String email,String gender,String status)
	{
		userPayload=new User();
		userPayload.setName(name);
		userPayload.setEmail(email);
		userPayload.setGender(gender);
		userPayload.setStatus(status);

		Response res=UserEndPoints.createUser(userPayload);
		res.then().log().all();
		 int userId = res.jsonPath().getInt("id");	
		    createdUserIds.add(userId);  // ✅ FIXED
		Assert.assertEquals(res.getStatusCode(), 201);
		
	}
	
    @Test(priority = 2)
    public void deleteUsers() {
        for (int userId : createdUserIds) {
            Response res = UserEndPoints.deleteUser(userId);
            res.then().log().all();
            Assert.assertEquals(res.getStatusCode(), 204);
        }
    }
}
