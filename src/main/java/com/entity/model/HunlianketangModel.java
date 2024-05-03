package com.entity.model;

import com.entity.HunlianketangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 婚恋课堂
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
public class HunlianketangModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 内容
	 */
	
	private String neirong;
		
	/**
	 * 婚恋课堂
	 */
	
	private String hunlianketang;
		
	/**
	 * 相亲
	 */
	
	private String xiangqin;
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：内容
	 */
	 
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	
	/**
	 * 获取：内容
	 */
	public String getNeirong() {
		return neirong;
	}
				
	
	/**
	 * 设置：婚恋课堂
	 */
	 
	public void setHunlianketang(String hunlianketang) {
		this.hunlianketang = hunlianketang;
	}
	
	/**
	 * 获取：婚恋课堂
	 */
	public String getHunlianketang() {
		return hunlianketang;
	}
				
	
	/**
	 * 设置：相亲
	 */
	 
	public void setXiangqin(String xiangqin) {
		this.xiangqin = xiangqin;
	}
	
	/**
	 * 获取：相亲
	 */
	public String getXiangqin() {
		return xiangqin;
	}
			
}
