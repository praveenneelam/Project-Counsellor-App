package in.ashokit.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.dto.Dashboard;
import in.ashokit.entity.Counsellor;
import in.ashokit.entity.Enquiry;
import in.ashokit.repo.CounsellorRepository;
import in.ashokit.repo.EnquiryRepository;

@Service
public  class EnquiryServiceImpl implements EnquiryService {
	
	@Autowired
	private EnquiryRepository enqRepo;
	
	@Autowired
	private CounsellorRepository counsellorRepo;

	@Override
	public Dashboard getDashboardInfo(Integer counsellorId) {
		
		Long totalEnq = enqRepo.getEnquries(counsellorId);
		Long openCnt = enqRepo.getEnquries(counsellorId, "open");
		Long lostCnt = enqRepo.getEnquries(counsellorId,"Lost");
		Long enrolledCnt = enqRepo.getEnquries(counsellorId,"Enrolled"); 
		
		Dashboard d = new Dashboard();
		d.setTotalEnqs(totalEnq);
		d.setEnrolledenqs(enrolledCnt);
		d.setLostEnqs(lostCnt);
		d.setOpenEnqs(openCnt);
		
		return d;
	}

	@Override
	public boolean addEnquiry(Enquiry enquiry, Integer counsellorId) {
		
		Counsellor counsellor = counsellorRepo.findById(counsellorId).orElseThrow();
		enquiry.setCounsellor(counsellor);
		Enquiry savedEnq = enqRepo.save(enquiry);
		
		return savedEnq.getEnqId()!=null;
	}

	@Override
	public List<Enquiry> getEnquiries(Enquiry enquiry, Integer counsellorId) {
		
		Counsellor counsellor = counsellorRepo.findById(counsellorId).orElseThrow();
        enquiry.setCounsellor(counsellor);
		Example <Enquiry> of  = Example.of(enquiry);
		return enqRepo.findAll(of);
	}

	@Override
	public Enquiry getEnquiry(Integer enqId) {
		return enqRepo.findById(enqId).orElseThrow();
	}

	@Override
	public Dashboard getDashboradInfo(Integer counsellorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
