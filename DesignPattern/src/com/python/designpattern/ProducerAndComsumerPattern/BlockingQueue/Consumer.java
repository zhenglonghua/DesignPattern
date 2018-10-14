package com.python.designpattern.ProducerAndComsumerPattern.BlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author zheng2018年10月14日
 * @description 
 */
public class Consumer implements Runnable {

	private BlockingQueue<String> queue;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while(true) {
				String name = queue.take();
				System.out.println("Consumer:" + name+";Thread:"+Thread.currentThread().getName()+";剩余产品："+queue.size());
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
