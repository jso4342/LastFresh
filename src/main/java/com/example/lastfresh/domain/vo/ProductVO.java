package com.example.lastfresh.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Entity
@Table(name = "TBL_SELL_PRODUCT")
@Getter
@Setter
@ToString( exclude = "userVO")
@AllArgsConstructor
public class ProductVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SELL_PRODUCT_NUM")
    private Long sellProductNum;

    @Column(name = "SELL_PRODUCT_CATEGORY")
    private Long sellProductCategory;

    @Column(name = "SELL_PRODUCT_NAME")
    private String sellProductName;

    @Column(name = "SELL_PRODUCT_ORIGIN_PRICE")
    private Long sellProductOriginPrice;

    @Column(name = "SELL_PRODUCT_DISCOUNT_PRICE")
    private Long sellProductDiscountPrice;

    @Column(name = "SELL_PRODUCT_EXPIRE_DATE")
    private String sellProductExpireDay;

    @Column(name = "SELL_PRODUCT_STOCK")
    private Long sellProductStock;

    @Column(name = "SELL_PRODUCT_STATUS")
    private String sellProductStatus = "0"; // 0판매가능, -1 판매 불가

    @Column(name = "SELL_PRODUCT_PICKUP")
    private String sellProductPickup;

    @Column(name = "SELL_PRODUCT_DELIVERY_METHOD")
    private String sellProductDelivery; // 0배달x, 1프레쉬라이더, 2자가라이더

    @Column(name = "SELL_PRODUCT_DELIVERY_ADDRESS1")
    private String sellProductDeliveryAddress1;

    @Column(name = "SELL_PRODUCT_DELIVERY_ADDRESS2")
    private String sellProductDeliveryAddress2;

    @Column(name = "SELL_PRODUCT_DELIVERY_ADDRESS3")
    private String sellProductDeliveryAddress3;

    @Column(name = "SELL_PRODUCT_SHIPPING_METHOD")
    private String sellProductShipping; // 0배달x, 1프레쉬라이더, 2자가라이더

    @Column(name = "SELL_PRODUCT_ADDRESS")
    private String sellProductAddress;

    @Column(name = "SELL_PRODUCT_ADDRESS_DETAIL")
    private String sellProductAddressDetail;

    @Column(name = "SELL_PRODUCT_ADDRESS_POST_NUM")
    private String sellProductAddressPostNum;

    @Column(name = "SELL_PRODUCT_DESCRIPTION")
    private String sellProductDescription;

    @Column(name = "SELL_PRODUCT_PHONE")
    private String sellProductPhoneNum;

    @Column(name = "SELL_PRODUCT_THUMBNAIL")
    private String sellProductThumbnail;

    @Column(name = "SELL_PRODUCT_IMAGE")
    private String sellProductImage;

    @Column(name = "SELL_PRODUCT_IMAGE_UPLOAD_PATH")
    private String sellProductImageUploadPath;

    @Column(name = "SELL_PRODUCT_IMAGE_UUID")
    private String sellProductImageUuid;

    @ManyToOne // 다대일
    @JoinColumn(name = "USER_NUM")
    private UserVO userVO;

    @Builder
    public ProductVO(Long sellProductNum, Long sellProductCategory, String sellProductName, Long sellProductOriginPrice, Long sellProductDiscountPrice, String sellProductExpireDay, Long sellProductStock, String sellProductStatus, String sellProductPickup, String sellProductDelivery, String sellProductDeliveryAddress1, String sellProductDeliveryAddress2, String sellProductDeliveryAddress3, String sellProductShipping, String sellProductAddress, String sellProductAddressDetail, String sellProductAddressPostNum, String sellProductDescription, String sellProductPhoneNum, String sellProductThumbnail, String sellProductImage, String sellProductImageUploadPath, String sellProductImageUuid) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.sellProductNum = sellProductNum;
        this.sellProductCategory = sellProductCategory;
        this.sellProductName = sellProductName;
        this.sellProductOriginPrice = sellProductOriginPrice;
        this.sellProductDiscountPrice = sellProductDiscountPrice;
        this.sellProductExpireDay = sellProductExpireDay;
        this.sellProductStock = sellProductStock;
        this.sellProductStatus = sellProductStatus;
        this.sellProductPickup = sellProductPickup;
        this.sellProductDelivery = sellProductDelivery;
        this.sellProductDeliveryAddress1 = sellProductDeliveryAddress1;
        this.sellProductDeliveryAddress2 = sellProductDeliveryAddress2;
        this.sellProductDeliveryAddress3 = sellProductDeliveryAddress3;
        this.sellProductShipping = sellProductShipping;
        this.sellProductAddress = sellProductAddress;
        this.sellProductAddressDetail = sellProductAddressDetail;
        this.sellProductAddressPostNum = sellProductAddressPostNum;
        this.sellProductDescription = sellProductDescription;
        this.sellProductPhoneNum = sellProductPhoneNum;
        this.sellProductThumbnail = sellProductThumbnail;
        this.sellProductImage = sellProductImage;
        this.sellProductImageUploadPath = sellProductImageUploadPath;
        this.sellProductImageUuid = sellProductImageUuid;
    }

    public ProductVO() {;}
}
