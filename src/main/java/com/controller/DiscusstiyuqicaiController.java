package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
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

import com.entity.DiscusstiyuqicaiEntity;
import com.entity.view.DiscusstiyuqicaiView;

import com.service.DiscusstiyuqicaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 体育器材评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-08 15:45:48
 */
@RestController
@RequestMapping("/discusstiyuqicai")
public class DiscusstiyuqicaiController {
    @Autowired
    private DiscusstiyuqicaiService discusstiyuqicaiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusstiyuqicaiEntity discusstiyuqicai,
		HttpServletRequest request){
        EntityWrapper<DiscusstiyuqicaiEntity> ew = new EntityWrapper<DiscusstiyuqicaiEntity>();

		PageUtils page = discusstiyuqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusstiyuqicai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusstiyuqicaiEntity discusstiyuqicai, 
		HttpServletRequest request){
        EntityWrapper<DiscusstiyuqicaiEntity> ew = new EntityWrapper<DiscusstiyuqicaiEntity>();

		PageUtils page = discusstiyuqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusstiyuqicai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusstiyuqicaiEntity discusstiyuqicai){
       	EntityWrapper<DiscusstiyuqicaiEntity> ew = new EntityWrapper<DiscusstiyuqicaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusstiyuqicai, "discusstiyuqicai")); 
        return R.ok().put("data", discusstiyuqicaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusstiyuqicaiEntity discusstiyuqicai){
        EntityWrapper< DiscusstiyuqicaiEntity> ew = new EntityWrapper< DiscusstiyuqicaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusstiyuqicai, "discusstiyuqicai")); 
		DiscusstiyuqicaiView discusstiyuqicaiView =  discusstiyuqicaiService.selectView(ew);
		return R.ok("查询体育器材评论表成功").put("data", discusstiyuqicaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusstiyuqicaiEntity discusstiyuqicai = discusstiyuqicaiService.selectById(id);
        return R.ok().put("data", discusstiyuqicai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusstiyuqicaiEntity discusstiyuqicai = discusstiyuqicaiService.selectById(id);
        return R.ok().put("data", discusstiyuqicai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusstiyuqicaiEntity discusstiyuqicai, HttpServletRequest request){
    	discusstiyuqicai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusstiyuqicai);
        discusstiyuqicaiService.insert(discusstiyuqicai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusstiyuqicaiEntity discusstiyuqicai, HttpServletRequest request){
    	discusstiyuqicai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusstiyuqicai);
        discusstiyuqicaiService.insert(discusstiyuqicai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscusstiyuqicaiEntity discusstiyuqicai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusstiyuqicai);
        discusstiyuqicaiService.updateById(discusstiyuqicai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusstiyuqicaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
