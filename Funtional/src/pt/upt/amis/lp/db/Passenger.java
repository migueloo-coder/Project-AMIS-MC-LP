package pt.upt.amis.lp.db;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int idDocument; 	
	@Basic
	private String names;
	private String surnames;
	private String genre;
	private String typeId; 
	private String address; 
	private String telephone; 
	private String email; 
	private String passport;
	private String nationality;
	@Temporal(TemporalType.DATE)
	private Date dateBirth; 
	
	
	public Passenger(int idDocument, String names, String surnames, String genre, Date dateBirth, String typeId, 
			String address, String telephone, String email, String passport, String nationality) {
		
		this.idDocument = idDocument;
		this.names = names;
		this.surnames = surnames;
		this.genre = genre;
		this.dateBirth = dateBirth;
		this.typeId = typeId;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.passport = passport;
		this.nationality = nationality;
	}

	public int getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}
	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	

}
