package com.forest.api.dao;

import org.apache.ibatis.annotations.Mapper;

import com.forest.api.common.persistence.CrudDao;
import com.forest.api.entity.AppUser;

/**
 * 
 * @author forest
 *
 */
@Mapper
public interface AppUserDao extends CrudDao<AppUser>{
	/**
	 * @param user
	 * @return
	 */
	AppUser getByLoginName(AppUser user);
}
