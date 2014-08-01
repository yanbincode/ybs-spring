package ioc.sim;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 模拟spring读取xml ，把bean装入容器中
 * 
 * @author yanbin
 * 
 */
public class ClassPathXmlApplicationContext implements BeanFactory {

	/** 用于存放所有的bean */
	private Map<String, Object> beans = new HashMap<String, Object>();

	/**
	 * 构造方法
	 * 
	 * @param path
	 */
	public ClassPathXmlApplicationContext(String path) {
		readXml(path);
	}

	/**
	 * 读取xml
	 * 
	 * @param path
	 */
	private void readXml(String path) {
		try {
			// 根据类路径获取配置文件
			SAXReader saxReader = new SAXReader();
			URL xmlPath = getClass().getClassLoader().getResource(path);
			Document document = saxReader.read(xmlPath);
			Element root = document.getRootElement();

			// 获取所有bean节点
			@SuppressWarnings("unchecked")
			Iterator<Element> iterator = root.elementIterator("bean");
			while (iterator.hasNext()) {
				Element element = iterator.next();
				// 获取属性值
				String id = element.attributeValue("id");
				String className = element.attributeValue("class");
				// 利用反射获取对象实例
				Object clazz = Class.forName(className).newInstance();
				beans.put(id, clazz);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getBean(String name) {
		return beans.get(name);
	}

}
