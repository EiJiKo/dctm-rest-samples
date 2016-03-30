
package com.emc.d2fs.models.context;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.emc.d2fs.models.location.NetworkLocation;
import com.emc.d2fs.models.repository.Repository;


/**
 * <p>Java class for context complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="context"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="repository" type="{http://www.emc.com/d2fs/models/repository}repository" minOccurs="0"/&gt;
 *         &lt;element name="networkLocation" type="{http://www.emc.com/d2fs/models/location}network_location" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *       &lt;attribute name="uid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="parentUid" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="login" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="userName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="password" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="domain" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="locale" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="webAppURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;attribute name="clientIp" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="clientHostName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="clientMode" type="{http://www.w3.org/2001/XMLSchema}int" default="0" /&gt;
 *       &lt;attribute name="creationTime" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *       &lt;attribute name="sso" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="widgetName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="widgetType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="userArg1" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="binaryCredential" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "context", propOrder = {

})
public class Context {

    protected Repository repository;
    protected NetworkLocation networkLocation;
    @XmlAttribute(name = "uid", required = true)
    protected String uid;
    @XmlAttribute(name = "parentUid")
    protected String parentUid;
    @XmlAttribute(name = "login", required = true)
    protected String login;
    @XmlAttribute(name = "userName")
    protected String userName;
    @XmlAttribute(name = "password")
    protected String password;
    @XmlAttribute(name = "domain")
    protected String domain;
    @XmlAttribute(name = "locale")
    protected String locale;
    @XmlAttribute(name = "webAppURL")
    @XmlSchemaType(name = "anyURI")
    protected String webAppURL;
    @XmlAttribute(name = "clientIp")
    protected String clientIp;
    @XmlAttribute(name = "clientHostName")
    protected String clientHostName;
    @XmlAttribute(name = "clientMode")
    protected Integer clientMode;
    @XmlAttribute(name = "creationTime")
    protected Long creationTime;
    @XmlAttribute(name = "sso")
    protected Boolean sso;
    @XmlAttribute(name = "widgetName")
    protected String widgetName;
    @XmlAttribute(name = "widgetType")
    protected String widgetType;
    @XmlAttribute(name = "userArg1")
    protected String userArg1;
    @XmlAttribute(name = "binaryCredential")
    @XmlSchemaType(name = "anySimpleType")
    protected String binaryCredential;

    /**
     * Gets the value of the repository property.
     * 
     * @return
     *     possible object is
     *     {@link Repository }
     *     
     */
    public Repository getRepository() {
        return repository;
    }

    /**
     * Sets the value of the repository property.
     * 
     * @param value
     *     allowed object is
     *     {@link Repository }
     *     
     */
    public void setRepository(Repository value) {
        this.repository = value;
    }

    /**
     * Gets the value of the networkLocation property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkLocation }
     *     
     */
    public NetworkLocation getNetworkLocation() {
        return networkLocation;
    }

    /**
     * Sets the value of the networkLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkLocation }
     *     
     */
    public void setNetworkLocation(NetworkLocation value) {
        this.networkLocation = value;
    }

    /**
     * Gets the value of the uid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
    }

    /**
     * Gets the value of the parentUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentUid() {
        return parentUid;
    }

    /**
     * Sets the value of the parentUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentUid(String value) {
        this.parentUid = value;
    }

    /**
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the domain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomain(String value) {
        this.domain = value;
    }

    /**
     * Gets the value of the locale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Sets the value of the locale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocale(String value) {
        this.locale = value;
    }

    /**
     * Gets the value of the webAppURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebAppURL() {
        return webAppURL;
    }

    /**
     * Sets the value of the webAppURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebAppURL(String value) {
        this.webAppURL = value;
    }

    /**
     * Gets the value of the clientIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * Sets the value of the clientIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientIp(String value) {
        this.clientIp = value;
    }

    /**
     * Gets the value of the clientHostName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientHostName() {
        return clientHostName;
    }

    /**
     * Sets the value of the clientHostName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientHostName(String value) {
        this.clientHostName = value;
    }

    /**
     * Gets the value of the clientMode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getClientMode() {
        if (clientMode == null) {
            return  0;
        } else {
            return clientMode;
        }
    }

    /**
     * Sets the value of the clientMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setClientMode(Integer value) {
        this.clientMode = value;
    }

    /**
     * Gets the value of the creationTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the value of the creationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCreationTime(Long value) {
        this.creationTime = value;
    }

    /**
     * Gets the value of the sso property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSso() {
        return sso;
    }

    /**
     * Sets the value of the sso property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSso(Boolean value) {
        this.sso = value;
    }

    /**
     * Gets the value of the widgetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidgetName() {
        return widgetName;
    }

    /**
     * Sets the value of the widgetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidgetName(String value) {
        this.widgetName = value;
    }

    /**
     * Gets the value of the widgetType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidgetType() {
        return widgetType;
    }

    /**
     * Sets the value of the widgetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidgetType(String value) {
        this.widgetType = value;
    }

    /**
     * Gets the value of the userArg1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserArg1() {
        return userArg1;
    }

    /**
     * Sets the value of the userArg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserArg1(String value) {
        this.userArg1 = value;
    }

    /**
     * Gets the value of the binaryCredential property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBinaryCredential() {
        return binaryCredential;
    }

    /**
     * Sets the value of the binaryCredential property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBinaryCredential(String value) {
        this.binaryCredential = value;
    }

}
