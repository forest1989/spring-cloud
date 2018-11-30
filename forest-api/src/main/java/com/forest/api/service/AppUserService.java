package com.forest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.api.common.service.CrudService;
import com.forest.api.dao.AppUserDao;
import com.forest.api.entity.AppUser;

@Service
@Transactional(readOnly = true)
public class AppUserService extends CrudService<AppUserDao, AppUser>{
	
	@Autowired
    private AppUserDao appUserDao;
	/**
	 * @param user登录
	 * @return
	 */
	public AppUser login(AppUser user) {
		return appUserDao.getByLoginName(user);
	}
}
