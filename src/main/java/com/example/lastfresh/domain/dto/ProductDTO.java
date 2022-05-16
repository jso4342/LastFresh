package com.example.lastfresh.domain.dto;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ToString()
@Getter
public class ProductDTO {
    private Long sellProductCategory;

    private String sellProductName;

    private Long sellProductOriginPrice;

    private Long sellProductDiscountPrice;

    private Date sellProductExpireDay;

    private Long sellProductStock;

    private String sellProductPickup;

    private String sellProductDelivery;  // 0배달x, 1프레쉬라이더, 2자가라이더

    private String sellProductDeliveryAddress1;

    private String sellProductDeliveryAddress2;

    private String sellProductDeliveryAddress3;

    private String sellProductShipping;  // 0배달x, 1프레쉬라이더, 2자가라이더

    private String sellProductAddress;

    private String sellProductAddressDetail;

    private String sellProductAddressPostNum;

    private String sellProductDescription;

    private String sellProductPhoneNum;
}
