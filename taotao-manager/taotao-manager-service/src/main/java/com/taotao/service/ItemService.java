package com.taotao.service;

import com.taotao.common.pojo.EasyUIPageResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

     TbItem getItemById(long itemId);

	EasyUIPageResult getItemList(Integer page, Integer rows);
     

     

}
