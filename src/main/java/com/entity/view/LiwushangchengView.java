package com.entity.view;

import com.entity.LiwushangchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 礼物商城
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
@TableName("liwushangcheng")
public class LiwushangchengView  extends LiwushangchengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LiwushangchengView(){
	}
 
 	public LiwushangchengView(LiwushangchengEntity liwushangchengEntity){
 	try {
			BeanUtils.copyProperties(this, liwushangchengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
