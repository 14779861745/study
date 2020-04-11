package com.uchung.departmentappraise.until;

import lombok.Data;

/**
 * 服务器与客户端传递数据的对象类
 * @author zhu
 * @param <T>
 */
@Data
public class JsonResult<T> {
	private Integer state;
	private String message;
	private T data;
	
	public JsonResult() {
		super();
		this.state = 200;
	}
	
	
	
	public JsonResult(Integer state) {
		super();
		this.state = state;
	}

	

	public JsonResult(Throwable e) {
		super();
		this.message = e.getMessage();
	}



	public JsonResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}
}
