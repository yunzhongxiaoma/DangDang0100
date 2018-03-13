package com.dangdang.service;


import java.util.ArrayList;
import java.util.List;

import com.dangdang.dao.GoodsDAO;
import com.dangdang.entity.Goods;
import com.dangdang.util.BigdecimalUtil;
import com.dangdang.util.MyBatisUtil;
import com.dangdang.vo.Cart;
import com.dangdang.vo.OrderItem;

public class CartServiceImpl  implements CartService {
	
	//点击购买按钮	添加商品到购物车
	@Override
	public Cart addCart(Integer GID, Cart oldCart) {
	    GoodsDAO  gd=(GoodsDAO)MyBatisUtil.getMapper(GoodsDAO.class);
	    //通过ID查询添加入购物车中的商品
	    Goods goods = gd.queryProductById(GID);
	    
	    if (goods == null) {
			return null;
		}
	    //判断购物中有没有此商品
	    if(oldCart.getCartMap().containsKey(GID)){
	    	//获得对应商品所在的购物车项、更新该商品的数量和小计
	    	OrderItem cartItem = oldCart.getCartMap().get(GID);
	    	cartItem.setAmount(cartItem.getAmount()+1);
	    	cartItem.setSmallprice(BigdecimalUtil.add(cartItem.getSmallprice(), goods.getDangdangPrice() ));
	    }else{
	    	  //没有该商品   创建新的购物车项
	    	  OrderItem cartItem = new  OrderItem();
	    	  cartItem.setGoods(goods);
	    	  cartItem.setAmount(1);
	    	  cartItem.setSmallprice(goods.getDangdangPrice());
	    	  //把新的购物车项   放入到Map集合中
	    	  oldCart.getCartMap().put(GID,cartItem);
	    }
	    //每次添加商品更新总价和已节省的钱
	    oldCart.setTotalprice(BigdecimalUtil.add(oldCart.getTotalprice(), goods.getDangdangPrice() ));
	    oldCart.setSaveMoney(BigdecimalUtil.add(oldCart.getSaveMoney(), goods.getOriginalPrice()-goods.getDangdangPrice() ));
	    return   oldCart;
	}
	
	//修改购物车商品数量
	@Override
	public Cart updateCart(Integer GID, Integer amount, Cart oldCart) {
		OrderItem cartItem = oldCart.getCartMap().get(GID);
		double dangdangPrice = cartItem.getGoods().getDangdangPrice();
		double originalPrice = cartItem.getGoods().getOriginalPrice();
		//根据商品数量变动，更新购物车总价，节省费用
		oldCart.setTotalprice(BigdecimalUtil.add(oldCart.getTotalprice(),
				(amount - cartItem.getAmount()) * dangdangPrice));
		oldCart.setSaveMoney(BigdecimalUtil.add(oldCart.getSaveMoney(),
				(amount - cartItem.getAmount()) * (originalPrice-dangdangPrice) ));
		//再更新购物车项	数量，小计
		cartItem.setAmount(amount);
		cartItem.setSmallprice(amount * dangdangPrice);
		return oldCart;
	}
	
	//删除购物车项
	@Override
	public List<Cart> deleteCart(Integer GID, Cart oldCart, Cart deleteCart) {
		OrderItem cartItem = oldCart.getCartMap().get(GID);
		double dangdangPrice = cartItem.getGoods().getDangdangPrice();
		double originalPrice = cartItem.getGoods().getOriginalPrice();
		//更新购物车	总价，节省费用
		oldCart.setTotalprice(BigdecimalUtil.add(oldCart.getTotalprice(),
				-cartItem.getSmallprice() ));
		oldCart.setSaveMoney(BigdecimalUtil.add(oldCart.getSaveMoney(),
				-cartItem.getAmount() * (originalPrice-dangdangPrice) ));
		//删除购物车项 
		oldCart.getCartMap().remove(GID);
		//加入购物车项	到恢复购物车
		deleteCart.getCartMap().put(GID,cartItem);
		
		List<Cart> cartList = new ArrayList<>() ;
		cartList.add(oldCart);
		cartList.add(deleteCart);
		return cartList;
	}
	
	//恢复购物车项 
	@Override
	public List<Cart> recoverCart(Integer GID, Cart oldCart, Cart deleteCart) {
		OrderItem cartItem = deleteCart.getCartMap().get(GID);
		double dangdangPrice = cartItem.getGoods().getDangdangPrice();
		double originalPrice = cartItem.getGoods().getOriginalPrice();
		//更新购物车	总价，节省费用
		oldCart.setTotalprice(BigdecimalUtil.add(oldCart.getTotalprice(),
				cartItem.getSmallprice() ));
		oldCart.setSaveMoney(BigdecimalUtil.add(oldCart.getSaveMoney(),
				cartItem.getAmount() * (originalPrice-dangdangPrice) ));
		//删除恢复购物车项 
		deleteCart.getCartMap().remove(GID);
		//加入购物车项	到购物车
		oldCart.getCartMap().put(GID,cartItem);
		
		List<Cart> cartList = new ArrayList<>() ;
		cartList.add(oldCart);
		cartList.add(deleteCart);
		return cartList;
	}
	
}
