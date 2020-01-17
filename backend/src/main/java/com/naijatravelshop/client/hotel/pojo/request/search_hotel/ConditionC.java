package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Bruno on
 * 31/08/2019
 */
@Data
@XmlRootElement(name = "c:condition")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConditionC {
    @XmlElement(name = "a:condition")
    private ConditionA conditionA;
}
