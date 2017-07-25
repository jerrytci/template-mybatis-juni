package remix.chen.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import remix.chen.dao.MobileDao;
import remix.chen.domain.Mobile;
import remix.chen.service.MobileService;

@Controller
@RequestMapping("/mobile")
public class MobileController {

	@Resource
	private MobileService mobileServiceImpl;

	@Resource
	private MobileDao mobileDaoImpl;
	
	//select 
	@RequestMapping("/select/id") 
	public void selectMobileById(){
		int id = 12;
		Mobile mobile = mobileDaoImpl.selectMobileById(id);
		System.out.println("mobile:" + mobile);
		System.out.println("mobile:" + mobile.getPerson());
	}
	
	@RequestMapping("/select/all") 
	public void selectAllMobile() {

	}
	
	@RequestMapping("/update/1") 
	public void updateMobile(){

	}
}
