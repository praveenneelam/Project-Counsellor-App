package in.ashokit.service;


import java.util.List;

import in.ashokit.dto.Dashboard;
import in.ashokit.entity.Enquiry;

public interface EnquiryService {
	
	// for dashborad page
	public Dashboard getDashboradInfo(Integer counsellorId);
	
	// save enquiry
	public boolean addEnquiry(Enquiry enquiry, Integer counsellorId);
	
	// view enquiries + fliter
	public List<Enquiry> getEnquiries (Enquiry enquiry, Integer counsellorId);
	
	// edit 
	public Enquiry getEnquiry(Integer enqId);

	Dashboard getDashboardInfo(Integer counsellorId);

}
