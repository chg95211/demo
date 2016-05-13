package com.chj.constants;

import java.io.File;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public class Constants {
	
	public final static String USER_TYPE_SUBSCRIBER = "SUBSCRIBER";
	public final static String USER_TYPE_VISITOR = "VISITOR";

	public final static String MEDIA_TYPE = "text/xml; charset=utf-8";
	public static final String REST_APPLICATION_JSON = "application/json; charset=utf-8";
	
	public final static Source xsltLockDoorsSource;
	public final static Source xsltUnLockDoorsSource;
	public final static Source xsltVehicleAlertSource;
	public final static Source xsltRemoteStartSource;
	public final static Source xsltRemoteStopSource;

	public final static Source xsltSendToTBTSource;
	public final static Source xsltSendToNAVSource;

	public final static Source xsltGetVehicleDataSource;
	public final static Source xsltGetVehicleLocationSource;
	
	public final static Source xslGetRequestStatusesRequestSource;
	public final static Source xslGetRequestStatusesResponseSource;

	public final static Source xsltGetRequestResultRequestSource;
	public final static Source xsltGetRequestResultResponseSource;

	public final static Source xsltGetSubscriberInfoRequestSource;
	public final static Source xsltGetSubscriberInfoResponseSource;
	
	public final static Source xsltGetAppSessionKeyRequestSource;
	public final static Source xsltGetAppSessionKeyResponseSource;

	public final static Source xsltServiceResponseSource;
	
	//wifi
	public final static Source xsltGetHotspotInfoSource;
	public final static Source xsltEnableHotspotSource;
	public final static Source xsltDisableHotspotSource;
	public final static Source xsltSetHotspotInfoSource;
	public final static Source xsltGetHotspotStatusRequestSource;
	public final static Source xsltGetHotspotStatusResponseSource;

	
	static {
		xsltLockDoorsSource = new StreamSource(new File(Constants.class
				.getResource("/").getPath()
				+ "/xsl/LockDoorsRequestXMLToSOAP.xsl"));

		xsltUnLockDoorsSource = new StreamSource(new File(Constants.class
				.getResource("/").getPath()
				+ "/xsl/UnLockDoorsRequestXMLToSOAP.xsl"));

		xsltVehicleAlertSource = new StreamSource(new File(Constants.class
				.getResource("/").getPath()
				+ "/xsl/VehicleAlertRequestXMLToSOAP.xsl"));

		xsltRemoteStartSource = new StreamSource(new File(Constants.class
				.getResource("/").getPath()
				+ "/xsl/RemoteStartRequestXMLToSOAP.xsl"));

		xsltRemoteStopSource = new StreamSource(new File(Constants.class
				.getResource("/").getPath()
				+ "/xsl/RemoteStopRequestXMLToSOAP.xsl"));

		xsltSendToTBTSource = new StreamSource(new File(Constants.class
				.getResource("/").getPath()
				+ "/xsl/SendToTBTRequestXMLToSOAP.xsl"));

		xsltSendToNAVSource = new StreamSource(new File(Constants.class
				.getResource("/").getPath()
				+ "/xsl/SendToNAVRequestXMLToSOAP.xsl"));

		xsltGetVehicleDataSource = new StreamSource(new File(Constants.class
				.getResource("/").getPath()
				+ "/xsl/GetVehicleDataRequestXMLToSOAP.xsl"));

		xsltGetVehicleLocationSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/GetVehicleLocationRequestXMLToSOAP.xsl"));

		xsltGetRequestResultRequestSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/GetRequestResultRequestXMLToSOAP.xsl"));

		xsltGetRequestResultResponseSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/GetRequestResultResponseSOAPToXML.xsl"));

		xslGetRequestStatusesRequestSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/GetRequestStatusesRequestXMLToSOAP.xsl"));

		xslGetRequestStatusesResponseSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/GetRequestStatusesResponseSOAPToXML.xsl"));
		
		xsltGetSubscriberInfoRequestSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/GetSubscriberInfoRequestXMLToSOAP.xsl"));

		xsltGetSubscriberInfoResponseSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/GetSubscriberInfoResponseSOAPToXML.xsl"));

		xsltGetAppSessionKeyRequestSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/GetAppSessionKeyRequestSOAPToXML.xsl"));

		xsltGetAppSessionKeyResponseSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/GetAppSessionKeyResponseSOAPToXML.xsl"));

		xsltServiceResponseSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/ServiceResponseSOAPToXML.xsl"));
		
		//wifi
		xsltGetHotspotInfoSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/GetHotspotInfoXMLToSOAP.xsl"));

		xsltEnableHotspotSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/EnableHotspotXMLToSOAP.xsl"));

		xsltDisableHotspotSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/DisableHotspotXMLToSOAP.xsl"));

		xsltSetHotspotInfoSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/SetHotspotInfoXMLToSOAP.xsl"));

		xsltGetHotspotStatusRequestSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/GetHotspotStatusRequestXMLToSOAP.xsl"));
		
		xsltGetHotspotStatusResponseSource = new StreamSource(new File(
				Constants.class.getResource("/").getPath()
						+ "/xsl/GetHotspotStatusResponseSOAPToXML.xsl"));

	}

}
