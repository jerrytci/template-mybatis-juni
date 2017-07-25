package remix.chen.test;

import javax.annotation.Resource;

import org.junit.Test;

import remix.chen.dao.TestLockDao;
import remix.chen.dao.impl.TestLockDaoImpl;
import remix.chen.domain.TestLock;
import remix.chen.service.TestLockService;
import remix.chen.service.impl.TestLockServiceImpl;
import remix.chen.test.SpringTestCase;

public class TestLockTest extends SpringTestCase{
	
	@Resource
	private TestLockDao testLockDaoImpl;
	
	@Resource
	private TestLockService testLockServiceImpl;
	
	@Test
	public void testLock(){
		TestLock testLock = new TestLock(5,"20170215刚过完情人节6");
		
		//读取当前版本号的值,设定到更改的版本号中
		int version = testLockServiceImpl.selectLockVersionById(5);
		testLock.setVersion(version);
		
//		int alterVersion = testLockServiceImpl.updateVersionById(5,1);
		
		int resultUpdate = testLockServiceImpl.testLockService(testLock);
		
		System.out.println(">>in TestLockTest.testLock(),resultUpdate:"+resultUpdate);
	}
	
	//封装好的测试version的方法
	@Test
	public void testLockBind(){
		int resultUpdate = testLockServiceImpl.testLockBind();
		System.out.println(">>testLockBind(),resultUpdate:"+resultUpdate);
	}
	
	//封装好的测试version插件的方法
	@Test
	public void testLockPluginBind(){
		int resultUpdate = testLockServiceImpl.testLockPluginBind();
		System.out.println(">>testLockPluginBind(),resultUpdate:"+resultUpdate);
	}
	
	//通过观察花费时间的值大小来判断ehcache是否起效
	//成功
	@Test
	public void testEhcache(){
		Long begin = System.currentTimeMillis();
		testLockDaoImpl.selectAllLock();
		Long end = System.currentTimeMillis();
		Long begin2 = System.currentTimeMillis();
		testLockDaoImpl.selectAllLock();
		Long end2 = System.currentTimeMillis();
		System.out.println("第一次时间所需时间:"+(end-begin));
		System.out.println("第二次(使用cache后)时间所需时间:"+(end2-begin2));
	}
	
	
}
