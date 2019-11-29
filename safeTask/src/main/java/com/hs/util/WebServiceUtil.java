package com.hs.util;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class WebServiceUtil {

	/**
	 * 获取记录数
	 * @desc: AIRobot
	 * @author: kpchen
	 * @createTime: 2019年9月7日 上午11:50:12
	 * @history:
	 * @param year
	 * @param month
	 * @param day
	 * @param strWhere
	 * @return String
	 * @throws ServiceException 
	 * @throws RemoteException 
	 */
	public static String getRecordList(String address,String year, String month, String day, String strWhere) throws ServiceException, RemoteException {
		String url = address + "/VasWebService/?singlewsdl";
		String namespace = "http://tempuri.org/";
		Service service = new Service();
		Call call = (Call) service.createCall();
		QName qname = new QName(namespace, "AlarmInfo_GetRecordList"); // 设置命名空间和需要调用的方法名
		call.setOperationName(qname);
		call.setTargetEndpointAddress(url);
		call.setSOAPActionURI(namespace + "IVasWebService/AlarmInfo_GetRecordList");
		call.addParameter(new QName(namespace, "year"), org.apache.axis.encoding.XMLType.XSD_STRING,
				javax.xml.rpc.ParameterMode.IN);// 接口的参数
		call.addParameter(new QName(namespace, "month"), org.apache.axis.encoding.XMLType.XSD_STRING,
				javax.xml.rpc.ParameterMode.IN);// 接口的参数
		call.addParameter(new QName(namespace, "day"), org.apache.axis.encoding.XMLType.XSD_STRING,
				javax.xml.rpc.ParameterMode.IN);// 接口的参数
		call.addParameter(new QName(namespace, "strWhere"), org.apache.axis.encoding.XMLType.XSD_STRING,
				javax.xml.rpc.ParameterMode.IN);// 接口的参数
		call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
		String result = (String) call.invoke(new Object[] { year, month, day, strWhere });
		return result;
	}
	
	/*
	 * public static void main(String[] args) throws RemoteException,
	 * ServiceException { String serveAddress = "http://172.23.35.203:8733"; String
	 * result = WebServiceUtil.getRecordList(serveAddress, "2019", "9", "7",
	 * "ID> 0 order by ID ASC limit 10"); System.out.println(result); }
	 */
}
