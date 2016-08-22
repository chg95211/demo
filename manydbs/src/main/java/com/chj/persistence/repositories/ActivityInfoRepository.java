package com.chj.persistence.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chj.persistence.domain.ActivityInfoDomain;

@Repository
public interface ActivityInfoRepository extends JpaRepository<ActivityInfoDomain, Serializable> {

}
