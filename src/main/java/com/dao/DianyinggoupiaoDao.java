package com.dao;

import com.entity.DianyinggoupiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DianyinggoupiaoVO;
import com.entity.view.DianyinggoupiaoView;


/**
 * 电影购票
 * 
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
public interface DianyinggoupiaoDao extends BaseMapper<DianyinggoupiaoEntity> {
	
	List<DianyinggoupiaoVO> selectListVO(@Param("ew") Wrapper<DianyinggoupiaoEntity> wrapper);
	
	DianyinggoupiaoVO selectVO(@Param("ew") Wrapper<DianyinggoupiaoEntity> wrapper);
	
	List<DianyinggoupiaoView> selectListView(@Param("ew") Wrapper<DianyinggoupiaoEntity> wrapper);

	List<DianyinggoupiaoView> selectListView(Pagination page,@Param("ew") Wrapper<DianyinggoupiaoEntity> wrapper);
	
	DianyinggoupiaoView selectView(@Param("ew") Wrapper<DianyinggoupiaoEntity> wrapper);
	

}
