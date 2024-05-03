package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HunlianketangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HunlianketangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HunlianketangView;


/**
 * 婚恋课堂
 *
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
public interface HunlianketangService extends IService<HunlianketangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HunlianketangVO> selectListVO(Wrapper<HunlianketangEntity> wrapper);
   	
   	HunlianketangVO selectVO(@Param("ew") Wrapper<HunlianketangEntity> wrapper);
   	
   	List<HunlianketangView> selectListView(Wrapper<HunlianketangEntity> wrapper);
   	
   	HunlianketangView selectView(@Param("ew") Wrapper<HunlianketangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HunlianketangEntity> wrapper);
   	

}

