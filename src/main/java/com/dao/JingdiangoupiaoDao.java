package com.dao;

import com.entity.JingdiangoupiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JingdiangoupiaoVO;
import com.entity.view.JingdiangoupiaoView;


/**
 * 景点购票
 * 
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
public interface JingdiangoupiaoDao extends BaseMapper<JingdiangoupiaoEntity> {
	
	List<JingdiangoupiaoVO> selectListVO(@Param("ew") Wrapper<JingdiangoupiaoEntity> wrapper);
	
	JingdiangoupiaoVO selectVO(@Param("ew") Wrapper<JingdiangoupiaoEntity> wrapper);
	
	List<JingdiangoupiaoView> selectListView(@Param("ew") Wrapper<JingdiangoupiaoEntity> wrapper);

	List<JingdiangoupiaoView> selectListView(Pagination page,@Param("ew") Wrapper<JingdiangoupiaoEntity> wrapper);
	
	JingdiangoupiaoView selectView(@Param("ew") Wrapper<JingdiangoupiaoEntity> wrapper);
	

}
