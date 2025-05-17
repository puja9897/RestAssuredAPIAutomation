package api.payload;

public class User {

	/*
	 * 
	 * 
	 * 		data.put("name", faker.name().fullName());
		data.put("email", faker.internet().safeEmailAddress());
		data.put("gender", "Male");
		data.put("status", "inactive");
	 */
	String name;
	String email;
	String gender;
	String status="inactive";
	int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
