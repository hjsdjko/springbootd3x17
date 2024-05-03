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

import com.entity.WodeliangyuanEntity;
import com.entity.view.WodeliangyuanView;

import com.service.WodeliangyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 我的良缘
 * 后端接口
 * @author 
 * @email 
 * @date 2022-05-03 18:46:28
 */
@RestController
@RequestMapping("/wodeliangyuan")
public class WodeliangyuanController {
    @Autowired
    private WodeliangyuanService wodeliangyuanService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WodeliangyuanEntity wodeliangyuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wodeliangyuan.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WodeliangyuanEntity> ew = new EntityWrapper<WodeliangyuanEntity>();
		PageUtils page = wodeliangyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodeliangyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WodeliangyuanEntity wodeliangyuan, 
		HttpServletRequest request){
        EntityWrapper<WodeliangyuanEntity> ew = new EntityWrapper<WodeliangyuanEntity>();
		PageUtils page = wodeliangyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodeliangyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WodeliangyuanEntity wodeliangyuan){
       	EntityWrapper<WodeliangyuanEntity> ew = new EntityWrapper<WodeliangyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wodeliangyuan, "wodeliangyuan")); 
        return R.ok().put("data", wodeliangyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WodeliangyuanEntity wodeliangyuan){
        EntityWrapper< WodeliangyuanEntity> ew = new EntityWrapper< WodeliangyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wodeliangyuan, "wodeliangyuan")); 
		WodeliangyuanView wodeliangyuanView =  wodeliangyuanService.selectView(ew);
		return R.ok("查询我的良缘成功").put("data", wodeliangyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WodeliangyuanEntity wodeliangyuan = wodeliangyuanService.selectById(id);
		wodeliangyuan.setClicknum(wodeliangyuan.getClicknum()+1);
		wodeliangyuan.setClicktime(new Date());
		wodeliangyuanService.updateById(wodeliangyuan);
        return R.ok().put("data", wodeliangyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WodeliangyuanEntity wodeliangyuan = wodeliangyuanService.selectById(id);
		wodeliangyuan.setClicknum(wodeliangyuan.getClicknum()+1);
		wodeliangyuan.setClicktime(new Date());
		wodeliangyuanService.updateById(wodeliangyuan);
        return R.ok().put("data", wodeliangyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WodeliangyuanEntity wodeliangyuan, HttpServletRequest request){
    	wodeliangyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wodeliangyuan);
        wodeliangyuanService.insert(wodeliangyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WodeliangyuanEntity wodeliangyuan, HttpServletRequest request){
    	wodeliangyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wodeliangyuan);
        wodeliangyuanService.insert(wodeliangyuan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WodeliangyuanEntity wodeliangyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wodeliangyuan);
        wodeliangyuanService.updateById(wodeliangyuan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wodeliangyuanService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<WodeliangyuanEntity> wrapper = new EntityWrapper<WodeliangyuanEntity>();
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

		int count = wodeliangyuanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,WodeliangyuanEntity wodeliangyuan, HttpServletRequest request,String pre){
        EntityWrapper<WodeliangyuanEntity> ew = new EntityWrapper<WodeliangyuanEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = wodeliangyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodeliangyuan), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,WodeliangyuanEntity wodeliangyuan, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "diqu";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "wodeliangyuan").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<WodeliangyuanEntity> wodeliangyuanList = new ArrayList<WodeliangyuanEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                wodeliangyuanList.addAll(wodeliangyuanService.selectList(new EntityWrapper<WodeliangyuanEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<WodeliangyuanEntity> ew = new EntityWrapper<WodeliangyuanEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = wodeliangyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wodeliangyuan), params), params));
        List<WodeliangyuanEntity> pageList = (List<WodeliangyuanEntity>)page.getList();
        if(wodeliangyuanList.size()<limit) {
            int toAddNum = (limit-wodeliangyuanList.size())<=pageList.size()?(limit-wodeliangyuanList.size()):pageList.size();
            for(WodeliangyuanEntity o1 : pageList) {
                boolean addFlag = true;
                for(WodeliangyuanEntity o2 : wodeliangyuanList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    wodeliangyuanList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(wodeliangyuanList.size()>limit) {
            wodeliangyuanList = wodeliangyuanList.subList(0, limit);
        }
        page.setList(wodeliangyuanList);
        return R.ok().put("data", page);
    }





}
