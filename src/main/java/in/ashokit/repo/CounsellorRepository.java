package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Counsellor;

public interface CounsellorRepository  extends JpaRepository<Counsellor, Integer>{
	
	public Counsellor findByEmailAndPwd(String email,String pwd);
	
	public Counsellor findByEmail(String email);

}
