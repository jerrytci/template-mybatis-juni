package remix.chen.dao.impl;

import org.springframework.stereotype.Repository;
import remix.chen.dao.MobileDao;
import remix.chen.domain.Mobile;

import java.util.List;

@Repository
public class MobileDaoImpl implements MobileDao {

	@Override
	public int deleteMobileById(int deleteId) {
		return 0;
	}

	@Override
	public int deleteMobileByIds(List<Integer> deleteIds) {
		return 0;
	}

	@Override
	public int insertMobile(Mobile mobile) {
		return 0;
	}

	@Override
	public int insertMobiles(List<Mobile> mobiles) {
		return 0;
	}

	@Override
	public List<Mobile> selectAllMobileNR() {
		return null;
	}

	@Override
	public Mobile selectMobileById(int id) {
		return null;
	}

	@Override
	public Mobile selectMobileByIdNestedQuery(int id) {
		return null;
	}

	@Override
	public Mobile selectMobileByIdNestedResults(int id) {
		return null;
	}

	@Override
	public List<Mobile> selectMobileByIds(List<Integer> ids) {
		return null;
	}

	@Override
	public List<Mobile> selectMobileByIdsNQ(List<Integer> ids) {
		return null;
	}

	@Override
	public List<Mobile> selectMobileByIdsNR(List<Integer> ids) {
		return null;
	}

	@Override
	public int updateMobile(Mobile mobile) {
		return 0;
	}

	@Override
	public int updateMobiles(List<Mobile> mobiles) {
		return 0;
	}

	@Override
	public void printTest() {
		System.out.println(">>>MobileDaoImpl");
	}
}
