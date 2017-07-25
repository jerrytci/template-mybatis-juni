package remix.chen.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import remix.chen.dao.TestLockDao;
import remix.chen.domain.Mobile;
import remix.chen.domain.Person;
import remix.chen.domain.TestLock;
import remix.chen.service.MobileService;
import remix.chen.service.TestLockService;

import javax.annotation.Resource;

//import com.chrhc.mybatis.locker.annotation.VersionLocker;

@Transactional
@Service
public class TestLockServiceImpl implements TestLockService {

	@Resource
	private TestLockDao testLockDaoImpl;

	@Resource
	private MobileService mobileService;


	public int testLockService(TestLock testLock) {
		int resultUpdate = testLockDaoImpl.testLock(testLock);
		System.out.println(">>in testLockService(),resultUpdate:"+resultUpdate);
		return resultUpdate;
	}

	@Transactional
	public int testLockBind(){
//		public int testLockBind() throws OptimisticLockingFailureException{

		Mobile mobile = new Mobile(20, 1101, "诺基亚1101");
		//构建person对象，设置id属性就可以了。
		Person person = new Person(11);
		mobile.setPerson(person);
		mobileService.insertMobile(mobile);

		//测试的 id值
		int id = 5;
		TestLock testLock = new TestLock(id,"20170215刚过完情人节");

		//读取当前版本号的值,设定到更改的版本号中
		int version = selectLockVersionById(id);
		testLock.setVersion(version);

		//手动更改version值,以便于测试version（乐观锁）是否成功。这个语句的作用相当于另外一个线程访问了并修改了version值
//		int alterVersion = updateVersionById(id,version+1);

		//
		int resultUpdate = testLockDaoImpl.testLock(testLock);

//		如何手动抛出异常
		if(resultUpdate ==0){
//	　　		throw new OptimisticLockingFailureException("1");
			throw new IllegalArgumentException("参数长度应为7");
		}
		return resultUpdate;
	}

	@Transactional
//	@VersionLocker(false)
	public int updateVersionAutoIncreaseOneById(int id) {
		int alterVersion = testLockDaoImpl.updateVersionAutoIncreaseOneById(id);
		return alterVersion;
	}

	public int selectLockVersionById(int id) {
		int version = testLockDaoImpl.selectLockVersionById(id);
		return version;
	}

	public int updateVersionById(int id,int version) {
//		int alterVersion = testLockDaoImpl.updateVersionById(id,version);
//		return alterVersion;
		return 1;
	}

	//结果：插件测试失败，当并发update失败时，整个事务并不会失败，只是这个update语句失败而已。所以如果是关联update的话可能会造成事务的不完整
	@Transactional
	public int testLockPluginBind() {

		Mobile mobile = new Mobile(18, 1101, "诺基亚1101");
		//构建person对象，设置id属性就可以了。
		Person person = new Person(11);
		mobile.setPerson(person);
		mobileService.insertMobile(mobile);

		//测试的 id值
		int id = 5;
		TestLock testLock = new TestLock(id,"20170215刚过完情人节3");

		//读取当前版本号的值,设定到更改的版本号中
		//经过测试，是必须要从数据库中获取。
		int version = selectLockVersionById(id);
		testLock.setVersion(version);

		//手动更改version值,以便于测试version（乐观锁）是否成功。这个语句的作用相当于另外一个线程访问了并修改了version值
//		int alterVersion = updateVersionById(id,version+1);
//		int alterVersion = updateVersionAutoIncreaseOneById(id);

		//手动更改的另外一个方法，用controller调用这个方法，在这个地方打一个断点，调试执行完setVersion()方法后，手动去数据库更改。

		//
		int resultUpdate = testLockDaoImpl.updateLock(testLock);
		return resultUpdate;
	}
}
