package com.python.designpattern.ProducerAndComsumerPattern.BlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author zheng2018年10月14日
 * @description 
 */
public class Producer implements Runnable {

	private BlockingQueue<String> queue;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			queue.put("Producer:" + System.currentTimeMillis());
			System.out.println("Producer:" + System.currentTimeMillis()+"Thread:"+Thread.currentThread().getName()+";剩余产品："+queue.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
