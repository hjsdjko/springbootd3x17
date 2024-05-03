package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusswodeliangyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusswodeliangyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusswodeliangyuanView;


/**
 * 我的良缘评论表
 *
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
public interface DiscusswodeliangyuanService extends IService<DiscusswodeliangyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusswodeliangyuanVO> selectListVO(Wrapper<DiscusswodeliangyuanEntity> wrapper);
   	
   	DiscusswodeliangyuanVO selectVO(@Param("ew") Wrapper<DiscusswodeliangyuanEntity> wrapper);
   	
   	List<DiscusswodeliangyuanView> selectListView(Wrapper<DiscusswodeliangyuanEntity> wrapper);
   	
   	DiscusswodeliangyuanView selectView(@Param("ew") Wrapper<DiscusswodeliangyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusswodeliangyuanEntity> wrapper);
   	

}

