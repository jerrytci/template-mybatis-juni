package remix.chen.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;
import remix.chen.domain.Person;

@Repository
public interface PersonDao {

	public void deletePersonById(int deleteId);
	public void deletePersonByIds(List<Integer> ids);

	public void insertPerson(Person person);
	public void insertPersons(List<Person> persons);

	public List<Person> selectAllPersonNR();
	public Person selectPersonById(int id);
	//1对多的1那边无法进行关联查询
//	public Person selectPersonByIdNQ(int id);
	public Person selectPersonByIdNR(int id);
	public List<Person> selectPersonByIds(List<Integer> ids);
	//1对多的1那边无法进行关联查询
//	public List<Person> selectPersonByIdsNQ(List<Integer> ids);
	public List<Person> selectPersonByIdsNR(List<Integer> ids);
	//测试
	//1 mybatis传入多个参数的3种方法
	public List<Person> selectPersonByIdAndName(int id, String name);
	public List<Person> selectPersonByIdAndName2(Map paramMap);
	public List<Person> selectPersonByIdAndName3(@Param("id")int id,@Param("name")String name);
	//测试-end

	public int updatePerson(Person person);
	public int updatePersons(List<Person> persons);


}
