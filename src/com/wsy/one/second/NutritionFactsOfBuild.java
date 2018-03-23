package com.wsy.one.second;

public class NutritionFactsOfBuild
{
	private  final int servingSize;//分量大小//ml required
	private  final int servings;//服务，食物//per container required
	private  final int calories;//卡路里、optional
	private  final int fat;//脂肪 optional
	private  final int sodium;//<化>钠(11号元素，符号 Na);optional
	private  final int carbohydrate;//碳水化合物 optional 
	
	public static class Builder{
		private  final int servingSize;//分量大小//ml required
		private  final int servings;//服务，食物//per container required
		private   int calories=0;//卡路里、optional
		private   int fat=0;//脂肪 optional
		private   int sodium=0;//<化>钠(11号元素，符号 Na);optional
		private   int carbohydrate=0;//碳水化合物 optional 
		public Builder(int servingSize,int servings)
		{
			this.servingSize=servingSize;
			this.servings=servings;
		}
		public Builder calories(int val){
			this.calories=val;
			return this;
		}
		public Builder fat(int val){
			this.fat=val;
			return this;
		}
		public Builder carbohydrate(int val){
			this.carbohydrate=val;
			return this;
		}
		public Builder sodium(int val){
			this.sodium=val;
			return this;
		}
		public NutritionFactsOfBuild build(){
			return new NutritionFactsOfBuild(this);
		}
		
	}
	private NutritionFactsOfBuild(Builder builder){
		servingSize=builder.servingSize;
		servings=builder.servings;
		calories=builder.calories;
		fat=builder.fat;
		sodium=builder.sodium;
		carbohydrate=builder.carbohydrate;
	}
	
	public static void main(String[] args)
	{	
		//build模式创建。
		//可读性比较强，知道每个参数的含义，易于阅读
		//builder像一个构造器一样，可以对其参数强加约束条件。可以检验这些约束条件。
		//构建灵活，安全性强
		//Class.newInstance破坏了编译时的异常检测，运行时容易出异常。所以builder替换可能更好
		NutritionFactsOfBuild cocaCola=new NutritionFactsOfBuild.Builder(240, 8)
		.calories(100).sodium(35).carbohydrate(27).build();
	}
}
