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


import com.dao.DianyinggoupiaoDao;
import com.entity.DianyinggoupiaoEntity;
import com.service.DianyinggoupiaoService;
import com.entity.vo.DianyinggoupiaoVO;
import com.entity.view.DianyinggoupiaoView;

@Service("dianyinggoupiaoService")
public class DianyinggoupiaoServiceImpl extends ServiceImpl<DianyinggoupiaoDao, DianyinggoupiaoEntity> implements DianyinggoupiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DianyinggoupiaoEntity> page = this.selectPage(
                new Query<DianyinggoupiaoEntity>(params).getPage(),
                new EntityWrapper<DianyinggoupiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DianyinggoupiaoEntity> wrapper) {
		  Page<DianyinggoupiaoView> page =new Query<DianyinggoupiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DianyinggoupiaoVO> selectListVO(Wrapper<DianyinggoupiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DianyinggoupiaoVO selectVO(Wrapper<DianyinggoupiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DianyinggoupiaoView> selectListView(Wrapper<DianyinggoupiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DianyinggoupiaoView selectView(Wrapper<DianyinggoupiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
