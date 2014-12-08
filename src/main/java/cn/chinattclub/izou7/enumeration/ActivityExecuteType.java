package cn.chinattclub.izou7.enumeration;
/**
 * 
 * 活动提交状态枚举
 *
 * @author zhangying.
 *         Created 2014-11-13.
 */
public enum ActivityExecuteType {

	NEXT(0,"下一步"),
	
	SAVE(1,"保存"),
	
	DEPLOY(2,"发布");
	
	private int value;
	
	private String name;
	
	ActivityExecuteType(int value,String name){
		this.name = name;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

