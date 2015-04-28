package com.ibapp.persistence;

import com.ibapp.domain.Register;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.DELETE;
import java.util.List;

/**
 * Created by imran on 14/04/15.
 */


public interface RegisterMapper extends SchemaMapper {

    @Insert("INSERT INTO " + SCHEMA + "register(id, user_name, password) VALUES((SELECT nextval('register_schema.registerid')), #{userName}, #{password})")
    public void insertRegister(Register register) throws Exception;

    @Update("UPDATE " + SCHEMA + "register SET user_name=#{userName}, password=#{password} WHERE id=#{id}")
    @Transactional
    public void updateRegister(Register register) throws Exception;

    @Delete("DELETE from " + SCHEMA + "register WHERE id = #{id}")
    @Transactional
    public void deleteRegister(Register register) throws Exception;

    @Select("SELECT id as id, user_name as userName, password as password FROM " + SCHEMA + "register WHERE id = #{id}")
    public Register getRegisterById(int id) throws Exception;

    @Select("SELECT id as id, user_name as userName, password as password FROM " + SCHEMA + "register")
    public List<Register> getAllRegister() throws Exception;

}
