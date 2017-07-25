package remix.chen.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import remix.chen.dao.TestLockDao;
import remix.chen.service.TestLockService;

@Controller
@RequestMapping("/lock")
public class Lock {

	@Resource
	private TestLockDao testLockDaoImpl;

	@Resource
	private TestLockService testLockServiceImpl;

	@RequestMapping("/plugin")
	public void testLockPlugin(){
	    System.out.println("hah");
		int resultUpdate = testLockServiceImpl.testLockPluginBind();
		System.out.println(">>testLockPluginBind(),resultUpdate:"+resultUpdate);
	}
	
	@RequestMapping("/plugin2")
	public void testLockBind(){
		int resultUpdate = testLockServiceImpl.testLockBind();
		System.out.println(">>testLockPluginBind(),resultUpdate:"+resultUpdate);
	}
	
	@RequestMapping("/ehcache")
	public void testEhcache(){

		Long begin = System.currentTimeMillis();
		testLockDaoImpl.selectAllLock();
		Long end = System.currentTimeMillis();
		Long begin2 = System.currentTimeMillis();
		testLockDaoImpl.selectAllLock();
		Long end2 = System.currentTimeMillis();
		System.out.println("第一次时间所需时间:"+(begin-end));
		System.out.println("第二次时间所需时间:"+(begin2-end2));
	}
}
