package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscusswodeliangyuanEntity;
import com.entity.view.DiscusswodeliangyuanView;

import com.service.DiscusswodeliangyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 我的良缘评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
@RestController
@RequestMapping("/discusswodeliangyuan")
public class DiscusswodeliangyuanController {
    @Autowired
    private DiscusswodeliangyuanService discusswodeliangyuanService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusswodeliangyuanEntity discusswodeliangyuan,
		HttpServletRequest request){
        EntityWrapper<DiscusswodeliangyuanEntity> ew = new EntityWrapper<DiscusswodeliangyuanEntity>();
		PageUtils page = discusswodeliangyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusswodeliangyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusswodeliangyuanEntity discusswodeliangyuan, 
		HttpServletRequest request){
        EntityWrapper<DiscusswodeliangyuanEntity> ew = new EntityWrapper<DiscusswodeliangyuanEntity>();
		PageUtils page = discusswodeliangyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusswodeliangyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusswodeliangyuanEntity discusswodeliangyuan){
       	EntityWrapper<DiscusswodeliangyuanEntity> ew = new EntityWrapper<DiscusswodeliangyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusswodeliangyuan, "discusswodeliangyuan")); 
        return R.ok().put("data", discusswodeliangyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusswodeliangyuanEntity discusswodeliangyuan){
        EntityWrapper< DiscusswodeliangyuanEntity> ew = new EntityWrapper< DiscusswodeliangyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusswodeliangyuan, "discusswodeliangyuan")); 
		DiscusswodeliangyuanView discusswodeliangyuanView =  discusswodeliangyuanService.selectView(ew);
		return R.ok("查询我的良缘评论表成功").put("data", discusswodeliangyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusswodeliangyuanEntity discusswodeliangyuan = discusswodeliangyuanService.selectById(id);
        return R.ok().put("data", discusswodeliangyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusswodeliangyuanEntity discusswodeliangyuan = discusswodeliangyuanService.selectById(id);
        return R.ok().put("data", discusswodeliangyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusswodeliangyuanEntity discusswodeliangyuan, HttpServletRequest request){
    	discusswodeliangyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusswodeliangyuan);
        discusswodeliangyuanService.insert(discusswodeliangyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusswodeliangyuanEntity discusswodeliangyuan, HttpServletRequest request){
    	discusswodeliangyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusswodeliangyuan);
        discusswodeliangyuanService.insert(discusswodeliangyuan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscusswodeliangyuanEntity discusswodeliangyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusswodeliangyuan);
        discusswodeliangyuanService.updateById(discusswodeliangyuan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusswodeliangyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscusswodeliangyuanEntity> wrapper = new EntityWrapper<DiscusswodeliangyuanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusswodeliangyuanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
