package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 电影信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
@TableName("dianyingxinxi")
public class DianyingxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DianyingxinxiEntity() {
		
	}
	
	public DianyingxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 电影编号
	 */
					
	private String dianyingbianhao;
	
	/**
	 * 电影名称
	 */
					
	private String dianyingmingcheng;
	
	/**
	 * 电影分类
	 */
					
	private String dianyingfenlei;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 导演
	 */
					
	private String daoyan;
	
	/**
	 * 票价
	 */
					
	private Integer piaojia;
	
	/**
	 * 主演
	 */
					
	private String zhuyan;
	
	/**
	 * 场次
	 */
					
	private String changci;
	
	/**
	 * 上映日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shangyingriqi;
	
	/**
	 * 语言
	 */
					
	private String yuyan;
	
	/**
	 * 当地是否有疫情
	 */
					
	private String dangdishifouyouyiqing;
	
	/**
	 * 电影简介
	 */
					
	private String dianyingjianjie;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：电影编号
	 */
	public void setDianyingbianhao(String dianyingbianhao) {
		this.dianyingbianhao = dianyingbianhao;
	}
	/**
	 * 获取：电影编号
	 */
	public String getDianyingbianhao() {
		return dianyingbianhao;
	}
	/**
	 * 设置：电影名称
	 */
	public void setDianyingmingcheng(String dianyingmingcheng) {
		this.dianyingmingcheng = dianyingmingcheng;
	}
	/**
	 * 获取：电影名称
	 */
	public String getDianyingmingcheng() {
		return dianyingmingcheng;
	}
	/**
	 * 设置：电影分类
	 */
	public void setDianyingfenlei(String dianyingfenlei) {
		this.dianyingfenlei = dianyingfenlei;
	}
	/**
	 * 获取：电影分类
	 */
	public String getDianyingfenlei() {
		return dianyingfenlei;
	}
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
	 * 设置：导演
	 */
	public void setDaoyan(String daoyan) {
		this.daoyan = daoyan;
	}
	/**
	 * 获取：导演
	 */
	public String getDaoyan() {
		return daoyan;
	}
	/**
	 * 设置：票价
	 */
	public void setPiaojia(Integer piaojia) {
		this.piaojia = piaojia;
	}
	/**
	 * 获取：票价
	 */
	public Integer getPiaojia() {
		return piaojia;
	}
	/**
	 * 设置：主演
	 */
	public void setZhuyan(String zhuyan) {
		this.zhuyan = zhuyan;
	}
	/**
	 * 获取：主演
	 */
	public String getZhuyan() {
		return zhuyan;
	}
	/**
	 * 设置：场次
	 */
	public void setChangci(String changci) {
		this.changci = changci;
	}
	/**
	 * 获取：场次
	 */
	public String getChangci() {
		return changci;
	}
	/**
	 * 设置：上映日期
	 */
	public void setShangyingriqi(Date shangyingriqi) {
		this.shangyingriqi = shangyingriqi;
	}
	/**
	 * 获取：上映日期
	 */
	public Date getShangyingriqi() {
		return shangyingriqi;
	}
	/**
	 * 设置：语言
	 */
	public void setYuyan(String yuyan) {
		this.yuyan = yuyan;
	}
	/**
	 * 获取：语言
	 */
	public String getYuyan() {
		return yuyan;
	}
	/**
	 * 设置：当地是否有疫情
	 */
	public void setDangdishifouyouyiqing(String dangdishifouyouyiqing) {
		this.dangdishifouyouyiqing = dangdishifouyouyiqing;
	}
	/**
	 * 获取：当地是否有疫情
	 */
	public String getDangdishifouyouyiqing() {
		return dangdishifouyouyiqing;
	}
	/**
	 * 设置：电影简介
	 */
	public void setDianyingjianjie(String dianyingjianjie) {
		this.dianyingjianjie = dianyingjianjie;
	}
	/**
	 * 获取：电影简介
	 */
	public String getDianyingjianjie() {
		return dianyingjianjie;
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
