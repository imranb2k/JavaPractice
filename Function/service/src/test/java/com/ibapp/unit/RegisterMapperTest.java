package com.ibapp.unit;

import com.ibapp.domain.Register;
import com.ibapp.persistence.RegisterMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by imran on 15/04/15.
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class RegisterMapperTest {

    @Autowired
    RegisterMapper RegisterMapper;

    @Test
    public void testInsertRegister() throws Exception{

        RegisterMapper.insertRegister(getRegister());

    }

/*    public void testUpdateRegister() throws Exception{

        RegisterMapper.updateRegister(getRegister());

    }*/

/*    public void testDeleteRegister() throws Exception{

        RegisterMapper.deleteRegister(getRegister());

    }*/

/*    public void testGetRegisterById() throws Exception{

        RegisterMapper.getRegisterById(1);

    }*/

/*    public void testGetAllRegisters() throws Exception{

        RegisterMapper.getAllRegister();

    }*/

    private Register getRegister() {

        Register register = new Register();
        register.setUserName("Test Name 3");
        register.setPassword("Test Password 3");

        return register;
    }





}
