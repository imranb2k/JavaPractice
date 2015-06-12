package com.ibapp.persistence;

import com.ibapp.domain.Person;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by imranbordiwala on 18/05/2015.
 */
public interface PersonMapper extends SchemaMapper{

    //Create
    @Insert("INSERT INTO "
            + SCHEMA
            + "person(ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) "
            + "VALUES((SELECT nextval('register_schema.registerid')), #{firstName}, #{lastName}, #{email}, #{password})")
    public void insertPerson(Person person) throws Exception;

    //Read
    @Select("SELECT ID as id, FIRST_NAME as firstName, LAST_NAME as lastName, EMAIL as email, PASSWORD as password "
            + "FROM " + SCHEMA + "person WHERE id = #{id}")
    public Person getPersonById(int id) throws Exception;

    @Select("SELECT ID as id, FIRST_NAME as firstName, LAST_NAME as lastName, EMAIL as email, PASSWORD as password "
            + "FROM " + SCHEMA + "person")
    public List<Person> getAllPersons() throws Exception;

    //Update
    @Update("UPDATE "
            + SCHEMA
            + "person SET FIRST_NAME=#{firstName}, LAST_NAME=#{lastName}, EMAIL=#{email}, PASSWORD=#{password} "
            + "WHERE id=#{id}")
    public void updatePerson(Person person) throws Exception;

    //Delete
    @Delete("DELETE from " + SCHEMA + "person WHERE id = #{id}")
    public void deletePerson(int id) throws Exception;

}
