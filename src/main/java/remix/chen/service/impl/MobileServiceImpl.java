package remix.chen.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import remix.chen.dao.MobileDao;
import remix.chen.dao.PersonDao;
import remix.chen.domain.Mobile;
import remix.chen.domain.Person;
import remix.chen.service.MobileService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Service
public class MobileServiceImpl implements MobileService {

	@Resource(name = "mobileDaoImpl")
	public MobileDao mobileDao;
	
	@Resource
	public PersonDao personDao;
	
	//insert
	public int insertMobiles(List<Mobile> mobiles) {
		int insertNum = mobileDao.insertMobiles(mobiles);
		return insertNum;
	}

	public int insertMobile(Mobile mobile) {
		int result = mobileDao.insertMobile(mobile);
		return result;
	}
	
	public void insertMobileRelate(Mobile mobile) {
		personDao.insertPerson(mobile.getPerson());
		mobileDao.insertMobile(mobile);
	}

	public void insertMobilesRelate(List<Mobile> mobiles) {
		//遍历循环去合并每个mobile里面相同的person数据。注意List.contains方法,对象的地址相同才返回为true。如果new了两个对象，属性相同。判断还是返回false
		List<Person> personsMerged = new ArrayList();
		
		for(Mobile mobile: mobiles){
			if(mobile.getPerson() != null)
				if(!personsMerged.contains(mobile.getPerson())){
					personsMerged.add(mobile.getPerson());
				}
			else
				System.out.println("mobile.getPerson = null");;
		}
		System.out.println("mobilesMerged:"+personsMerged);

		//插入persons
		if(personsMerged!=null)
			personDao.insertPersons(personsMerged);
		else
			System.out.println("personsMerged is null");
		
		//插入mobiles
		mobileDao.insertMobiles(mobiles);
	}

	//select
	public List<Mobile> selectAllMobileNR() {
		List<Mobile> mobiles = mobileDao.selectAllMobileNR();
		return mobiles;
	}

	//update
	public int updateMobile(Mobile mobile) {
		return mobileDao.updateMobile(mobile);
	}

	public int updateMobiles(List<Mobile> mobiles) {
		return mobileDao.updateMobiles(mobiles);
	}

}
