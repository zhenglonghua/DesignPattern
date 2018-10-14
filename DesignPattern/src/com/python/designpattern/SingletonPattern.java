package com.python.designpattern;

/**
 * @author zheng2018年10月14日
 * @description 单例模式的类只允许存在一个实例  单例模式有多种实现方式
 */
public class SingletonPattern {
	
/**
 * *静态常量
**优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
**缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 * 
 * */
//    private final static SingletonPattern INSTANCE = new SingletonPattern();
//    /**
//     * @author zheng2018年10月14日
//     */
//    private SingletonPattern(){}
//
//    /**
//     *@author zheng2018年10月14日
//     *@return 
//     */
//    public static SingletonPattern getInstance(){
//        return INSTANCE;
//    }

/**
	**优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
	**缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
	 * 
* */

    
}
