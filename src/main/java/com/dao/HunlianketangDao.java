package com.dao;

import com.entity.HunlianketangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HunlianketangVO;
import com.entity.view.HunlianketangView;


/**
 * 婚恋课堂
 * 
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
public interface HunlianketangDao extends BaseMapper<HunlianketangEntity> {
	
	List<HunlianketangVO> selectListVO(@Param("ew") Wrapper<HunlianketangEntity> wrapper);
	
	HunlianketangVO selectVO(@Param("ew") Wrapper<HunlianketangEntity> wrapper);
	
	List<HunlianketangView> selectListView(@Param("ew") Wrapper<HunlianketangEntity> wrapper);

	List<HunlianketangView> selectListView(Pagination page,@Param("ew") Wrapper<HunlianketangEntity> wrapper);
	
	HunlianketangView selectView(@Param("ew") Wrapper<HunlianketangEntity> wrapper);
	

}
