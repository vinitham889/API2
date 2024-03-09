package api.endpoints;

/*Swagger URI https://petstore.swagger.io/
 * Create User(post) https://petstore.swagger.io/v2/user
 * Get user(Get) https://petstore.swagger.io/v2/user/{username}
 * Update user(put) https://petstore.swagger.io/v2/user/{username}
 * Delete user(delete) https://petstore.swagger.io/v2/user/{username}
 * 
 *  * 
 * */

public class Routes {
	
	//user module
	
	public static String baseUrl ="https://petstore.swagger.io/v2";
	
	public static String postUrl =baseUrl+"/user";
	
	public static String getUrl = baseUrl+"/user/{username}";
	
	public static String putUrl = baseUrl+"/user/{username}";
	
	public static String deleteUrl = baseUrl+"user/{username}";
	

}
