package com.demo.mark.myeventbus_demo.event;

public class SecondEvent{

	private String mMsg;
	public SecondEvent(String msg) {
		// TODO Auto-generated constructor stub
		mMsg = "MainEvent:"+msg;
	}
	public String getMsg(){
		return mMsg;
	}
}
