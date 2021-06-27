package com.lightshell.zen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lightshell.zen.entity.SystemUser;

/**
 * @author kevindong
 */
public interface SystemUserRepository extends JpaRepository<SystemUser, Integer>, JpaSpecificationExecutor<SystemUser> {

    SystemUser findByUseridEquals(String userid);

}
