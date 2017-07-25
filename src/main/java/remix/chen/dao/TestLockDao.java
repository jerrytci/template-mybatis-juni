package remix.chen.dao;

import java.util.List;

//import com.chrhc.mybatis.locker.annotation.VersionLocker;
import org.springframework.stereotype.Repository;
import remix.chen.domain.TestLock;

@Repository
public interface TestLockDao{
	public int testLock(TestLock testLock);
	public int selectLockVersionById(int id);
//	public int updateVersionById(@Param("id")int id,@Param("version")int version);
	public int updateLock(TestLock testLock);
	
//	@VersionLocker(false)
	public int updateVersionAutoIncreaseOneById(int id);
	
	public List<TestLock> selectAllLock();
}
