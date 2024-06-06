package in.ashokit.entity;


import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Counsellor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer counsellorId;
	
	private String name;
	
	private String email;
	
	private String pwd;
	
	private Long phno;
	
	@CreationTimestamp
	private LocalDate createdData;
	
	@UpdateTimestamp
	private LocalDate updatedData;
	
	@OneToMany(mappedBy = "counsellor",cascade = CascadeType.ALL)
	private List<Enquiry> enquiries;

	public Integer getCounsellorId() {
		return counsellorId;
	}

	public void setCounsellorId(Integer counsellorId) {
		this.counsellorId = counsellorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public LocalDate getCreatedData() {
		return createdData;
	}

	public void setCreatedData(LocalDate createdData) {
		this.createdData = createdData;
	}

	public LocalDate getUpdatedData() {
		return updatedData;
	}

	public void setUpdatedData(LocalDate updatedData) {
		this.updatedData = updatedData;
	}

	public List<Enquiry> getEnquiries() {
		return enquiries;
	}

	public void setEnquiries(List<Enquiry> enquiries) {
		this.enquiries = enquiries;
	}


	public Counsellor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Counsellor [counsellorId=" + counsellorId + ", name=" + name + ", email=" + email + ", pwd=" + pwd
				+ ", phno=" + phno + ", createdData=" + createdData + ", updatedData=" + updatedData + ", enquiries="
				+ enquiries + "]";
	}

	public Counsellor(Integer counsellorId, String name, String email, String pwd, Long phno, LocalDate createdData,
			LocalDate updatedData, List<Enquiry> enquiries) {
		super();
		this.counsellorId = counsellorId;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.phno = phno;
		this.createdData = createdData;
		this.updatedData = updatedData;
		this.enquiries = enquiries;
	}
	
	

}
