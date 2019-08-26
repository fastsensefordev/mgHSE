
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ChannelInfoGetHostListResponseChannelInfoGetHostListResult_QNAME = new QName("http://tempuri.org/", "ChannelInfo_GetHostListResult");
    private final static QName _CounterGetRecordCountStrWhere_QNAME = new QName("http://tempuri.org/", "strWhere");
    private final static QName _CounterGetYear12MonthFlowCounterDataResponseCounterGetYear12MonthFlowCounterDataResult_QNAME = new QName("http://tempuri.org/", "Counter_GetYear12MonthFlowCounterDataResult");
    private final static QName _CounterGetYear12MonthFlowCounterDataByEventTypeAlarmEventType_QNAME = new QName("http://tempuri.org/", "alarmEventType");
    private final static QName _CounterGetYear12MonthFlowCounterDataByEventTypeResponseCounterGetYear12MonthFlowCounterDataByEventTypeResult_QNAME = new QName("http://tempuri.org/", "Counter_GetYear12MonthFlowCounterDataByEventTypeResult");
    private final static QName _AlarmInfoGetModelResponseAlarmInfoGetModelResult_QNAME = new QName("http://tempuri.org/", "AlarmInfo_GetModelResult");
    private final static QName _AlarmInfoGetLastListTopNumResponseAlarmInfoGetLastListTopNumResult_QNAME = new QName("http://tempuri.org/", "AlarmInfo_GetLastListTopNumResult");
    private final static QName _AlarmInfoGetRecordListResponseAlarmInfoGetRecordListResult_QNAME = new QName("http://tempuri.org/", "AlarmInfo_GetRecordListResult");
    private final static QName _GetFileBytesForBase64FilePath_QNAME = new QName("http://tempuri.org/", "filePath");
    private final static QName _GetFileBytesForBase64ResponseGetFileBytesForBase64Result_QNAME = new QName("http://tempuri.org/", "GetFileBytesForBase64Result");
    private final static QName _GetChannelDetectObjsResponseGetChannelDetectObjsResult_QNAME = new QName("http://tempuri.org/", "GetChannelDetectObjsResult");
    private final static QName _GetRuleInfoByHostIdResponseGetRuleInfoByHostIdResult_QNAME = new QName("http://tempuri.org/", "GetRuleInfoByHostIdResult");
    private final static QName _GetChannelHostInfoResponseGetChannelHostInfoResult_QNAME = new QName("http://tempuri.org/", "GetChannelHostInfoResult");
    private final static QName _UpdateChannelHostInfoJson_QNAME = new QName("http://tempuri.org/", "json");
    private final static QName _SetChannelHostRtspRtsp_QNAME = new QName("http://tempuri.org/", "rtsp");
    private final static QName _GetChannelHostRtspResponseGetChannelHostRtspResult_QNAME = new QName("http://tempuri.org/", "GetChannelHost_RtspResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DoWork }
     * 
     */
    public DoWork createDoWork() {
        return new DoWork();
    }

    /**
     * Create an instance of {@link DoWorkResponse }
     * 
     */
    public DoWorkResponse createDoWorkResponse() {
        return new DoWorkResponse();
    }

    /**
     * Create an instance of {@link ChannelInfoGetHostList }
     * 
     */
    public ChannelInfoGetHostList createChannelInfoGetHostList() {
        return new ChannelInfoGetHostList();
    }

    /**
     * Create an instance of {@link ChannelInfoGetHostListResponse }
     * 
     */
    public ChannelInfoGetHostListResponse createChannelInfoGetHostListResponse() {
        return new ChannelInfoGetHostListResponse();
    }

    /**
     * Create an instance of {@link CounterGetRecordCount }
     * 
     */
    public CounterGetRecordCount createCounterGetRecordCount() {
        return new CounterGetRecordCount();
    }

    /**
     * Create an instance of {@link CounterGetRecordCountResponse }
     * 
     */
    public CounterGetRecordCountResponse createCounterGetRecordCountResponse() {
        return new CounterGetRecordCountResponse();
    }

    /**
     * Create an instance of {@link CounterGetYear12MonthFlowCounterData }
     * 
     */
    public CounterGetYear12MonthFlowCounterData createCounterGetYear12MonthFlowCounterData() {
        return new CounterGetYear12MonthFlowCounterData();
    }

    /**
     * Create an instance of {@link CounterGetYear12MonthFlowCounterDataResponse }
     * 
     */
    public CounterGetYear12MonthFlowCounterDataResponse createCounterGetYear12MonthFlowCounterDataResponse() {
        return new CounterGetYear12MonthFlowCounterDataResponse();
    }

    /**
     * Create an instance of {@link CounterGetYear12MonthFlowCounterDataByEventType }
     * 
     */
    public CounterGetYear12MonthFlowCounterDataByEventType createCounterGetYear12MonthFlowCounterDataByEventType() {
        return new CounterGetYear12MonthFlowCounterDataByEventType();
    }

    /**
     * Create an instance of {@link CounterGetYear12MonthFlowCounterDataByEventTypeResponse }
     * 
     */
    public CounterGetYear12MonthFlowCounterDataByEventTypeResponse createCounterGetYear12MonthFlowCounterDataByEventTypeResponse() {
        return new CounterGetYear12MonthFlowCounterDataByEventTypeResponse();
    }

    /**
     * Create an instance of {@link AlarmInfoGetRecordCount }
     * 
     */
    public AlarmInfoGetRecordCount createAlarmInfoGetRecordCount() {
        return new AlarmInfoGetRecordCount();
    }

    /**
     * Create an instance of {@link AlarmInfoGetRecordCountResponse }
     * 
     */
    public AlarmInfoGetRecordCountResponse createAlarmInfoGetRecordCountResponse() {
        return new AlarmInfoGetRecordCountResponse();
    }

    /**
     * Create an instance of {@link AlarmInfoGetModel }
     * 
     */
    public AlarmInfoGetModel createAlarmInfoGetModel() {
        return new AlarmInfoGetModel();
    }

    /**
     * Create an instance of {@link AlarmInfoGetModelResponse }
     * 
     */
    public AlarmInfoGetModelResponse createAlarmInfoGetModelResponse() {
        return new AlarmInfoGetModelResponse();
    }

    /**
     * Create an instance of {@link AlarmInfoGetLastListTopNum }
     * 
     */
    public AlarmInfoGetLastListTopNum createAlarmInfoGetLastListTopNum() {
        return new AlarmInfoGetLastListTopNum();
    }

    /**
     * Create an instance of {@link AlarmInfoGetLastListTopNumResponse }
     * 
     */
    public AlarmInfoGetLastListTopNumResponse createAlarmInfoGetLastListTopNumResponse() {
        return new AlarmInfoGetLastListTopNumResponse();
    }

    /**
     * Create an instance of {@link AlarmInfoGetRecordList }
     * 
     */
    public AlarmInfoGetRecordList createAlarmInfoGetRecordList() {
        return new AlarmInfoGetRecordList();
    }

    /**
     * Create an instance of {@link AlarmInfoGetRecordListResponse }
     * 
     */
    public AlarmInfoGetRecordListResponse createAlarmInfoGetRecordListResponse() {
        return new AlarmInfoGetRecordListResponse();
    }

    /**
     * Create an instance of {@link GetFileBytesForBase64 }
     * 
     */
    public GetFileBytesForBase64 createGetFileBytesForBase64() {
        return new GetFileBytesForBase64();
    }

    /**
     * Create an instance of {@link GetFileBytesForBase64Response }
     * 
     */
    public GetFileBytesForBase64Response createGetFileBytesForBase64Response() {
        return new GetFileBytesForBase64Response();
    }

    /**
     * Create an instance of {@link GetChannelDetectObjs }
     * 
     */
    public GetChannelDetectObjs createGetChannelDetectObjs() {
        return new GetChannelDetectObjs();
    }

    /**
     * Create an instance of {@link GetChannelDetectObjsResponse }
     * 
     */
    public GetChannelDetectObjsResponse createGetChannelDetectObjsResponse() {
        return new GetChannelDetectObjsResponse();
    }

    /**
     * Create an instance of {@link GetRuleInfoByHostId }
     * 
     */
    public GetRuleInfoByHostId createGetRuleInfoByHostId() {
        return new GetRuleInfoByHostId();
    }

    /**
     * Create an instance of {@link GetRuleInfoByHostIdResponse }
     * 
     */
    public GetRuleInfoByHostIdResponse createGetRuleInfoByHostIdResponse() {
        return new GetRuleInfoByHostIdResponse();
    }

    /**
     * Create an instance of {@link GetChannelHostInfo }
     * 
     */
    public GetChannelHostInfo createGetChannelHostInfo() {
        return new GetChannelHostInfo();
    }

    /**
     * Create an instance of {@link GetChannelHostInfoResponse }
     * 
     */
    public GetChannelHostInfoResponse createGetChannelHostInfoResponse() {
        return new GetChannelHostInfoResponse();
    }

    /**
     * Create an instance of {@link UpdateChannelHostInfo }
     * 
     */
    public UpdateChannelHostInfo createUpdateChannelHostInfo() {
        return new UpdateChannelHostInfo();
    }

    /**
     * Create an instance of {@link UpdateChannelHostInfoResponse }
     * 
     */
    public UpdateChannelHostInfoResponse createUpdateChannelHostInfoResponse() {
        return new UpdateChannelHostInfoResponse();
    }

    /**
     * Create an instance of {@link ReStartupApp }
     * 
     */
    public ReStartupApp createReStartupApp() {
        return new ReStartupApp();
    }

    /**
     * Create an instance of {@link ReStartupAppResponse }
     * 
     */
    public ReStartupAppResponse createReStartupAppResponse() {
        return new ReStartupAppResponse();
    }

    /**
     * Create an instance of {@link SetChannelHostRtsp }
     * 
     */
    public SetChannelHostRtsp createSetChannelHostRtsp() {
        return new SetChannelHostRtsp();
    }

    /**
     * Create an instance of {@link SetChannelHostRtspResponse }
     * 
     */
    public SetChannelHostRtspResponse createSetChannelHostRtspResponse() {
        return new SetChannelHostRtspResponse();
    }

    /**
     * Create an instance of {@link GetChannelHostRtsp }
     * 
     */
    public GetChannelHostRtsp createGetChannelHostRtsp() {
        return new GetChannelHostRtsp();
    }

    /**
     * Create an instance of {@link GetChannelHostRtspResponse }
     * 
     */
    public GetChannelHostRtspResponse createGetChannelHostRtspResponse() {
        return new GetChannelHostRtspResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ChannelInfo_GetHostListResult", scope = ChannelInfoGetHostListResponse.class)
    public JAXBElement<String> createChannelInfoGetHostListResponseChannelInfoGetHostListResult(String value) {
        return new JAXBElement<String>(_ChannelInfoGetHostListResponseChannelInfoGetHostListResult_QNAME, String.class, ChannelInfoGetHostListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "strWhere", scope = CounterGetRecordCount.class)
    public JAXBElement<String> createCounterGetRecordCountStrWhere(String value) {
        return new JAXBElement<String>(_CounterGetRecordCountStrWhere_QNAME, String.class, CounterGetRecordCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Counter_GetYear12MonthFlowCounterDataResult", scope = CounterGetYear12MonthFlowCounterDataResponse.class)
    public JAXBElement<ArrayOfdouble> createCounterGetYear12MonthFlowCounterDataResponseCounterGetYear12MonthFlowCounterDataResult(ArrayOfdouble value) {
        return new JAXBElement<ArrayOfdouble>(_CounterGetYear12MonthFlowCounterDataResponseCounterGetYear12MonthFlowCounterDataResult_QNAME, ArrayOfdouble.class, CounterGetYear12MonthFlowCounterDataResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "alarmEventType", scope = CounterGetYear12MonthFlowCounterDataByEventType.class)
    public JAXBElement<String> createCounterGetYear12MonthFlowCounterDataByEventTypeAlarmEventType(String value) {
        return new JAXBElement<String>(_CounterGetYear12MonthFlowCounterDataByEventTypeAlarmEventType_QNAME, String.class, CounterGetYear12MonthFlowCounterDataByEventType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "Counter_GetYear12MonthFlowCounterDataByEventTypeResult", scope = CounterGetYear12MonthFlowCounterDataByEventTypeResponse.class)
    public JAXBElement<ArrayOfdouble> createCounterGetYear12MonthFlowCounterDataByEventTypeResponseCounterGetYear12MonthFlowCounterDataByEventTypeResult(ArrayOfdouble value) {
        return new JAXBElement<ArrayOfdouble>(_CounterGetYear12MonthFlowCounterDataByEventTypeResponseCounterGetYear12MonthFlowCounterDataByEventTypeResult_QNAME, ArrayOfdouble.class, CounterGetYear12MonthFlowCounterDataByEventTypeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "strWhere", scope = AlarmInfoGetRecordCount.class)
    public JAXBElement<String> createAlarmInfoGetRecordCountStrWhere(String value) {
        return new JAXBElement<String>(_CounterGetRecordCountStrWhere_QNAME, String.class, AlarmInfoGetRecordCount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "AlarmInfo_GetModelResult", scope = AlarmInfoGetModelResponse.class)
    public JAXBElement<String> createAlarmInfoGetModelResponseAlarmInfoGetModelResult(String value) {
        return new JAXBElement<String>(_AlarmInfoGetModelResponseAlarmInfoGetModelResult_QNAME, String.class, AlarmInfoGetModelResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "AlarmInfo_GetLastListTopNumResult", scope = AlarmInfoGetLastListTopNumResponse.class)
    public JAXBElement<String> createAlarmInfoGetLastListTopNumResponseAlarmInfoGetLastListTopNumResult(String value) {
        return new JAXBElement<String>(_AlarmInfoGetLastListTopNumResponseAlarmInfoGetLastListTopNumResult_QNAME, String.class, AlarmInfoGetLastListTopNumResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "strWhere", scope = AlarmInfoGetRecordList.class)
    public JAXBElement<String> createAlarmInfoGetRecordListStrWhere(String value) {
        return new JAXBElement<String>(_CounterGetRecordCountStrWhere_QNAME, String.class, AlarmInfoGetRecordList.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "AlarmInfo_GetRecordListResult", scope = AlarmInfoGetRecordListResponse.class)
    public JAXBElement<String> createAlarmInfoGetRecordListResponseAlarmInfoGetRecordListResult(String value) {
        return new JAXBElement<String>(_AlarmInfoGetRecordListResponseAlarmInfoGetRecordListResult_QNAME, String.class, AlarmInfoGetRecordListResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "filePath", scope = GetFileBytesForBase64 .class)
    public JAXBElement<String> createGetFileBytesForBase64FilePath(String value) {
        return new JAXBElement<String>(_GetFileBytesForBase64FilePath_QNAME, String.class, GetFileBytesForBase64 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetFileBytesForBase64Result", scope = GetFileBytesForBase64Response.class)
    public JAXBElement<String> createGetFileBytesForBase64ResponseGetFileBytesForBase64Result(String value) {
        return new JAXBElement<String>(_GetFileBytesForBase64ResponseGetFileBytesForBase64Result_QNAME, String.class, GetFileBytesForBase64Response.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetChannelDetectObjsResult", scope = GetChannelDetectObjsResponse.class)
    public JAXBElement<String> createGetChannelDetectObjsResponseGetChannelDetectObjsResult(String value) {
        return new JAXBElement<String>(_GetChannelDetectObjsResponseGetChannelDetectObjsResult_QNAME, String.class, GetChannelDetectObjsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetRuleInfoByHostIdResult", scope = GetRuleInfoByHostIdResponse.class)
    public JAXBElement<String> createGetRuleInfoByHostIdResponseGetRuleInfoByHostIdResult(String value) {
        return new JAXBElement<String>(_GetRuleInfoByHostIdResponseGetRuleInfoByHostIdResult_QNAME, String.class, GetRuleInfoByHostIdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetChannelHostInfoResult", scope = GetChannelHostInfoResponse.class)
    public JAXBElement<String> createGetChannelHostInfoResponseGetChannelHostInfoResult(String value) {
        return new JAXBElement<String>(_GetChannelHostInfoResponseGetChannelHostInfoResult_QNAME, String.class, GetChannelHostInfoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "json", scope = UpdateChannelHostInfo.class)
    public JAXBElement<String> createUpdateChannelHostInfoJson(String value) {
        return new JAXBElement<String>(_UpdateChannelHostInfoJson_QNAME, String.class, UpdateChannelHostInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "rtsp", scope = SetChannelHostRtsp.class)
    public JAXBElement<String> createSetChannelHostRtspRtsp(String value) {
        return new JAXBElement<String>(_SetChannelHostRtspRtsp_QNAME, String.class, SetChannelHostRtsp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetChannelHost_RtspResult", scope = GetChannelHostRtspResponse.class)
    public JAXBElement<String> createGetChannelHostRtspResponseGetChannelHostRtspResult(String value) {
        return new JAXBElement<String>(_GetChannelHostRtspResponseGetChannelHostRtspResult_QNAME, String.class, GetChannelHostRtspResponse.class, value);
    }

}
