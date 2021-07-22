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
public class ShoppingCarVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer uId;

    private Long pId;

    private Integer spId;

    private LocalDateTime spAddTime;

    private String pName;

    private String pIntro;

    private String pImg;

    private BigDecimal pPrice;

}

