package com.lightshell.zen.service;

import com.lightshell.zen.common.SuperService;
import com.lightshell.zen.entity.SystemUser;
import com.lightshell.zen.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kevindong
 */
@Service
public class SystemUserServiceImpl implements SuperService<SystemUser> {

    @Autowired
    SystemUserRepository systemUserRepository;

    public SystemUser findByUserid(String userid) {
        return systemUserRepository.findByUseridEquals(userid);
    }

    @Override
    public SystemUser save(SystemUser user) {
        return systemUserRepository.save(user);
    }

    @Override
    public List<SystemUser> saveAll(List<SystemUser> data) {
        return systemUserRepository.saveAll(data);
    }

}