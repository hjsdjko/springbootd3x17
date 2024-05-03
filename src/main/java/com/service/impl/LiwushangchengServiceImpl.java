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


import com.dao.LiwushangchengDao;
import com.entity.LiwushangchengEntity;
import com.service.LiwushangchengService;
import com.entity.vo.LiwushangchengVO;
import com.entity.view.LiwushangchengView;

@Service("liwushangchengService")
public class LiwushangchengServiceImpl extends ServiceImpl<LiwushangchengDao, LiwushangchengEntity> implements LiwushangchengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LiwushangchengEntity> page = this.selectPage(
                new Query<LiwushangchengEntity>(params).getPage(),
                new EntityWrapper<LiwushangchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LiwushangchengEntity> wrapper) {
		  Page<LiwushangchengView> page =new Query<LiwushangchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LiwushangchengVO> selectListVO(Wrapper<LiwushangchengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LiwushangchengVO selectVO(Wrapper<LiwushangchengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LiwushangchengView> selectListView(Wrapper<LiwushangchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LiwushangchengView selectView(Wrapper<LiwushangchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
