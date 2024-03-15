/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.dao.MongoDao;
import com.github.pagehelper.StringUtil;
import com.model.Spider;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年11月17日
 */
@Repository
public class MongoDaoImpl implements MongoDao{
	
	@Autowired
	private MongoOperations mongoTemplate;
	/**
	 * @desc : TODO
	 * @date : 2017年11月17日
	 */
	@Override
	public List<Spider> search(Spider object, long skip, Integer limit) {
		// TODO Auto-generated method stub
		Query query = defineQuery(object);
		query.skip(skip);
		if(limit != null) {
			query.limit(limit);
		}
		return this.mongoTemplate.find(query, Spider.class);
	}

	/**
	 * @desc : TODO
	 * @date : 2017年11月17日
	 */
	@Override
	public void findAndModify(Spider search, Spider update) {
		// TODO Auto-generated method stub
		Query query = defineQuery(search);
		Update up = Update.update("isNew", update.getIsNew())
				.set("isScan", update.getIsScan())
				.set("isValid", update.getIsValid());
		this.mongoTemplate.findAndModify(query, up, Spider.class);
	}

	/**
	 * @desc : TODO
	 * @date : 2017年11月17日
	 */
	@Override
	public void insert(List<Spider> object) {
		// TODO Auto-generated method stub
		this.mongoTemplate.insert(object);
	}

	/**
	 * @desc : TODO
	 * @date : 2017年11月17日
	 */
	@Override
	public void remove(Spider object) {
		// TODO Auto-generated method stub
		this.mongoTemplate.remove(search(object, 0 ,null));
	}
	
	public void setMongoTemplate(MongoOperations mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
	}
	
	private Query defineQuery(Spider object) {
		if(object == null) {
			object = new Spider();
		}
		Query query = new Query();
		if(!StringUtil.isEmpty(object.get_id())) {
			Criteria criteria = Criteria.where("_id").is(object.get_id());
			query.addCriteria(criteria);
		}
		
		if(!StringUtil.isEmpty(object.getColumnUrl())) {
			Criteria criteria = Criteria.where("columnUrl").is(object.getColumnUrl());
			query.addCriteria(criteria);
		}
		
		if(!StringUtil.isEmpty(object.getFileUrl())) {
			Criteria criteria = Criteria.where("fileUrl").is(object.getFileUrl());
			query.addCriteria(criteria);
		}
		
		if(object.getIsScan() != null) {
			Criteria criteria = Criteria.where("isScan").is(object.getIsScan());
			query.addCriteria(criteria);
		}
		
		if(object.getIsValid() != null) {
			Criteria criteria = Criteria.where("isValid").is(object.getIsValid());
			query.addCriteria(criteria);
		}
		
		if(object.getIsNew() != null) {
			Criteria criteria = Criteria.where("isNew").is(object.getIsNew());
			query.addCriteria(criteria);
		}
		return query;
	}

}
