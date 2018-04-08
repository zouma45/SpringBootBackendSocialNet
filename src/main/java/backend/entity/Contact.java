package backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contact")
public class Contact {

	@Id
	private String id;

	private String name;
	private String lname;
	private String adress;
	@Indexed(unique = true)
	private String mail;

	public Contact(String id, String name, String lname, String adress, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.lname = lname;
		this.adress = adress;
		this.mail = mail;
	}
	
	

	public Contact(String name, String lname, String adress, String mail) {
		super();
		this.name = name;
		this.lname = lname;
		this.adress = adress;
		this.mail = mail;
	}



	public Contact() {
		super();
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

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
