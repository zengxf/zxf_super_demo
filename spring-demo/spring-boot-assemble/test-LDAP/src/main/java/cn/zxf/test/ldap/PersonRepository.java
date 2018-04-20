package cn.zxf.test.ldap;

import javax.naming.Name;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Name> {

}
