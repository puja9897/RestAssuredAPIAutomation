package api.endpoints;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints2 {
	
	static String bearerToken="7d7d287818fc2c7562e19c8b6442cf7de661dd358c61c292feae8b06e760b0f8";

	//method created for getting URL from properties file
	static ResourceBundle getURL()
	{
		ResourceBundle route = ResourceBundle.getBundle("route");//name of the property file to load the file
		return route;
	}
	
	
	public static Response createUser(User payload) {
		
		String postURL=getURL().getString("postURL");
		Response res=given()
				.header("Authorization","Bearer "+bearerToken)

					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
				
				.when()
					.post(postURL);
				//	.jsonPath().getInt("id");
		
		return res;
	}
	
	
	public static Response getUser(int id) {
		
		String getURL=getURL().getString("getURL");

		return given()
				.header("Authorization","Bearer "+bearerToken)

					.pathParam("id", id)
				
				.when()
					.get(getURL);
		
	}

	
	public static Response updateUser(User payload,int id) {
		
		String updateURL=getURL().getString("updateURL");

		Response res=given()
				.header("Authorization","Bearer "+bearerToken)

					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
					.pathParam("id", id)

				
				.when()
					.put(updateURL);
		
		return res;
	}

	
	public static Response deleteUser(int id) {
		
		String deleteURL=getURL().getString("deleteURL");

		Response res=given()
				.header("Authorization","Bearer "+bearerToken)

					.pathParam("id", id)
				
				.when()
					.delete(deleteURL);
		
		return res;
	}

}
