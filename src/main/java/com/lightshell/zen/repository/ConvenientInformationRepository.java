package com.lightshell.zen.repository;

import com.lightshell.zen.entity.ConvenientInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConvenientInformationRepository extends JpaRepository<ConvenientInformation, Integer>, JpaSpecificationExecutor<ConvenientInformation> {

}
