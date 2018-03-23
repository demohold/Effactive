package com.wsy.one.second;

public class NutritionFacts
{
	//重叠构造器
	private final int servingSize;//分量大小//ml required
	private final int servings;//服务，食物//per container required
	private final int calories;//卡路里、optional
	private final int fat;//脂肪 optional
	private final int sodium;//<化>钠(11号元素，符号 Na);optional
	private final int carbohydrate;//碳水化合物 optional 
	
	public NutritionFacts(int servingSize,int servings){
		this(servingSize,servings,0);
	}
	public NutritionFacts(int servingSize,int servings,int calories){
		this(servingSize,servings,calories,0);
	}
	public NutritionFacts(int servingSize,int servings,int calories,int fat){
		this(servingSize,servings,calories,fat,0);
	}
	public NutritionFacts(int servingSize,int servings,int calories,int fat,int sodium){
		this(servingSize,servings,calories,fat,sodium,0);
	}
	public NutritionFacts(int servingSize,int servings,int calories,int fat,int sodium,int carbohydrate){
		this.servingSize=servingSize;
		this.servings=servings;
		this.calories=calories;
		this.fat=fat;
		this.sodium=sodium;
		this.carbohydrate=carbohydrate;
	}
	
	public static void main(String[] args)
	{
		//需要写太多构造器
		//每个参数代表什么，随着参数增加越来越难读。
		NutritionFacts t=new NutritionFacts(1, 1, 0, 2,1);
	}
}
