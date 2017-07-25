package remix.chen.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import remix.chen.domain.Person;

@Repository
public interface PersonService {
	
	public void insertPerson(Person person);	
	public void insertPersonRelate(Person person);
	public void insertPersons(List<Person> persons);
	public void insertPersonsRelate(List<Person> persons);
	
	public List<Person> selectAllPersonNR();
	public List<Person> selectPersonByIdAndName(int id,String name);
	public List<Person> selectPersonByIdAndName2(Map paramMap);
	public List<Person> selectPersonByIdAndName3(@Param("id")int id,@Param("name")String name);
	
	public int updatePerson(Person person);
	public int updatePersons(List<Person> persons);

}
