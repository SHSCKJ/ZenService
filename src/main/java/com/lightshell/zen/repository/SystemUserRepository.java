package com.lightshell.zen.repository;

import com.lightshell.zen.entity.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserRepository extends JpaRepository<SystemUser, Integer> {

    public SystemUser findByUseridEquals(String userid);

}