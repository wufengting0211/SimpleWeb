/**
 * 
 */
package com.dao;

import java.util.List;

import com.model.Spider;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年11月17日
 */
public interface MongoDao {
	public List<Spider> search(Spider object, long skip, Integer limit);
	public void findAndModify(Spider search, Spider update);
	public void insert(List<Spider> object);
	public void remove(Spider object);
	
}
