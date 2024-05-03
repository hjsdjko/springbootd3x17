package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiquEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiquVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiquView;


/**
 * 地区
 *
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
public interface DiquService extends IService<DiquEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiquVO> selectListVO(Wrapper<DiquEntity> wrapper);
   	
   	DiquVO selectVO(@Param("ew") Wrapper<DiquEntity> wrapper);
   	
   	List<DiquView> selectListView(Wrapper<DiquEntity> wrapper);
   	
   	DiquView selectView(@Param("ew") Wrapper<DiquEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiquEntity> wrapper);
   	

}

