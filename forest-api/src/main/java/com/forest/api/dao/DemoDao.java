package com.forest.api.dao;

import org.apache.ibatis.annotations.Mapper;

import com.forest.api.common.persistence.CrudDao;
import com.forest.api.entity.Demo;

/**
 * 
 * @author forest
 *
 */
@Mapper
public interface DemoDao extends CrudDao<Demo>{

}
