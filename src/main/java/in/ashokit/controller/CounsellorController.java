package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import in.ashokit.dto.Dashboard;
import in.ashokit.entity.Counsellor;
import in.ashokit.service.CounsellorService;
import in.ashokit.service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {

	@Autowired
	private CounsellorService counsellorService;

	@Autowired
	private EnquiryService enqService;

	@GetMapping("/logout")
	public String logout(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false); // get session
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "registerView";
	}

	@PostMapping("/register")
	public String handleRegsiter(Counsellor c, Model model) {
		boolean status = counsellorService.saveCounsellor(c);
		if (status) {
			model.addAttribute("smsg", "Counsellor Saved");

		} else {
			model.addAttribute("emsg", "Failed to Save");
		}
		return "registerView";
	}

	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "index";
	}

	@PostMapping("/login")
	public String handleLogin(Counsellor counsellor, HttpServletRequest req, Model model) {

		Counsellor c = counsellorService.getCounsellor(counsellor.getEmail(), counsellor.getPwd());

		if (c == null) {
			model.addAttribute("emsg", "Invalid Credentials");
			return "index";

		} else {

			// set counsellor-id in session
			HttpSession session = req.getSession(true);
			session.setAttribute("cid", c.getCounsellorId());

			Dashboard dbinfo = enqService.getDashboardInfo(c.getCounsellorId());
			model.addAttribute("dashboard", dbinfo);
			return "dashboard";
		}
	}
	
	@GetMapping("/dashboard")
	public String  dashboardhandle(HttpServletRequest req,Model model) {
		
		HttpSession session = req.getSession(false);
		Integer cid = (Integer)session.getAttribute("cid");
		
		Dashboard dInfo = enqService.getDashboardInfo(cid);
		model.addAttribute("dashboard", dInfo);
		return "dashboard";
	}

}
