/**
 * 
 */
package com.model;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年11月17日
 */
public class Spider extends BaseEntiy{

	private static final long serialVersionUID = 1L;
	
	private String _id;
	

	private String columnUrl;
	

	private String fileUrl;
	

	private String fileName;
	

	private String saveTime;
	
	private Integer isScan = 1;
	private Integer isNew = 1;
	private Integer isChild;
	private Integer isValid = 1;
	

	@Override
	public String toString() {
		return this._id  + ":" + this.fileUrl;
	}


	/**
	 * 
	 */
	public String get_id() {
		return _id;
	}


	/**
	 * 
	 */
	public void set_id(String _id) {
		this._id = _id;
	}


	/**
	 * 
	 */
	public String getFileUrl() {
		return fileUrl;
	}


	/**
	 * 
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}


	/**
	 * 
	 */
	public String getFileName() {
		return fileName;
	}


	/**
	 * 
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/**
	 * 
	 */
	public String getSaveTime() {
		return saveTime;
	}


	/**
	 * 
	 */
	public void setSaveTime(String saveTime) {
		this.saveTime = saveTime;
	}


	/**
	 * 
	 */
	public Integer getIsScan() {
		return isScan;
	}


	/**
	 * 
	 */
	public void setIsScan(Integer isScan) {
		this.isScan = isScan;
	}


	/**
	 * 
	 */
	public Integer getIsNew() {
		return isNew;
	}


	/**
	 * 
	 */
	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}


	/**
	 * 
	 */
	public Integer getIsChild() {
		return isChild;
	}


	/**
	 * 
	 */
	public void setIsChild(Integer isChild) {
		this.isChild = isChild;
	}


	/**
	 * 
	 */
	public Integer getIsValid() {
		return isValid;
	}


	/**
	 * 
	 */
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}


	/**
	 * 
	 */
	public String getColumnUrl() {
		return columnUrl;
	}


	/**
	 * 
	 */
	public void setColumnUrl(String columnUrl) {
		this.columnUrl = columnUrl;
	}

}
