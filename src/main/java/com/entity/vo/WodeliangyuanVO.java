package com.entity.vo;

import com.entity.WodeliangyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 我的良缘
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
public class WodeliangyuanVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 年龄
	 */
	
	private String nianling;
		
	/**
	 * 学历
	 */
	
	private String xueli;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 座右铭
	 */
	
	private String zuoyouming;
		
	/**
	 * 星座
	 */
	
	private String xingzuo;
		
	/**
	 * 喜好
	 */
	
	private String xihao;
		
	/**
	 * 地区
	 */
	
	private String diqu;
		
	/**
	 * 是否处于疫区
	 */
	
	private String shifouchuyuyiqu;
		
	/**
	 * 是否购房
	 */
	
	private String shifougoufang;
		
	/**
	 * 婚姻状况
	 */
	
	private String hunyinzhuangkuang;
		
	/**
	 * 家庭情况
	 */
	
	private String jiatingqingkuang;
		
	/**
	 * 对他的期待
	 */
	
	private String duitadeqidai;
		
	/**
	 * 自我介绍
	 */
	
	private String ziwojieshao;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：年龄
	 */
	 
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
				
	
	/**
	 * 设置：学历
	 */
	 
	public void setXueli(String xueli) {
		this.xueli = xueli;
	}
	
	/**
	 * 获取：学历
	 */
	public String getXueli() {
		return xueli;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：座右铭
	 */
	 
	public void setZuoyouming(String zuoyouming) {
		this.zuoyouming = zuoyouming;
	}
	
	/**
	 * 获取：座右铭
	 */
	public String getZuoyouming() {
		return zuoyouming;
	}
				
	
	/**
	 * 设置：星座
	 */
	 
	public void setXingzuo(String xingzuo) {
		this.xingzuo = xingzuo;
	}
	
	/**
	 * 获取：星座
	 */
	public String getXingzuo() {
		return xingzuo;
	}
				
	
	/**
	 * 设置：喜好
	 */
	 
	public void setXihao(String xihao) {
		this.xihao = xihao;
	}
	
	/**
	 * 获取：喜好
	 */
	public String getXihao() {
		return xihao;
	}
				
	
	/**
	 * 设置：地区
	 */
	 
	public void setDiqu(String diqu) {
		this.diqu = diqu;
	}
	
	/**
	 * 获取：地区
	 */
	public String getDiqu() {
		return diqu;
	}
				
	
	/**
	 * 设置：是否处于疫区
	 */
	 
	public void setShifouchuyuyiqu(String shifouchuyuyiqu) {
		this.shifouchuyuyiqu = shifouchuyuyiqu;
	}
	
	/**
	 * 获取：是否处于疫区
	 */
	public String getShifouchuyuyiqu() {
		return shifouchuyuyiqu;
	}
				
	
	/**
	 * 设置：是否购房
	 */
	 
	public void setShifougoufang(String shifougoufang) {
		this.shifougoufang = shifougoufang;
	}
	
	/**
	 * 获取：是否购房
	 */
	public String getShifougoufang() {
		return shifougoufang;
	}
				
	
	/**
	 * 设置：婚姻状况
	 */
	 
	public void setHunyinzhuangkuang(String hunyinzhuangkuang) {
		this.hunyinzhuangkuang = hunyinzhuangkuang;
	}
	
	/**
	 * 获取：婚姻状况
	 */
	public String getHunyinzhuangkuang() {
		return hunyinzhuangkuang;
	}
				
	
	/**
	 * 设置：家庭情况
	 */
	 
	public void setJiatingqingkuang(String jiatingqingkuang) {
		this.jiatingqingkuang = jiatingqingkuang;
	}
	
	/**
	 * 获取：家庭情况
	 */
	public String getJiatingqingkuang() {
		return jiatingqingkuang;
	}
				
	
	/**
	 * 设置：对他的期待
	 */
	 
	public void setDuitadeqidai(String duitadeqidai) {
		this.duitadeqidai = duitadeqidai;
	}
	
	/**
	 * 获取：对他的期待
	 */
	public String getDuitadeqidai() {
		return duitadeqidai;
	}
				
	
	/**
	 * 设置：自我介绍
	 */
	 
	public void setZiwojieshao(String ziwojieshao) {
		this.ziwojieshao = ziwojieshao;
	}
	
	/**
	 * 获取：自我介绍
	 */
	public String getZiwojieshao() {
		return ziwojieshao;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}
