package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DianyinggoupiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DianyinggoupiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DianyinggoupiaoView;


/**
 * 电影购票
 *
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
public interface DianyinggoupiaoService extends IService<DianyinggoupiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DianyinggoupiaoVO> selectListVO(Wrapper<DianyinggoupiaoEntity> wrapper);
   	
   	DianyinggoupiaoVO selectVO(@Param("ew") Wrapper<DianyinggoupiaoEntity> wrapper);
   	
   	List<DianyinggoupiaoView> selectListView(Wrapper<DianyinggoupiaoEntity> wrapper);
   	
   	DianyinggoupiaoView selectView(@Param("ew") Wrapper<DianyinggoupiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DianyinggoupiaoEntity> wrapper);
   	

}

