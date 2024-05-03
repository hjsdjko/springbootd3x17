package com.dao;

import com.entity.WodeliangyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WodeliangyuanVO;
import com.entity.view.WodeliangyuanView;


/**
 * 我的良缘
 * 
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
public interface WodeliangyuanDao extends BaseMapper<WodeliangyuanEntity> {
	
	List<WodeliangyuanVO> selectListVO(@Param("ew") Wrapper<WodeliangyuanEntity> wrapper);
	
	WodeliangyuanVO selectVO(@Param("ew") Wrapper<WodeliangyuanEntity> wrapper);
	
	List<WodeliangyuanView> selectListView(@Param("ew") Wrapper<WodeliangyuanEntity> wrapper);

	List<WodeliangyuanView> selectListView(Pagination page,@Param("ew") Wrapper<WodeliangyuanEntity> wrapper);
	
	WodeliangyuanView selectView(@Param("ew") Wrapper<WodeliangyuanEntity> wrapper);
	

}
