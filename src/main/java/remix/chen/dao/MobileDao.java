package remix.chen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import remix.chen.domain.Mobile;

@Repository
public interface MobileDao {
	
	public int deleteMobileById(int deleteId);
	public int deleteMobileByIds(List<Integer> deleteIds);
	
	public int insertMobile(Mobile mobile);
	public int insertMobiles(List<Mobile> mobiles);
	
	public List<Mobile> selectAllMobileNR();
	public Mobile selectMobileById(int id);
	public Mobile selectMobileByIdNestedQuery(int id);
	public Mobile selectMobileByIdNestedResults(int id);
	public List<Mobile> selectMobileByIds(List<Integer> ids);
	public List<Mobile> selectMobileByIdsNQ(List<Integer> ids);
	public List<Mobile> selectMobileByIdsNR(List<Integer> ids);
	
	public int updateMobile(Mobile mobile);
	public int updateMobiles(List<Mobile> mobiles);

	public void printTest();

}
