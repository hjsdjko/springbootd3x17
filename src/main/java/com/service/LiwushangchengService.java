package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LiwushangchengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LiwushangchengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LiwushangchengView;


/**
 * 礼物商城
 *
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
public interface LiwushangchengService extends IService<LiwushangchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LiwushangchengVO> selectListVO(Wrapper<LiwushangchengEntity> wrapper);
   	
   	LiwushangchengVO selectVO(@Param("ew") Wrapper<LiwushangchengEntity> wrapper);
   	
   	List<LiwushangchengView> selectListView(Wrapper<LiwushangchengEntity> wrapper);
   	
   	LiwushangchengView selectView(@Param("ew") Wrapper<LiwushangchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LiwushangchengEntity> wrapper);
   	

}

