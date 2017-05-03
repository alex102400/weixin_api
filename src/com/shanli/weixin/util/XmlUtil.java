package com.shanli.weixin.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.google.gson.annotations.SerializedName;

/**
 * XML工具类。实现xml读取和对象转换。
 * 
 * @author alex
 *
 */
public class XmlUtil {
	private static final Log log = LogFactory.getLog(XmlUtil.class);

	private String xml;
	private Element root;

	public XmlUtil(String xml) {
		this.xml = xml;
	}

	/**
	 * 获取XML根节点
	 * 
	 * @return
	 */
	public Element getXmlRoot() {
		if (root != null) {
			return root;
		}
		try {
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new InputSource(new StringReader(xml)));
			root = document.getDocumentElement();
		} catch (Exception e) {
			log.error(String.format("XML解析异常 \n %s", xml), e);
		}
		return root;
	}

	/**
	 * 根据标签名称获取XML中的对应首个节点的内容文本
	 * 
	 * @param tag
	 * @return
	 */
	public String getXmlNodeText(String tag) {
		String[] texts = getXmlNodeTexts(tag);
		if (texts == null || texts.length < 1) {
			return null;
		}
		return texts[0];
	}

	/**
	 * 返回标签名对应的所有节点内容文本
	 * 
	 * @param tag
	 * @return
	 */
	public String[] getXmlNodeTexts(String tag) {
		if (root == null) {
			getXmlRoot();
		}

		if (root == null) {
			return null;
		}

		NodeList nodes = root.getElementsByTagName(tag);
		if (nodes == null) {
			return null;
		}
		int length = nodes.getLength();
		if (length < 1) {
			return null;
		}
		String[] texts = new String[length];
		for (int index = 0; index < length; index++) {
			texts[index] = nodes.item(index).getTextContent();
		}
		return texts;
	}

	/**
	 * 将对象转换为xml。默认根标签为xml。
	 * 
	 * @param bean
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws ParserConfigurationException
	 * @throws FactoryConfigurationError
	 * @throws XMLStreamException
	 */
	public static String toXml(Object bean) throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, ParserConfigurationException, XMLStreamException, FactoryConfigurationError {
		return toXml(bean, "xml");
	}

	/**
	 * 将对象转换为XML。
	 * 
	 * @param bean
	 * @param rootTag
	 *            根标签
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws ParserConfigurationException
	 * @throws FactoryConfigurationError
	 * @throws XMLStreamException
	 */
	public static String toXml(Object bean, String rootTag) throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, ParserConfigurationException, XMLStreamException, FactoryConfigurationError {
		if (bean == null) {
			return null;
		}
		StringWriter result = new StringWriter(1024);
		XMLStreamWriter xsw = XMLOutputFactory.newFactory().createXMLStreamWriter(result);
		xsw.writeStartElement(rootTag);
		objectPropToNode(bean, xsw);
		xsw.writeEndElement();
		return result.toString();
	}

	/**
	 * 取自然顺序的字段列表
	 * 
	 * @param clazz
	 * @param fields
	 */
	private static void getFields(Class<?> clazz, LinkedHashMap<String, Field> fields) {
		if (!Object.class.equals(clazz.getGenericSuperclass())) {
			getFields((Class<?>) clazz.getGenericSuperclass(), fields);
		}

		Field[] dfs = clazz.getDeclaredFields();
		for (Field fld : dfs) {
			if ("class".equals(fld.getName())) {
				continue;
			}
			fields.put(fld.getName(), fld);
		}
	}

	/**
	 * 对象属性转换为xml标签
	 * 
	 * @param pd
	 * @param xml
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws XMLStreamException
	 */
	private static void objectPropToNode(Object bean, XMLStreamWriter xml)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, XMLStreamException {
		if (bean == null) {
			return;
		}

		LinkedHashMap<String, Field> fields = new LinkedHashMap<String, Field>();
		getFields(bean.getClass(), fields);
		if (fields == null || fields.isEmpty()) {
			return;
		}
		for (Entry<String, Field> fieldEntry : fields.entrySet()) {
			String name = fieldEntry.getKey();
			Object value = null;
			try {
				value = PropertyUtils.getProperty(bean, name);
			} catch (Exception ex) {
			}
			if (value == null) {// 忽略空值
				continue;
			}

			String tag = fieldEntry.getValue().isAnnotationPresent(SerializedName.class) ? name
					: StringUtils.capitalize(name);// 首字母大写做为XML标签名，注解为SerializedName的不做处理

			Class<?> type = value.getClass();
			boolean isPrimitive = type.isPrimitive() || type.isEnum() || value instanceof String
					|| value instanceof Number;// 是否基本类型boolean、byte、char、short、int、long、float
			// 和 double 或 Enum
			boolean isArray = type.isArray();// 是否数组

			if (!isArray) {// 非数组型属性
				xml.writeStartElement(tag);// 写开始标签
				if (isPrimitive) {// 基本类型直接写内容
					xml.writeCData(String.valueOf(value));
				} else {
					objectPropToNode(value, xml);// 复合类型，递归解析
				}
				xml.writeEndElement();// 写结束标签
			} else {// 数组型属性
				int length = Array.getLength(value);
				for (int i = 0; i < length; i++) {
					Object val = Array.get(value, i);
					if (val == null) {
						continue;
					}
					xml.writeStartElement(tag);// 写开始标签
					if (isPrimitive) {// 基本类型
						xml.writeCData(String.valueOf(val));
					} else {// 复合类型
						objectPropToNode(val, xml);
					}
					xml.writeEndElement();// 写结束标签
				}
			}

		}
	}

	/**
	 * 将XML转换为对象。转换规则是将PascalCase的XML标签转换为lowerCamelCase的对象属性，例如XML中UserPassword将转换为对象的userPassword属性。
	 * 支持数组，支持复合对象。 不用XStream的原因是因为微信消息的xml规律性比较统一，不需要为了复用轮子再引入一大堆类库。
	 * 
	 * @param clazz
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public <T extends Object> T toObject(Class<T> clazz)
			throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return nodesToObjectProperty(getXmlRoot().getChildNodes(), clazz);
	}

	/**
	 * 将XML转换为对象。
	 * 
	 * @param clazz
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private <T extends Object> T nodesToObjectProperty(NodeList nodes, Class<T> clazz)
			throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		if (nodes == null) {
			return null;
		}
		int length = nodes.getLength();
		if (length < 1) {
			return null;
		}

		T bean = clazz.newInstance();
		// 遍历XML节点
		for (int index = 0; index < length; index++) {
			Node node = nodes.item(index);
			if (!node.hasChildNodes()) {// 没有子节点的直接忽略，要求至少有文本内容的子节点。
				continue;
			}
			String tag = node.getNodeName();// 标签名
			if (StringUtils.isBlank(tag) || !node.hasChildNodes()) {// 无标签名则忽略
				continue;
			}
			String text = node.getTextContent();// 文本内容
			if (StringUtils.isEmpty(text)) {// 无文本内容则忽略
				continue;
			}

			// 将标签名转换为属性名，XML标签名首字母小写即可
			String prop = StringUtils.uncapitalize(tag);
			// 如果JavaBean中没有这个属性则直接忽略
			if (!PropertyUtils.isWriteable(bean, prop)) {
				continue;
			}

			// 判断当前XML节点是否为基本类型。
			boolean isSimpleType = false;
			NodeList childs = node.getChildNodes();
			if (childs.getLength() == 1 && !childs.item(0).hasChildNodes()) {// 基本类型要求当前节点只有一个文本节点。
				isSimpleType = true;
			}

			// 判断当前节点对应的属性是否为数组类型
			Class<?> propType = PropertyUtils.getPropertyType(bean, prop);// 取属性的类型
			boolean isArray = propType.isArray();// 是否数组

			// 基本类型且不是数组，直接赋值
			if (isSimpleType && !isArray) {
				BeanUtils.setProperty(bean, prop, propType.isEnum() ? textToEnum(propType, text) : text);
				continue;
			}

			// 复合类型且不是数组，创建属性对象再赋值
			if (!isSimpleType && !isArray) {
				Object propBean = nodesToObjectProperty(node.getChildNodes(), propType);// 将子节点转换为对象，递归
				BeanUtils.setProperty(bean, prop, propBean);
				continue;
			}

			// 数组属性初始化
			if (isArray && PropertyUtils.getProperty(bean, prop) == null) {
				BeanUtils.setProperty(bean, prop, Array.newInstance(propType.getComponentType(), length));
			}

			// 数组型属性，简单类型
			if (isArray && isSimpleType) {
				PropertyUtils.setIndexedProperty(bean, prop, index,
						propType.isEnum() ? textToEnum(propType, text) : text);
				continue;
			}

			// 数据型属性，复合类型
			if (isArray && !isSimpleType) {
				Object propBean = nodesToObjectProperty(node.getChildNodes(), propType.getComponentType());// 将子节点转换为对象，递归
				PropertyUtils.setIndexedProperty(bean, prop, index, propBean);// 对象属性
			}
		}

		return bean;
	}

	@SuppressWarnings("unchecked")
	private static Object textToEnum(@SuppressWarnings("rawtypes") Class clazz, String text) {
		if (StringUtils.isEmpty(text)) {
			return text;
		}
		if (!clazz.isEnum()) {
			return text;
		}
		Object val = null;
		try {
			val = Enum.valueOf(clazz, text);
		} catch (Exception e) {
			log.warn(String.format("转换%s为%s失败", text, clazz));
		}
		return val;
	}

}
