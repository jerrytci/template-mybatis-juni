package remix.chen.dao.impl;

import org.springframework.stereotype.Repository;
import remix.chen.dao.GoodDao;
import remix.chen.domain.Good;

import java.util.List;

@Repository
public class GoodDaoImpl implements GoodDao{

	@Override
	public void deleteGoodById(int deleteId) {

	}

	@Override
	public void deleteGoodByIds(List<Integer> ids) {

	}

	@Override
	public void insertGood(Good Good) {

	}

	@Override
	public void insertGoods(List<Good> Goods) {

	}

	@Override
	public Good selectGoodById(int id) {
		return null;
	}

	@Override
	public Good selectGoodByIdNQ(int id) {
		return null;
	}

	@Override
	public List<Good> selectGoodByIds(List<Integer> ids) {
		return null;
	}

	@Override
	public List<Good> selectGoodByIdsNQ(List<Integer> ids) {
		return null;
	}

	@Override
	public int updateGood(Good Good) {
		return 0;
	}

	@Override
	public int updateGoods(List<Good> Goods) {
		return 0;
	}
}
