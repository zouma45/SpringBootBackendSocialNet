package backend.model.response;

import java.util.ArrayList;

import backend.entity.Skills;

public class UserResponse {

	private String id;
	private String name;
	private String lastName;
	private String pseudo;
	private String email;
	private String password;
	private ArrayList<Skills> skills;

	public UserResponse() {
		super();
	}

	public UserResponse(String id, String name, String lastName, String pseudo, String email, String password,
			ArrayList<Skills> skills) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
		this.skills = skills;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Skills> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Skills> skills) {
		this.skills = skills;
	}

}
