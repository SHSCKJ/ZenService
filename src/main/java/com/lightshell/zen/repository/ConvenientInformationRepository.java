package com.lightshell.zen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lightshell.zen.entity.ConvenientInformation;

/**
 * @author kevindong
 */
public interface ConvenientInformationRepository
    extends JpaRepository<ConvenientInformation, Integer>, JpaSpecificationExecutor<ConvenientInformation> {

    ConvenientInformation findByUIDEquals(String uid);

}
