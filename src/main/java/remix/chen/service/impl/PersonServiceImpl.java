package remix.chen.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import remix.chen.dao.MobileDao;
import remix.chen.dao.PersonDao;
import remix.chen.domain.Mobile;
import remix.chen.domain.Person;
import remix.chen.service.PersonService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class PersonServiceImpl implements PersonService {

	@Resource(name = "mobileDaoImpl")
	private MobileDao mobileDao;

	@Resource
	private PersonDao personDao;

	//insert
	public void insertPerson(Person person) {
		personDao.insertPerson(person);
	}
	
	@Transactional
	public void insertPersonRelate(Person person){
		personDao.insertPerson(person);
		mobileDao.insertMobiles(person.getMobiles());
	}

	public void insertPersons(List<Person> persons) {
		personDao.insertPersons(persons);
	}
	
	//insertPersons有两种解决办法。
	//1 for循环遍历insertPerson.总的操作数据库次数为：for循环的次数 * ((insertPerson)1 + (insertMobiles)1) = 2 * Num(for).
	//2 变为insertPersons(simple)和insertMobile(simple). 其中insertMobile的时候合并每个person里面相同的mobile数据。
	@Transactional(rollbackFor=Exception.class) 
	public void insertPersonsRelate(List<Person> persons) {
		personDao.insertPersons(persons);
		
		//遍历循环去合并每个person里面相同的mobile数据。注意List.contains方法,对象的地址相同才返回为true
		List<Mobile> mobilesMerged = new ArrayList(); 
		for(Person person: persons){
			for(Mobile mobile:person.getMobiles()){
				System.out.println("before mobilesMerged:"+mobilesMerged);
				if(!mobilesMerged.contains(mobile)){
					mobilesMerged.add(mobile);
					System.out.println("1");
				}else
					System.out.println("2");
			}
		}
		System.out.println("mobilesMerged:"+mobilesMerged);
		
		if(mobilesMerged!=null)
			mobileDao.insertMobiles(mobilesMerged);
		else
			System.out.println("mobilesMerged is null");
		System.out.println(">>insertPersons() persons:"+persons);
	}
	
	
	public List<Person> selectAllPersonNR() {
		return personDao.selectAllPersonNR();
	}

	public List<Person> selectPersonByIdAndName(int id, String name) {
		return personDao.selectPersonByIdAndName(id, name);
	}

	public List<Person> selectPersonByIdAndName2(Map paramMap) {

		return personDao.selectPersonByIdAndName2(paramMap);
	}

	public List<Person> selectPersonByIdAndName3(int id, String name) {
		return personDao.selectPersonByIdAndName3(id, name);
	}

	
	//update
	public int updatePerson(Person person) {
		int i = personDao.updatePerson(person);
		return i;
	}

	public int updatePersons(List<Person> persons) {
		// TODO Auto-generated method stub
		int i = personDao.updatePersons(persons);
		return i;
	}

}
