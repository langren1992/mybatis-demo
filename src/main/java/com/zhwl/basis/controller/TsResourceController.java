package com.zhwl.basis.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhwl.basis.service.TsResourceService;
import com.zhwl.common.entity.Result;

@Controller
public class TsResourceController {
	
	@Autowired
	private TsResourceService tsResourceService;
	
	@RequestMapping("/res")
	public String showRes(){
		return "resource/resource";
	}
	
	@RequestMapping("/res/resList")
	@ResponseBody
	public Result showResList(){
		Result rs = new Result();
		rs.setDataList(tsResourceService.findResources());
		return rs;
	}

}
