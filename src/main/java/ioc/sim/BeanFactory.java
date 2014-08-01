package ioc.sim;

public interface BeanFactory {

	/**
	 * 根据id名 ，获取bean实例
	 * 
	 * @param name
	 * @return
	 */
	public Object getBean(String name);

}
