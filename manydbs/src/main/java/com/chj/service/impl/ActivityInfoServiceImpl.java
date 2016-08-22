package com.chj.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chj.config.dbhandler.DataSource;
import com.chj.persistence.dao.ActivityInfoDao;
import com.chj.persistence.domain.ActivityInfoDomain;
import com.chj.persistence.repositories.ActivityInfoRepository;
import com.chj.service.ActivityInfoService;

@Service
@DataSource("db1")
public class ActivityInfoServiceImpl implements ActivityInfoService {

	final static Logger logger = LoggerFactory.getLogger(ActivityInfoServiceImpl.class);

	@Autowired
	ActivityInfoRepository activityInfoRepository;

	@Autowired
	ActivityInfoDao activityInfoDao;

	@Override
	public ActivityInfoDomain create(ActivityInfoDomain data) {
		return activityInfoRepository.save(data);
	}

	@Override
	public ActivityInfoDomain save(ActivityInfoDomain data) {
		return activityInfoRepository.save(data);
	}

	@Override
	public void detele(int id) {
		activityInfoRepository.delete(id);
	}

}
