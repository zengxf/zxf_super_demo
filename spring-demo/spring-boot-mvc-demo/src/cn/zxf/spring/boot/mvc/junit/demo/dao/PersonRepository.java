package cn.zxf.spring.boot.mvc.junit.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.zxf.spring.boot.mvc.junit.demo.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
