package com.wsy.one.first;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services
{
	private Services()
	{
	}
	private static final Map<String,Provider> providers=new ConcurrentHashMap<String,Provider>();
	private static final Map<List<Object>,List<Map<String,Object>>> num4=new HashMap<List<Object>,List<Map<String,Object>>>();//1.7+以后支持直接用<>代替前面写法
	private static final Map<List<Object>,List<Map<String,Object>>> num5=new HashMap();//这种写法后面会有警告
	public static final String DEFAULT_PROVIDER_NAME="<def>";
	//面向对象特性:多态。继承、封装。
	public static void registerDefaultProvider(Provider p){
		registerProvider(DEFAULT_PROVIDER_NAME,p);
	}
	public static void registerProvider(String name,Provider p){
		providers.put(name, p);
	}
	
	public static Service newInstance(){
		return newInstance(DEFAULT_PROVIDER_NAME);
	}
	
	public static Service newInstance(String name){
		Provider p =providers.get(name);
		if(p==null){
			throw new IllegalArgumentException("No provider registered with name:"+name);
		}
		return p.newServices();
	}

}
