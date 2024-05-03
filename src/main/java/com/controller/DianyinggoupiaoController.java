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

import com.entity.DianyinggoupiaoEntity;
import com.entity.view.DianyinggoupiaoView;

import com.service.DianyinggoupiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 电影购票
 * 后端接口
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
@RestController
@RequestMapping("/dianyinggoupiao")
public class DianyinggoupiaoController {
    @Autowired
    private DianyinggoupiaoService dianyinggoupiaoService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DianyinggoupiaoEntity dianyinggoupiao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			dianyinggoupiao.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DianyinggoupiaoEntity> ew = new EntityWrapper<DianyinggoupiaoEntity>();
		PageUtils page = dianyinggoupiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyinggoupiao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DianyinggoupiaoEntity dianyinggoupiao, 
		HttpServletRequest request){
        EntityWrapper<DianyinggoupiaoEntity> ew = new EntityWrapper<DianyinggoupiaoEntity>();
		PageUtils page = dianyinggoupiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dianyinggoupiao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DianyinggoupiaoEntity dianyinggoupiao){
       	EntityWrapper<DianyinggoupiaoEntity> ew = new EntityWrapper<DianyinggoupiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dianyinggoupiao, "dianyinggoupiao")); 
        return R.ok().put("data", dianyinggoupiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DianyinggoupiaoEntity dianyinggoupiao){
        EntityWrapper< DianyinggoupiaoEntity> ew = new EntityWrapper< DianyinggoupiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dianyinggoupiao, "dianyinggoupiao")); 
		DianyinggoupiaoView dianyinggoupiaoView =  dianyinggoupiaoService.selectView(ew);
		return R.ok("查询电影购票成功").put("data", dianyinggoupiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DianyinggoupiaoEntity dianyinggoupiao = dianyinggoupiaoService.selectById(id);
        return R.ok().put("data", dianyinggoupiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DianyinggoupiaoEntity dianyinggoupiao = dianyinggoupiaoService.selectById(id);
        return R.ok().put("data", dianyinggoupiao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DianyinggoupiaoEntity dianyinggoupiao, HttpServletRequest request){
    	dianyinggoupiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianyinggoupiao);
        dianyinggoupiaoService.insert(dianyinggoupiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DianyinggoupiaoEntity dianyinggoupiao, HttpServletRequest request){
    	dianyinggoupiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dianyinggoupiao);
        dianyinggoupiaoService.insert(dianyinggoupiao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DianyinggoupiaoEntity dianyinggoupiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dianyinggoupiao);
        dianyinggoupiaoService.updateById(dianyinggoupiao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dianyinggoupiaoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DianyinggoupiaoEntity> wrapper = new EntityWrapper<DianyinggoupiaoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = dianyinggoupiaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
