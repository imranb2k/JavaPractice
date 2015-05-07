package com.ibapp.unit;

import com.ibapp.domain.Register;
import com.ibapp.persistence.RegisterMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by imran on 15/04/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class RegisterMapperTest {

    @Autowired
    RegisterMapper registerMapper;

    @Test
    public void testInsertRegister() throws Exception{

        registerMapper.insertRegister(getRegister());

    }

/*    public void testUpdateRegister() throws Exception{

        registerMapper.updateRegister(getRegister());

    }*/

/*    public void testDeleteRegister() throws Exception{

        registerMapper.deleteRegister(getRegister());

    }*/

/*    public void testGetRegisterById() throws Exception{

        registerMapper.getRegisterById(1);

    }*/

/*    public void testGetAllRegisters() throws Exception{

        registerMapper.getAllRegister();

    }*/

    private Register getRegister() {

        Register register = new Register();
       // register.setId(2);
        register.setUserName("Test Name 3");
        register.setPassword("Test Password 3");

        return register;
    }





}
