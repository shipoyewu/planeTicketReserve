package com.mps.util;



import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class Xml2JsonUtil {
	/**
	 * ת��һ��xml��ʽ���ַ�����json��ʽ
	 * 
	 * @param xml
	 *            xml��ʽ���ַ���
	 * @return �ɹ�����json ��ʽ���ַ���;ʧ�ܷ���null
	 */
	@SuppressWarnings("unchecked")
	public static  String xml2JSON(String xml) {
		JSONObject obj = new JSONObject();
		try {
			InputStream is = new ByteArrayInputStream(xml.getBytes("utf-8"));
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(is);
			Element root = doc.getRootElement();
			obj.put(root.getName(), iterateElement(root));
			return obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ת��һ��xml��ʽ���ַ�����json��ʽ
	 * 
	 * @param file
	 *            java.io.Fileʵ����һ����Ч��xml�ļ�
	 * @return �ɹ�����json ��ʽ���ַ���;ʧ�ܷ���null
	 */
	@SuppressWarnings("unchecked")
	public static String xml2JSON(File file) {
		JSONObject obj = new JSONObject();
		try {
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(file);
			Element root = doc.getRootElement();
			obj.put(root.getName(), iterateElement(root));
			return obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * һ����������
	 * 
	 * @param element
	 *            : org.jdom.Element
	 * @return java.util.Map ʵ��
	 */
	@SuppressWarnings("unchecked")
	private static Map  iterateElement(Element element) {
		List jiedian = element.getChildren();
		Element et = null;
		Map obj = new HashMap();
		List list = null;
		for (int i = 0; i < jiedian.size(); i++) {
			list = new LinkedList();
			et = (Element) jiedian.get(i);
			if (et.getTextTrim().equals("")) {
				if (et.getChildren().size() == 0)
					continue;
				if (obj.containsKey(et.getName())) {
					list = (List) obj.get(et.getName());
				}
				list.add(iterateElement(et));
				obj.put(et.getName(), list);
			} else {
				if (obj.containsKey(et.getName())) {
					list = (List) obj.get(et.getName());
				}
				list.add(et.getTextTrim());
				obj.put(et.getName(), list);
			}
		}
		return obj;
	}

	// ����
	public static void main(String[] args) {
		System.out.println(  Xml2JsonUtil.xml2JSON("<MapSet>"
				+ "<MapGroup id='Sheboygan'>" + "<Map>"
				+ "<Type>MapGuideddddddd</Type>"
				+ "<SingleTile>true</SingleTile>" + "<Extension>"
				+ "<ResourceId>ddd</ResourceId>" + "</Extension>" + "</Map>"
				+ "<Map>" + "<Type>ccc</Type>" + "<SingleTile>ggg</SingleTile>"
				+ "<Extension>" + "<ResourceId>aaa</ResourceId>"
				+ "</Extension>" + "</Map>" + "<Extension />" + "</MapGroup>"
				+ "<ddd>" + "33333333" + "</ddd>" + "<ddd>" + "444" + "</ddd>"
				+ "</MapSet>"));
	}
}