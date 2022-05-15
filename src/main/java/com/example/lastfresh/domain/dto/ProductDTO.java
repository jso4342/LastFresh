package com.example.lastfresh.domain.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class ProductDTO {
    private Long sellProductNum;
    private Long sellProductCategory;
    private String sellProductName;
    private Long sellProductOriginPrice;
    private Long sellProductDiscountPrice;
    private Date sellProductExpireDay;
    private long sellProductStock;
    private String sellProductPickup;
    /*0배달x, 1프레쉬라이더, 2자가라이더*/
    private String sellProductDelivery;
    private String sellProductDeliveryAddress1;
    private String sellProductDeliveryAddress2;
    private String sellProductDeliveryAddress3;
    /*0배달x, 1프레쉬라이더, 2자가라이더*/
    private String sellProductShipping;
    private String sellProductAddress;
    private String sellProductAddressDetail;
    private String sellProductAddressPostNum;
    private String sellProductDescription;
    private String sellProductPhoneNum;
    private String sellProductThumbnail;
    private String sellProductImage;
    private String sellProductImageUploadPath;
    private String sellProductImageUuid;
}
