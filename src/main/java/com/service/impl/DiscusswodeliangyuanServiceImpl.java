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


import com.dao.DiscusswodeliangyuanDao;
import com.entity.DiscusswodeliangyuanEntity;
import com.service.DiscusswodeliangyuanService;
import com.entity.vo.DiscusswodeliangyuanVO;
import com.entity.view.DiscusswodeliangyuanView;

@Service("discusswodeliangyuanService")
public class DiscusswodeliangyuanServiceImpl extends ServiceImpl<DiscusswodeliangyuanDao, DiscusswodeliangyuanEntity> implements DiscusswodeliangyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusswodeliangyuanEntity> page = this.selectPage(
                new Query<DiscusswodeliangyuanEntity>(params).getPage(),
                new EntityWrapper<DiscusswodeliangyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusswodeliangyuanEntity> wrapper) {
		  Page<DiscusswodeliangyuanView> page =new Query<DiscusswodeliangyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusswodeliangyuanVO> selectListVO(Wrapper<DiscusswodeliangyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusswodeliangyuanVO selectVO(Wrapper<DiscusswodeliangyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusswodeliangyuanView> selectListView(Wrapper<DiscusswodeliangyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusswodeliangyuanView selectView(Wrapper<DiscusswodeliangyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
