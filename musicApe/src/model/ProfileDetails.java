package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProfileDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfileDetails;
	private String name = "default";
	private String djName = "default";
	private String description = "default";
	private String soundCloudURL = "default";
	private String genre = "default";
	@OneToOne
	private User user;
	
	public int getIdProfileDetails() {
		return idProfileDetails;
	}
	public void setIdProfileDetails(int idProfileDetails) {
		this.idProfileDetails = idProfileDetails;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setIdProfileDetails(Integer idProfileDetails) {
		this.idProfileDetails = idProfileDetails;
	}
	public String getDjName() {
		return djName;
	}
	public void setDjName(String djName) {
		this.djName = djName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSoundCloudURL() {
		return soundCloudURL;
	}
	public void setSoundCloudURL(String soundCloudURL) {
		this.soundCloudURL = soundCloudURL;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
