package com.chj.service;

import com.chj.persistence.domain.ActivityInfoDomain;

public interface ActivityInfoService {

	/**
	 * 新增活动信息
	 * 
	 * @param user
	 * @return SystemUserDTE
	 */
	public ActivityInfoDomain create(ActivityInfoDomain data);

	/**
	 * 保存
	 * 
	 * @param systemMenu
	 * @return SystemMenuDTE
	 * @throws BaseException
	 */
	ActivityInfoDomain save(ActivityInfoDomain data);

	/**
	 * 删除
	 * 
	 * @param muneId
	 * @return SystemMenuDTE
	 * @throws BaseException
	 */
	void detele(int id);

}
