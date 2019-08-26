
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfdouble;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Counter_GetYear12MonthFlowCounterDataResult" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfdouble" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "counterGetYear12MonthFlowCounterDataResult"
})
@XmlRootElement(name = "Counter_GetYear12MonthFlowCounterDataResponse")
public class CounterGetYear12MonthFlowCounterDataResponse {

    @XmlElementRef(name = "Counter_GetYear12MonthFlowCounterDataResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfdouble> counterGetYear12MonthFlowCounterDataResult;

    /**
     * 获取counterGetYear12MonthFlowCounterDataResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     *     
     */
    public JAXBElement<ArrayOfdouble> getCounterGetYear12MonthFlowCounterDataResult() {
        return counterGetYear12MonthFlowCounterDataResult;
    }

    /**
     * 设置counterGetYear12MonthFlowCounterDataResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfdouble }{@code >}
     *     
     */
    public void setCounterGetYear12MonthFlowCounterDataResult(JAXBElement<ArrayOfdouble> value) {
        this.counterGetYear12MonthFlowCounterDataResult = value;
    }

}
