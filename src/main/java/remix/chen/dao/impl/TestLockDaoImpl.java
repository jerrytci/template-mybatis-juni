package remix.chen.dao.impl;

import org.springframework.stereotype.Repository;
import remix.chen.dao.TestLockDao;
import remix.chen.domain.TestLock;

import java.util.List;

//import com.chrhc.mybatis.locker.annotation.VersionLocker;

@Repository
public class TestLockDaoImpl implements TestLockDao{

	@Override
	public int testLock(TestLock testLock) {
		return 0;
	}

	@Override
	public int selectLockVersionById(int id) {
		return 0;
	}

	@Override
	public int updateLock(TestLock testLock) {
		return 0;
	}

	@Override
	public int updateVersionAutoIncreaseOneById(int id) {
		return 0;
	}

	@Override
	public List<TestLock> selectAllLock() {
		return null;
	}
}
