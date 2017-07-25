package remix.chen.service;

//import com.chrhc.mybatis.locker.annotation.VersionLocker;
import org.springframework.stereotype.Repository;
import remix.chen.domain.TestLock;

@Repository
public interface TestLockService {
	public int testLockService(TestLock testLock);
	public int selectLockVersionById(int id);
	public int updateVersionById(int id,int version);
//	@VersionLocker(false)
	public int updateVersionAutoIncreaseOneById(int id);
	public int testLockBind();
	public int testLockPluginBind();
}
