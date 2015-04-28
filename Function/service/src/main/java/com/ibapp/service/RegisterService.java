package com.ibapp.service;

import com.ibapp.domain.Register;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by imran on 14/04/15.
 */

public interface RegisterService {

    public void insertRegister (Register register) throws Exception;

    public void updateRegister(Register register) throws Exception;

    public void deleteRegister(Register register) throws Exception;

    public Register getRegisterById(int id) throws Exception;

    public List<Register> getAllRegister() throws Exception;
}
