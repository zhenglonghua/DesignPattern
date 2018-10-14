package com.python.designpattern.SingletonPattern;

/**
 * @author zheng2018年10月14日
 * @description 单例模式的类只允许存在一个实例  单例模式有多种实现方式
 */
public class Singleton {
		
/**
**  静态常量(可用)
**  优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
**  缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
***/
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
**  静态代码块(可用)
**  描述：这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优缺点和上面是一样的。
***/
//	private static Singleton instance;
//
//    static {
//        instance = new Singleton();
//    }
//
//    private Singleton() {}
//
//    public Singleton getInstance() {
//        return instance;
//    }
/**
**懒汉式[不可用]：(线程不安全)
**缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。* 
* */
//	private static Singleton singleton;
//	
//	/**
//	 * @author zheng2018年10月14日
//	 */
//	private Singleton() {
//	}
//	
//	/**
//	 *@author zheng2018年10月14日
//	 *@return
//	 */
//	public static Singleton getInstance() {
//		if (singleton == null) {
//			singleton = new Singleton();
//		}
//		return singleton;
//	}
/**
**  懒汉式[不推荐用]：(线程安全，同步方法)
**  优点：解决上面第三种实现方式的线程不安全问题，做个线程同步就可以了，于是就对getInstance()方法进行了线程同步。
**  缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。方法进行同步效率太低要改进。
***/
//	private static Singleton singleton;
//
//	private Singleton() {
//	}
//
//	public static synchronized Singleton getInstance() {
//		if (singleton == null) {
//			singleton = new Singleton();
//		}
//		return singleton;
//	}
/***
**  懒汉式[不可用]：(线程不安全，同步代码块)
**  优点：
**  缺点：由于第四种实现方式同步效率太低，所以摒弃同步方法，改为同步产生实例化的的代码块。但是这种同步并不能起到线程同步的作用。跟第3种实现方式遇到的情形一致，假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
***/
//	private static Singleton singleton;
//
//	private Singleton() {
//	}
//
//	public static Singleton getInstance() {
//		if (singleton == null) {
//			synchronized (Singleton.class) {
//				singleton = new Singleton();
//			}
//		}
//		return singleton;
//	}
/***
**  双重检查[推荐用]：线程安全；延迟加载；效率较高。
**  优点：Double-Check概念对于多线程开发者来说不会陌生，如代码中所示，我们进行了两次if (singleton == null)检查，这样就可以保证线程安全了。这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，直接return实例化对象。
**  缺点：
***/
	private static volatile Singleton singleton;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
/***
**  双重检查[推荐用]：线程安全；延迟加载；效率较高。
**  优点：Double-Check概念对于多线程开发者来说不会陌生，如代码中所示，我们进行了两次if (singleton == null)检查，这样就可以保证线程安全了。这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，直接return实例化对象。
**  缺点：
***/
//	private Singleton() {
//	}
//
//	private static class SingletonInstance {
//		private static final Singleton INSTANCE = new Singleton();
//	}
//
//	public static Singleton getInstance() {
//		return SingletonInstance.INSTANCE;
//	}
/***
**  静态内部类[推荐用]
**  优点：这种方式跟饿汉式方式采用的机制类似，但又有不同。两者都是采用了类装载的机制来保证初始化实例时只有一个线程。不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-Loading的作用，而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的实例化。
**  ，类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
**  ，避免了线程不安全，延迟加载，效率高
**  缺点：
***/

	

}
