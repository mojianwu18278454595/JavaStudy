package com.sc.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadUtil
{
	@SuppressWarnings("null")
	public  static List<Object> runCheckCallable(List<Callable<Object>> threadList,boolean flag) throws InterruptedException, ExecutionException
	{
		List<Object> returnValue = new ArrayList<Object>();
		Callable<Object> inputThread=threadList.get(0); //注水
		Callable<Object> outputThread=threadList.get(1); //排水
		FutureTask<Object> input=new FutureTask<>(inputThread);
		FutureTask<Object> output=new FutureTask<>(outputThread);
		Thread myInput=new Thread(input);
		Thread myOutput=new Thread(output);
		
		myInput.start();
		myOutput.start();
		
		returnValue.add(input.get());
		returnValue.add(output.get());
		
		return returnValue;
		
	}
}
