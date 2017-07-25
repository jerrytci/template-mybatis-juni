package remix.chen.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import remix.chen.domain.Mobile;

@Repository
public interface MobileService {
	
	//insert
	public int insertMobile(Mobile mobile);
	public int insertMobiles(List<Mobile> mobiles);
	public void insertMobileRelate(Mobile mobile);
	public void insertMobilesRelate(List<Mobile> mobiles);
	
	//select
	public List<Mobile> selectAllMobileNR();
	
	//update
	public int updateMobile(Mobile mobile);
	public int updateMobiles(List<Mobile> mobiles);
}
