package com.naijatravelshop.client.hotel.pojo.request.search_hotel;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Bruno on
 * 15/08/2019
 */
@Data
@XmlRootElement(name = "fieldValues")
public class FieldValues implements Serializable {
    List<String> fieldValue;
}
