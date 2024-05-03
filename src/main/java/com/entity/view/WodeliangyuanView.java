package com.entity.view;

import com.entity.WodeliangyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 我的良缘
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
@TableName("wodeliangyuan")
public class WodeliangyuanView  extends WodeliangyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WodeliangyuanView(){
	}
 
 	public WodeliangyuanView(WodeliangyuanEntity wodeliangyuanEntity){
 	try {
			BeanUtils.copyProperties(this, wodeliangyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
