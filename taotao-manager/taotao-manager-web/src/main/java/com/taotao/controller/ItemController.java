package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIPageResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	/**
	 * 根据id查询商品信息
	 * @param itemId
	 * @return
	 */
			
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable long itemId){
		TbItem tbItem =itemService.getItemById(itemId);
		return tbItem;
	}
	/**
	 * 查询分页列表商品
	 * @param page  页
	 * @param rows   页数
	 * @return
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIPageResult getItemList(Integer page,Integer rows){
		EasyUIPageResult list=itemService.getItemList(page,rows);
		return list;
	}
	
	
}
