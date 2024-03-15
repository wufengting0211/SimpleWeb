/**
 * 
 */
package com.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.service.ShowLogService;
import com.utils.Constants;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年7月4日
 */
@Service
public class ShowLogServiceImpl implements ShowLogService{
	
	private File LogFile = null;

	/**
	 * @desc : TODO
	 * @date : 2017年7月4日
	 */
	@Override
	public Map<String, Object> getLogInfo(long preSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		StringBuilder builder = new StringBuilder();
		RandomAccessFile randomFile = null;
		try {
			LogFile = new File(Constants.LOGFILE);
			randomFile = new RandomAccessFile(LogFile,"r");
			randomFile.seek(preSize);
			
			String temp = "";
			int lines = 0;
			while((temp = randomFile.readLine()) != null){
				temp = new String(temp.getBytes("8859_1"), "utf-8");
				builder.append(temp);
				builder.append("\n");
				if(lines++ > 10){
					break;
				}
			}
			preSize = randomFile.getFilePointer();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(randomFile != null){
				try {
					randomFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		map.put("result", builder.toString());
		map.put("newSize", preSize);
		return map;
	}

}
