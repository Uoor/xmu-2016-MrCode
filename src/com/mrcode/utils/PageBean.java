package com.mrcode.utils;
/**
 * 
 * @author 羽中
 *
 */
public class PageBean {
	//共五个变量
	private int pageSize = 10;	//每页显示的大小
	private int currentPage = 1;	//当前页
	
	private int dataSize;	//总数据量
	
	private int pageNum = 0;	//总页数
	
	private int beginIndex;	//起始页
	private int endIndex;	//终止页
	private int offSet;		//分页显示时的起始游标
	
	
	/***********************constructor***********************/
	public PageBean(){
		
	}
	public PageBean(int pageSize){
		this.pageSize = pageSize;
	}
	public PageBean(int currentPage,int pageSize,int dataSize){
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.dataSize = dataSize;
		
		pageNum = (dataSize + pageSize -1)/pageSize;	//计算总页数
		offSet = pageSize*(currentPage - 1);
		
		
		if(pageNum < 5){				/*beginIndex,endIndex*/
			//如果页数不足5
			beginIndex = 1;
			endIndex = pageNum;
		}else{
			//如果页数大于5
				beginIndex = currentPage - 2;
				endIndex = currentPage + 2;
				if(beginIndex < 1){
					beginIndex = 1;
					endIndex = 5;
				}else if(endIndex > pageNum){
					endIndex = pageNum;
					beginIndex = endIndex - 5 + 1;
				}
		}
	}
	/***********************method***********************/
	/**
	 * 计算总页数
	 * @param dataSize
	 * @param pageSize
	 * @return
	 */
	public int countPageNum(final int dataSize,final int pageSize){
		return (dataSize + pageSize -1)/pageSize;
	}
	/**
	 * 计算总页数
	 * @return
	 */
	public int countPageNum(){
		return countPageNum(dataSize,pageNum);
	}
	/**
	 * 计算分页的起始游标
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	public int countOffSet(final int pageSize,final int currentPage){
		return pageSize*(currentPage - 1);
	}
	/***********************getter and setter***********************/
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public int countOffSet(){
		return countOffSet(pageSize, currentPage);
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getDataSize() {
		return dataSize;
	}
	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
		//
		pageNum = (dataSize + pageSize -1)/pageSize;	//计算总页数
		offSet = pageSize*(currentPage - 1);
		
		
		if(pageNum < 5){				/*beginIndex,endIndex*/
			//如果页数不足5
			beginIndex = 1;
			endIndex = pageNum;
		}else{
			//如果页数大于5
				beginIndex = currentPage - 2;
				endIndex = currentPage + 2;
				if(beginIndex < 1){
					beginIndex = 1;
					endIndex = 5;
				}else if(endIndex > pageNum){
					endIndex = pageNum;
					beginIndex = endIndex - 5 + 1;
				}
		}
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getOffSet() {
		return offSet;
	}
	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}
}
