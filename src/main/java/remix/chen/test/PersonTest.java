package remix.chen.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import remix.chen.dao.PersonDao;
import remix.chen.domain.Mobile;
import remix.chen.domain.Person;
import remix.chen.service.PersonService;
import remix.chen.test.SpringTestCase;

public class PersonTest extends SpringTestCase {
	//直接调用Dao里面的方法，偷懒就不写service和serviceImpl，反正里面就是一个方法体，没有逻辑代码
	@Autowired
	private PersonService personServiceImpl;
	/* 因为xxxServiceImpl有@service注解,会报类型错误，所以要调用service对象
	 * private PersonServiceImpl personServiceImpl;
	 * log
	 * org.springframework.beans.factory.BeanCreationException:
	 * Error creating bean with name 'remix.chen.test.PersonTest':
	 * Injection of resource dependencies failed; 
	 * nested exception is org.springframework.beans.factory.BeanNotOfRequiredTypeException: 
	 * Bean named 'personServiceImpl' is expected to be of type 'remix.chen.service.impl.PersonServiceImpl' but was actually of type 'com.sun.proxy.$Proxy26'*/
	
	@Autowired
	private PersonDao personDaoImpl;
	
//	Logger logger = Logger.getLogger(PersonTest.class);
	
	//del insert select update
	

	//因为Mobile table的外键删除设置为cascade。所以删除person时不用关联去删除mobile table的数据
	//state: suc
	@Test
	public void deletePersonById(){
		int deleteId = 1;
		personDaoImpl.deletePersonById(deleteId);
	}
	
	//state: suc
	@Test
	public void deletePersonByIds(){
		List<Integer> ids = new ArrayList();
		ids.add(1);
		ids.add(2);
		
		personDaoImpl.deletePersonByIds(ids);
	}
	
	//insert
	//state: suc
	@Test
	public void insertPerson(){	
		Person person = new Person(1,"雷军");	
		
		personServiceImpl.insertPerson(person);
		System.out.println("person:" + person);
	}
	
	//state: suc
	//测试前需要修改toString方法
	@Test
	public void insertPersonRelate(){	
		Person person = new Person(3,"雷军");	
		
		Mobile mobile = new Mobile(6, 1312, "m6s");
		//防止插入后mobile table的person_id数据为null(mobile的person属性对应着mobile table的person_id).
		mobile.setPerson(person);
		
		List<Mobile> mobiles = new ArrayList<Mobile>();
		mobiles.add(mobile);
		
		person.setMobiles(mobiles);
		
		personServiceImpl.insertPersonRelate(person);
		System.out.println("person:" + person);
	}
	
	//state: suc
	@Test
	public void insertPersons() {
		
		Person person = new Person(36,"雷军");	
		Person person2 = new Person(37,"雷军小弟");	
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(person);
		persons.add(person2);
		
		personServiceImpl.insertPersons(persons);
		System.out.println("persons:" + persons);
	} 

	//state: suc
	@Test
	public void insertPersonsRelate() {
		//构建第一个关联的Mobile-person
		Person person = new Person(30,"雷军");	
		
		Mobile mobile = new Mobile(30, 1312, "m6s");
		mobile.setPerson(person);
		Mobile mobile2 = new Mobile(31, 1312, "m6s");
		mobile2.setPerson(person);
		
		List<Mobile> mobiles = new ArrayList<Mobile>();
		mobiles.add(mobile);
		mobiles.add(mobile2);
		
		person.setMobiles(mobiles);
		
		//构建第二个关联的Mobile-person
		Person person2 = new Person(31,"雷军");	
		
		Mobile mobile3 = new Mobile(32, 1312, "m6s");
		mobile3.setPerson(person2);
		mobile2.setPerson(person2);
		
		List<Mobile> mobiles2 = new ArrayList<Mobile>();
		mobiles2.add(mobile2);
		mobiles2.add(mobile3);
		
		person2.setMobiles(mobiles2);
		
		//设置,插入
		List<Person> persons = new ArrayList<Person>();
		persons.add(person);
		persons.add(person2);
		
		personServiceImpl.insertPersonsRelate(persons);
		System.out.println("persons:" + persons);
	} 
	
	
	//select
	//state suc
	@Test
	public void selectAllPersonNR() {
		List<Person> persons = personServiceImpl.selectAllPersonNR();
		System.out.println("persons:" + persons);
	}
	
	//state: suc
	@Test
	public void selectPersonById() {
		int id = 3; 
		Person person = personDaoImpl.selectPersonById(id);
		System.out.println("person:" + person);
	}
	
	//state: suc
	@Test
	public void selectPersonByIdNR() {
		int id = 3; 
		Person person = personDaoImpl.selectPersonByIdNR(id);
		System.out.println("person:" + person);
	}
	
	@Test
	public void selectPersonByIdNQ() {
		//1对多的1那边无法进行关联查询
/*		int id = 3; 
		Person person = personDao.selectPersonByIdNQ(id);
		System.out.println("person:" + person);*/
	}

	//state: suc
	@Test
	public void selectPersonByIds() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		
		List<Person> persons = personDaoImpl.selectPersonByIds(ids);
		System.out.println("persons:" + persons);
	}
	
	@Test
	public void selectPersonByIdsNR() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(30);
		ids.add(32);
		
		List<Person> persons = personDaoImpl.selectPersonByIdsNR(ids);
		System.out.println("persons:" + persons);
	}
	
	@Test
	public void selectPersonByIdsNQ() {
/*		List<Integer> ids = new ArrayList<Integer>();
		ids.add(30);
		ids.add(32);
		
		List<Person> persons = personDao.selectPersonByIdsNQ(ids);
		System.out.println("persons:" + persons);*/
	}
	
	/* 测试 */
	//	1 测试mybatis传多个参数 
	// 1 第一种
	//state: suc
	@Test
	public void selectPersonByIdAndName() {
		int id = 1;
		String name = "李彦宏";
		List<Person> persons = personServiceImpl.selectPersonByIdAndName(id, name);
		System.out.println("selectPersonByIdAndName():" + persons);
	}

	// 2 采用Map传多参数
	//state: suc
	@Test
	public void selectPersonByIdAndName2() {
		Map paramMap=new HashMap();
		paramMap.put("id", 1);
		paramMap.put("name", "李彦宏");
		List<Person> persons = personServiceImpl.selectPersonByIdAndName2(paramMap);
		System.out.println("selectPersonByIdAndName2():" + persons);
	}
	
	// 3 用mybatis的标签 @Param
	//state: suc
	@Test
	public void selectPersonByIdAndName3() {
		int id = 111;
		String name = "李彦宏";
		List<Person> persons = personServiceImpl.selectPersonByIdAndName3(id, name);
		System.out.println("selectPersonByIdAndName3():" + persons);
	}
	/* 测试-end */
	
	
	//update
	//state: suc
	@Test
	public void updatePerson(){
		Person person = new Person(7,"雷军o");	
		int i = personServiceImpl.updatePerson(person);
		//通过返回的执行条数判断是否成功
		System.out.println("result:"+i);
	}
	
	//state: suc
	@Test
	public void updatePersons(){

		Person person = new Person(7,"雷军oa");
		Person person2 = new Person(11,"马云oa");
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(person);
		persons.add(person2);
		
		personServiceImpl.updatePersons(persons);
		
	}
}
