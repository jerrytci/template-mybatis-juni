package remix.chen.dao.impl;

import org.springframework.stereotype.Repository;
import remix.chen.dao.PersonDao;
import remix.chen.domain.Person;

import java.util.List;
import java.util.Map;

@Repository
public class PersonDaoImpl implements PersonDao{

	@Override
	public void deletePersonById(int deleteId) {

	}

	@Override
	public void deletePersonByIds(List<Integer> ids) {

	}

	@Override
	public void insertPerson(Person person) {

	}

	@Override
	public void insertPersons(List<Person> persons) {

	}

	@Override
	public List<Person> selectAllPersonNR() {
		return null;
	}

	@Override
	public Person selectPersonById(int id) {
		return null;
	}

	@Override
	public Person selectPersonByIdNR(int id) {
		return null;
	}

	@Override
	public List<Person> selectPersonByIds(List<Integer> ids) {
		return null;
	}

	@Override
	public List<Person> selectPersonByIdsNR(List<Integer> ids) {
		return null;
	}

	@Override
	public List<Person> selectPersonByIdAndName(int id, String name) {
		return null;
	}

	@Override
	public List<Person> selectPersonByIdAndName2(Map paramMap) {
		return null;
	}

	@Override
	public List<Person> selectPersonByIdAndName3(int id, String name) {
		return null;
	}

	@Override
	public int updatePerson(Person person) {
		return 0;
	}

	@Override
	public int updatePersons(List<Person> persons) {
		return 0;
	}
}
