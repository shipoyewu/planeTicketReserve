
package com.mps.airline;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getDomesticAirlinesTimeResult" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getDomesticAirlinesTimeResult"
})
@XmlRootElement(name = "getDomesticAirlinesTimeResponse")
public class GetDomesticAirlinesTimeResponse {

    protected GetDomesticAirlinesTimeResponse.GetDomesticAirlinesTimeResult getDomesticAirlinesTimeResult;

    /**
     * ��ȡgetDomesticAirlinesTimeResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GetDomesticAirlinesTimeResponse.GetDomesticAirlinesTimeResult }
     *     
     */
    public GetDomesticAirlinesTimeResponse.GetDomesticAirlinesTimeResult getGetDomesticAirlinesTimeResult() {
        return getDomesticAirlinesTimeResult;
    }

    /**
     * ����getDomesticAirlinesTimeResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GetDomesticAirlinesTimeResponse.GetDomesticAirlinesTimeResult }
     *     
     */
    public void setGetDomesticAirlinesTimeResult(GetDomesticAirlinesTimeResponse.GetDomesticAirlinesTimeResult value) {
        this.getDomesticAirlinesTimeResult = value;
    }


    /**
     * <p>anonymous complex type�� Java �ࡣ
     * 
     * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class GetDomesticAirlinesTimeResult {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * ��ȡany���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getAny() {
            return any;
        }

        /**
         * ����any���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }

}
