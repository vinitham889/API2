package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.User;
import api.endpoints.UserEndPoint;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
    User userPayload;
    
    @BeforeClass
    public void setupData()
    {
    	faker = new Faker();
    	userPayload = new User();
    	
    	userPayload.setId(faker.idNumber().hashCode());
    	userPayload.setUsername(faker.name().username());
    	userPayload.setFirstName(faker.name().firstName());
    	userPayload.setLastName(faker.name().lastName());
    	userPayload.setEmail(faker.internet().safeEmailAddress());
    	userPayload.setPassword(faker.internet().password(5,10));
    	userPayload.setPhone(faker.phoneNumber().cellPhone());
    	
    	
    }
    @Test(priority=1)
    public void testPostUser()
    {
    	Response response = UserEndPoint.createUser(userPayload);
    	
    	response.then().log().all();
    	Assert.assertEquals(response.getStatusCode(),200);
    }
    
    @Test(priority=2)
    public void testGetUser()
    {
    	Response response = UserEndPoint.readUser(this.userPayload.getUsername());
    	response.then().log().all();
    	Assert.assertEquals(response.getStatusCode(),200);
    }
    
    @Test(priority=3)
    public void testUpdateUser()
    {
    	userPayload.setUsername(faker.name().username());
    	userPayload.setFirstName(faker.name().firstName());
    	userPayload.setLastName(faker.name().lastName());
    	userPayload.setEmail(faker.internet().safeEmailAddress());
    	
    	Response response = UserEndPoint.updateUser(this.userPayload.getUsername(),userPayload);
    	response.then().log().all();
    	Assert.assertEquals(response.getStatusCode(),200);
    	
    	//checking data after update
    	Response responseAfterUpdate = UserEndPoint.readUser(this.userPayload.getUsername());
    	Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
    	
    }
    @Test(priority=4)
    public void testDeleteUser()
    {
    	Response response = UserEndPoint.deleteUser(this.userPayload.getUsername());
    	Assert.assertEquals(response.getStatusCode(),200);
    }
    
	

}
