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


import com.dao.HunlianketangDao;
import com.entity.HunlianketangEntity;
import com.service.HunlianketangService;
import com.entity.vo.HunlianketangVO;
import com.entity.view.HunlianketangView;

@Service("hunlianketangService")
public class HunlianketangServiceImpl extends ServiceImpl<HunlianketangDao, HunlianketangEntity> implements HunlianketangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HunlianketangEntity> page = this.selectPage(
                new Query<HunlianketangEntity>(params).getPage(),
                new EntityWrapper<HunlianketangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HunlianketangEntity> wrapper) {
		  Page<HunlianketangView> page =new Query<HunlianketangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HunlianketangVO> selectListVO(Wrapper<HunlianketangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HunlianketangVO selectVO(Wrapper<HunlianketangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HunlianketangView> selectListView(Wrapper<HunlianketangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HunlianketangView selectView(Wrapper<HunlianketangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
