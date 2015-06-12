package com.ibapp.service.impl;

import com.ibapp.domain.Register;
import com.ibapp.persistence.RegisterMapper;
import com.ibapp.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by imran on 14/04/15.
 */
@Component
@Service
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private RegisterMapper RegisterMapper;


    @Override
    public void insertRegister(Register register) throws Exception{

        RegisterMapper.insertRegister(register);

    }

    @Override
    public void updateRegister(Register register) throws Exception {

        RegisterMapper.updateRegister(register);

    }

    @Override
    public void deleteRegister(Register register) throws Exception {

        RegisterMapper.deleteRegister(register);

    }

    @Override
    public Register getRegisterById(int id) throws Exception {

        return RegisterMapper.getRegisterById(id);
    }

    @Override
    public List<Register> getAllRegister() throws Exception {
        return RegisterMapper.getAllRegister();
    }
}
