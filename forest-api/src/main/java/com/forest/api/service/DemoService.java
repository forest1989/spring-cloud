package com.forest.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.api.common.service.CrudService;
import com.forest.api.dao.DemoDao;
import com.forest.api.entity.Demo;

@Service
@Transactional(readOnly = true)
public class DemoService extends CrudService<DemoDao, Demo>{

	
}
