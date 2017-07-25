package remix.chen.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import remix.chen.dao.MobileDao;
import remix.chen.dao.impl.MobileDaoImpl;
import remix.chen.domain.Mobile;
import remix.chen.domain.Person;
import remix.chen.service.MobileService;
import remix.chen.service.impl.MobileServiceImpl;
import remix.chen.test.SpringTestCase;

//error: 懒加载异常好像不成功
public class MobileTest extends SpringTestCase{

	@Resource
	private MobileService mobileServiceImpl;
	
	@Resource
	private MobileDao mobileDaoImpl;
	
	//del insert select update
	
	//del
	//state: suc
	@Test
	public void deleteMobileById(){
		int deleteId = 1;
		int delNum = mobileDaoImpl.deleteMobileById(deleteId);
		System.out.println("delNum:"+delNum);
	}
	
	//state: suc
	@Test
	public void deleteMobileByIds(){
		List<Integer> deleteIds = new ArrayList<Integer>();
		deleteIds.add(1);
		deleteIds.add(2);
		
		int delNum = mobileDaoImpl.deleteMobileByIds(deleteIds);
		System.out.println("delNum:"+delNum);
	}
	
	//insert
	//state: suc
	//return的是执行sql语句更改成功的条数。
	@Test
	public void insertMobile() {
		Mobile mobile = new Mobile(1, 1101, "诺基亚1101");
		//构建person对象，设置id属性就可以了。
		Person person = new Person(12);
		mobile.setPerson(person);
		
		int result = mobileServiceImpl.insertMobile(mobile);
		System.out.println(">>insertMobile() result:" + result);
	}
	
	//state: suc
	//xxxRelate：关联插入
	@Test
	public void insertMobileRelate() {
		Mobile mobile = new Mobile(1, 1101, "诺基亚1101");
		Person person = new Person(9,"哈哈");
		//insert Mobile，所以mobile需要setPerson，而person不用setMobiles
		mobile.setPerson(person);
		
		mobileServiceImpl.insertMobileRelate(mobile);
	}
	
	//state: suc
	@Test
	public void insertMobiles() {
		Person person = new Person(10,"马化腾");
		
		Mobile mobile2 = new Mobile(11, 1102, "iphone 8");
		mobile2.setPerson(person);
		
		Mobile mobile3 = new Mobile(12, 1103, "iphone 8 pro");
		mobile3.setPerson(person);
		
		List<Mobile> mobiles = new ArrayList<Mobile>();
		mobiles.add(mobile2);
		mobiles.add(mobile3);
		
		int insertNum = mobileServiceImpl.insertMobiles(mobiles);
		System.out.println("insertMobiles() insertNum:" + insertNum);
	}
	
	//state: suc
	@Test
	public void insertMobilesRelate() {
		//构建第一个person-mobile
		Person person = new Person(50,"王卫");
		
		Mobile mobile = new Mobile(50, 1102, "诺基亚1102");
		List<Mobile> mobiles = new ArrayList<Mobile>();
		mobile.setPerson(person);
		mobiles.add(mobile);
		
		//插入mobile不需要person.setMobiles.如果设置了，需要修改person或则mobile的toString方法。不然会报错java.lang.StackOverflowError.参考https://my.oschina.net/ChiLin/blog/711361。
//		person.setMobiles(mobiles);
		
		//构建第二个person-mobile
		Person person3 = new Person(51,"王建林");
		
		Mobile mobile3 = new Mobile(51, 1103, "诺基亚1103");
		List<Mobile> mobiles3 = new ArrayList<Mobile>();
		mobile3.setPerson(person3);
		mobiles3.add(mobile3);
		
//		person3.setMobiles(mobiles3);
		
		//设置，插入
		List<Mobile> mobilesInsert = new ArrayList<Mobile>();
		mobilesInsert.add(mobile);
		mobilesInsert.add(mobile3);
		
		mobileServiceImpl.insertMobilesRelate(mobilesInsert);
	}
	
	//select
	//state: suc
	@Test
	public void selectAllMobileNR() {
		List<Mobile> mobiles = mobileServiceImpl.selectAllMobileNR();
		System.out.println("mobiles:" + mobiles);
	}
	
	//state: suc 
	//只查询出Mobile的基本数据类型属性。
	@Test
	public void selectMobileById(){
		int id = 12;
		Mobile mobile = mobileDaoImpl.selectMobileById(id);
		System.out.println("mobile:" + mobile);
	}
	
	//state: suc
	//查询方式：嵌套查询；配合懒加载性能较好，但是存在1+n问题
	@Test
	public void selectMobileByIdNestedQuery(){
		int id = 12;
		Mobile mobile = mobileDaoImpl.selectMobileByIdNestedQuery(id);
		System.out.println("mobile:" + mobile);
	}
	
	//state: suc
	//查询方式：嵌套结果；关联多个表查询,性能较慢.
	@Test
	public void selectMobileByIdNestedResults(){
		int id = 12;
		Mobile mobile = mobileDaoImpl.selectMobileByIdNestedResults(id);
		System.out.println("mobile:" + mobile);
	}
	
	//state: suc
	@Test
	public void selectMobileByIds(){
		List<Integer> ids = new ArrayList();
		ids.add(30);
		ids.add(31);
		
		List<Mobile> mobiles = mobileDaoImpl.selectMobileByIds(ids);
		System.out.println("mobiles:" + mobiles);
	}
	
	//state: suc
	//R: Relate(嵌套查询)
	@Test
	public void selectMobileByIdsNQ(){
		List<Integer> ids = new ArrayList();
		ids.add(30);
		ids.add(32);
		
		List<Mobile> mobiles = mobileDaoImpl.selectMobileByIdsNQ(ids);
		System.out.println("mobiles:" + mobiles);
	}
	
	//state: suc
	//NR: NestedResults(嵌套结果)
	@Test
	public void selectMobileByIdsNR(){
		List<Integer> ids = new ArrayList();
		ids.add(30);
		ids.add(32);
		
		List<Mobile> mobiles = mobileDaoImpl.selectMobileByIdsNR(ids);
		System.out.println("mobiles:" + mobiles);
	}
	
	//update
	//state: suc
	//遇过的问题：update失败的原因是dao方法定义时里面漏写参数。
	@Test
	public void updateMobile(){
		Mobile mobile = new Mobile(1, 10110, "iphone pro2");
		Person person = new Person(7);
		mobile.setPerson(person);
		
		int result = mobileServiceImpl.updateMobile(mobile);
		System.out.println(">>updateMobile() result:" + result);
	}
	
	//state: suc
	@Test
	public void updateMobiles(){
		
		Person person = new Person(7);
		
		Mobile mobile = new Mobile(1, 10110, "iphone pro2");
		mobile.setPerson(person);
		Mobile mobile2 = new Mobile(2, 10110, "iphone pro2");
		mobile2.setPerson(person);
		
		List<Mobile> mobiles = new ArrayList<Mobile>();
		mobiles.add(mobile);
		mobiles.add(mobile2);
		
		int result = mobileServiceImpl.updateMobiles(mobiles);
		System.out.println(">>updateMobile() result:" + result);
	}
}

