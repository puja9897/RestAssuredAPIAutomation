package api.endpoints;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints {
	
	static String bearerToken="7d7d287818fc2c7562e19c8b6442cf7de661dd358c61c292feae8b06e760b0f8";


	public static Response createUser(User payload) {
		Response res=given()
				.header("Authorization","Bearer "+bearerToken)

					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
				
				.when()
					.post(Routes.postURL);
				//	.jsonPath().getInt("id");
		
		return res;
	}
	
	
	public static Response getUser(int id) {
		return given()
				.header("Authorization","Bearer "+bearerToken)

					.pathParam("id", id)
				
				.when()
					.get(Routes.getURL);
		
	}

	
	public static Response updateUser(User payload,int id) {
		Response res=given()
				.header("Authorization","Bearer "+bearerToken)

					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
					.pathParam("id", id)

				
				.when()
					.put(Routes.updateURL);
		
		return res;
	}

	
	public static Response deleteUser(int id) {
		Response res=given()
				.header("Authorization","Bearer "+bearerToken)

					.pathParam("id", id)
				
				.when()
					.delete(Routes.deleteURL);
		
		return res;
	}

}
