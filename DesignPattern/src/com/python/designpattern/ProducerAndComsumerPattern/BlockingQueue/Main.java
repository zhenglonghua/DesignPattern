package com.python.designpattern.ProducerAndComsumerPattern.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

	private final static int MAX_THRED_NUMBER = 100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<String> queue = new LinkedBlockingDeque<String>();
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		ExecutorService service = Executors.newFixedThreadPool(MAX_THRED_NUMBER);
		for(int i=0;i<MAX_THRED_NUMBER/2;i++) {
			service.submit(producer);
		}
		service.submit(consumer);
	}
}
