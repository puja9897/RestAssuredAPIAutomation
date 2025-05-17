package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


/*
 * Create user: https://petstore.swagger.io/v2/user

 * 
 */


//"https://gorest.co.in/public/v2/users"

public class Routes {

	public static String baseURL="https://gorest.co.in/public/v2";
	
	public static String postURL=baseURL+"/users";
	public static String getURL=baseURL+"/users/{id}";
	public static String updateURL=baseURL+"/users/{id}";
	public static String deleteURL=baseURL+"/users/{id}";
}
