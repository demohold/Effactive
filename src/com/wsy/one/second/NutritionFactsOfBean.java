package com.wsy.one.second;

public class NutritionFactsOfBean
{
	private  int servingSize=-1;//分量大小//ml required
	private  int servings=-1;//服务，食物//per container required
	private  int calories;//卡路里、optional
	private  int fat;//脂肪 optional
	private  int sodium;//<化>钠(11号元素，符号 Na);optional
	private  int carbohydrate;//碳水化合物 optional 
	
	public NutritionFactsOfBean(){
		
	}
	public void setServingSize(int servingSize)
	{
		this.servingSize = servingSize;
	} 

	public void setServings(int servings)
	{
		this.servings = servings;
	}

	public void setCalories(int calories)
	{
		this.calories = calories;
	}

	public void setFat(int fat)
	{
		this.fat = fat;
	}

	public void setSodium(int sodium)
	{
		this.sodium = sodium;
	}

	public void setCarbohydrate(int carbohydrate)
	{
		this.carbohydrate = carbohydrate;
	}
	
	public static void main(String[] args)
	{	
		//javabean模式创建。
		//易于阅读，知道每个参数都是什么值。
		//因为是分开多个set设置值，导致javabean在构造过程中容易出现不一致状态。
		//类无法通过校验构造器参数的有效性来保证一致性
		//不能将一个类做成不可变类，线程非安全，需要自己去注意实现线程安全
		//
		NutritionFactsOfBean cocaCola=new NutritionFactsOfBean();
		cocaCola.setServingSize(240);
		cocaCola.setServings(8);
		cocaCola.setCalories(100);
		cocaCola.setSodium(35);
		cocaCola.setCarbohydrate(27);
	}
}
