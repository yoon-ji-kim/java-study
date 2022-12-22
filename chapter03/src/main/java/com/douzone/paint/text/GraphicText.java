package com.douzone.paint.text;

import com.douzone.paint.i.Drawable;

public class GraphicText implements Drawable {
	private String text;
	
	//생성자
	public GraphicText(String text) {
		this.text = text;
	}

	@Override
	public void draw() {
		System.out.println("텍스트 '" + text + "'를 그렸습니다.");
	}

}
