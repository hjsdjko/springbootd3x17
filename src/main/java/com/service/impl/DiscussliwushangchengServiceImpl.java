package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussliwushangchengDao;
import com.entity.DiscussliwushangchengEntity;
import com.service.DiscussliwushangchengService;
import com.entity.vo.DiscussliwushangchengVO;
import com.entity.view.DiscussliwushangchengView;

@Service("discussliwushangchengService")
public class DiscussliwushangchengServiceImpl extends ServiceImpl<DiscussliwushangchengDao, DiscussliwushangchengEntity> implements DiscussliwushangchengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussliwushangchengEntity> page = this.selectPage(
                new Query<DiscussliwushangchengEntity>(params).getPage(),
                new EntityWrapper<DiscussliwushangchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussliwushangchengEntity> wrapper) {
		  Page<DiscussliwushangchengView> page =new Query<DiscussliwushangchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussliwushangchengVO> selectListVO(Wrapper<DiscussliwushangchengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussliwushangchengVO selectVO(Wrapper<DiscussliwushangchengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussliwushangchengView> selectListView(Wrapper<DiscussliwushangchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussliwushangchengView selectView(Wrapper<DiscussliwushangchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
