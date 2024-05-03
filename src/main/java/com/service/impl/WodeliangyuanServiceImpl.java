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


import com.dao.WodeliangyuanDao;
import com.entity.WodeliangyuanEntity;
import com.service.WodeliangyuanService;
import com.entity.vo.WodeliangyuanVO;
import com.entity.view.WodeliangyuanView;

@Service("wodeliangyuanService")
public class WodeliangyuanServiceImpl extends ServiceImpl<WodeliangyuanDao, WodeliangyuanEntity> implements WodeliangyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WodeliangyuanEntity> page = this.selectPage(
                new Query<WodeliangyuanEntity>(params).getPage(),
                new EntityWrapper<WodeliangyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WodeliangyuanEntity> wrapper) {
		  Page<WodeliangyuanView> page =new Query<WodeliangyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WodeliangyuanVO> selectListVO(Wrapper<WodeliangyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WodeliangyuanVO selectVO(Wrapper<WodeliangyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WodeliangyuanView> selectListView(Wrapper<WodeliangyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WodeliangyuanView selectView(Wrapper<WodeliangyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
