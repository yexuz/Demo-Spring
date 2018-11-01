package spittr;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Spitter {
	
    private long id;
    @NotNull(message="aa")
	@Size(min=5,max=16,message="aaa")
	private String firstName;
    @NotNull
	@Size(min=5,max=25)
	private String lastName;
    @NotNull
	@Size(min=2,max=30)
	private String username;
    @NotNull
	@Size(min=5,max=30)
	private String Register;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRegister() {
		return Register;
	}
	public void setRegister(String register) {
		Register = register;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Spitter(String firstName, String lastName, String username, String register) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		Register = register;
	}
	public Spitter(long id, String firstName, String lastName, String username, String register) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		Register = register;
	}
	
	
}
