/**
 * 
 */
package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MongoDao;
import com.github.pagehelper.StringUtil;
import com.model.Spider;
import com.service.MongoService;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年11月21日
 */
@Service
public class MongoServiceImpl implements MongoService{
	
	@Autowired
	private MongoDao mongoDaoImpl;

	/**
	 * @desc : TODO
	 * @date : 2017年11月21日
	 */
	@Override
	public List<Spider> search(Spider object) {
		// TODO Auto-generated method stub
		return mongoDaoImpl.search(object, 0, null);
	}

	/**
	 * @desc : TODO
	 * @date : 2017年11月24日
	 */
	@Override
	public void insert(List<Spider> list) {
		// TODO Auto-generated method stub
		mongoDaoImpl.insert(list);
	}

	/**
	 * @desc : TODO
	 * @date : 2017年11月24日
	 */
	@Override
	public void update(Spider old, Spider fresh) {
		// TODO Auto-generated method stub
		if(StringUtil.isEmpty(old.get_id())) {
			return;
		}
		mongoDaoImpl.findAndModify(old, fresh);
	}

	/**
	 * @desc : TODO
	 * @date : 2017年11月24日
	 */
	@Override
	public Spider find(Spider spider) {
		// TODO Auto-generated method stub
		List<Spider> list = this.search(spider);
		
		return (list != null && list.size() > 0) ? list.get(0) : new Spider();
	}

	/**
	 * 
	 */
	public MongoDao getMongoDaoImpl() {
		return mongoDaoImpl;
	}

}
