package com.neuedu.print.bean;

/**
 * 统一返回数据类型ResultBean：前端接收到的数据统一是ResultBean
 *
 */
public class ResultBean {
	/**
	 * 成功与否的编号：100+，200+，300+，400+，500+
	 */
	private Integer code;
	/**
	 * 成功与否的标志：true成功，false失败
	 */
	private boolean successed;
	/**
	 * 成功或失败的信息
	 */
	private String message;
	/**
	 * 返回数据：可以展示，可以用于判断
	 */
	private Object data;
	
	/**
	 * 构造器
	 * @param code 编码
	 * @param successed 成功与否
	 * @param message 信息
	 */
	public ResultBean(Integer code, boolean successed, String message) {
		super();
		this.code = code;
		this.successed = successed;
		this.message = message;
	}
	
	/**
	 * 构造器
	 * @param code 编码
	 * @param successed 成功与否
	 * @param message  信息
	 * @param data 数据
	 */
	public ResultBean(Integer code, boolean successed, String message, Object data) {
		this(code, successed, message);
		this.data = data;
	}
	
	/**
	 * 构造器
	 */
	public ResultBean() {
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public boolean isSuccessed() {
		return successed;
	}
	public void setSuccessed(boolean successed) {
		this.successed = successed;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
