package m1.utils;

import m2.M2Object;

public class Message extends M2Object {

	private Object content;

	public Message(String name) {
		super(name);
	}

	public void setContent(Object o) {
		this.content = o;
	}

	public Object getContent() {
		return this.content;
	}

}
