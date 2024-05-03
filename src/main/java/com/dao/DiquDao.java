package com.dao;

import com.entity.DiquEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiquVO;
import com.entity.view.DiquView;


/**
 * 地区
 * 
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
public interface DiquDao extends BaseMapper<DiquEntity> {
	
	List<DiquVO> selectListVO(@Param("ew") Wrapper<DiquEntity> wrapper);
	
	DiquVO selectVO(@Param("ew") Wrapper<DiquEntity> wrapper);
	
	List<DiquView> selectListView(@Param("ew") Wrapper<DiquEntity> wrapper);

	List<DiquView> selectListView(Pagination page,@Param("ew") Wrapper<DiquEntity> wrapper);
	
	DiquView selectView(@Param("ew") Wrapper<DiquEntity> wrapper);
	

}
