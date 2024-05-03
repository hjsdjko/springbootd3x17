package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WodeliangyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WodeliangyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WodeliangyuanView;


/**
 * 我的良缘
 *
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
public interface WodeliangyuanService extends IService<WodeliangyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WodeliangyuanVO> selectListVO(Wrapper<WodeliangyuanEntity> wrapper);
   	
   	WodeliangyuanVO selectVO(@Param("ew") Wrapper<WodeliangyuanEntity> wrapper);
   	
   	List<WodeliangyuanView> selectListView(Wrapper<WodeliangyuanEntity> wrapper);
   	
   	WodeliangyuanView selectView(@Param("ew") Wrapper<WodeliangyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WodeliangyuanEntity> wrapper);
   	

}

