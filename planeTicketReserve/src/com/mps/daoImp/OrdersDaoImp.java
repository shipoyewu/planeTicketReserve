package com.mps.daoImp;

import com.mps.daoBase.BaseDao;
import com.mps.model.Orders;

public class OrdersDaoImp extends BaseDao<Orders, Integer> {
	public OrdersDaoImp(){
		super(Orders.class);
	}
}
