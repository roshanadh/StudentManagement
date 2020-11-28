package np.com.roshanadhikary.studentmgmt.dto;

import java.util.List;

public class Student {
	
	private int id;

	private String 
		name,
		address,
		gender,
		country;
	
	private List<String>
		hobbies,
		languages;
	
	private String
		stringifiedHobbies,
		stringifiedLanguages;
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> listOfHobbies) {
		this.hobbies = listOfHobbies;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public String getStringifiedHobbies() {
		return stringifiedHobbies;
	}

	public void setStringifiedHobbies(String stringifiedHobbies) {
		this.stringifiedHobbies = stringifiedHobbies;
	}

	public String getStringifiedLanguages() {
		return stringifiedLanguages;
	}

	public void setStringifiedLanguages(String stringifiedLanguages) {
		this.stringifiedLanguages = stringifiedLanguages;
	}
}
