package remix.chen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import remix.chen.domain.Good;

@Repository
public interface GoodDao {	
	
	public void deleteGoodById(int deleteId);
	public void deleteGoodByIds(List<Integer> ids);
	
	public void insertGood(Good Good);
	public void insertGoods(List<Good> Goods);
	
//	public List<Good> selectAllGoodNR();
	public Good selectGoodById(int id);
	public Good selectGoodByIdNQ(int id);
//	public Good selectGoodByIdNR(int id);
	public List<Good> selectGoodByIds(List<Integer> ids);
	public List<Good> selectGoodByIdsNQ(List<Integer> ids);
//	public List<Good> selectGoodByIdsNR(List<Integer> ids);

	public int updateGood(Good Good);
	public int updateGoods(List<Good> Goods);

}
