package cn.edu.cqu.entity.query_vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long pId;

    private String uSchool;

    private String uName;

    private String uPhoneNum;

    private Long uId;

    private String pName;

    private String pIntro;

    private BigDecimal pPrice;

    private Integer pState;

    private Integer pViewNum;

    private LocalDateTime pTime;

    private String sellerId;

    private String cName;

    private String pImg;

    private Integer pPrePrice;
}
