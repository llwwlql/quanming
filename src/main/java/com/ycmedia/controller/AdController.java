package com.ycmedia.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.soap.Addressing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ycmedia.entity.Creative;
import com.ycmedia.service.AdService;

/**
 * 广告controller
 * @author zhuliangxing
 *
 */
@Controller
public class AdController {

	@Autowired
     private  AdService adservice;
  

	  @RequestMapping(value = "/product-list")
	  @ResponseBody
	   public ModelAndView getAdList(@RequestParam(value="beginDate",required=false) Date beginDate,
			   @RequestParam(value="endDate",required=false) Date endDate
			   ){
		  List<Creative> list = new ArrayList<Creative>();
		  try {
			   list = adservice.getAdList();
		    } catch (Exception e) {
		 }
		  
		  return new ModelAndView("product-list", "list", list);
//		   return "product-list";
	   }
	  
}
