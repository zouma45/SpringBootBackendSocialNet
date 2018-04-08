package backend.model.response;

public class ContactResponse {

	private String id;
	private String name;
	private String lname;
	private String adress;
	private String mail;

	public ContactResponse() {
		super();
	}

	public ContactResponse(String id, String name, String lname, String adress, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.lname = lname;
		this.adress = adress;
		this.mail = mail;
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
