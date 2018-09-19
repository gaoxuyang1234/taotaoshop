package com.taotao.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIPageResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private TbItemMapper itemMapper;
	
	
	public TbItem getItemById(long itemId) {
		
		return itemMapper.selectByPrimaryKey(itemId);
	}


	
	public EasyUIPageResult getItemList(Integer page, Integer rows) {
		
		//查询商品列表
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(page,rows);
		List<TbItem> list = itemMapper.selectByExample(example);    //这个是查看所有信息的方法
		
		//创建一个返回值对象
		EasyUIPageResult result = new EasyUIPageResult();
		result.setRows(list);
		//取记录总条数
				PageInfo<TbItem> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
		
		return result;
	}
	

}
