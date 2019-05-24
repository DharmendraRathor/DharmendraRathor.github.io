package com.dsr.java.experiments.common;

public class LinkNode<T> {
	
	private T data;
	private LinkNode<T> next;

	public LinkNode(T in) {
		this.data = in;
	}
	
	public void setNextNode(LinkNode<T> node) {
		this.next = node;
	}
	
	public LinkNode<T> getNextNode() {
		return next;
	}
	
	public T getData() {
		return data;
	}

}
