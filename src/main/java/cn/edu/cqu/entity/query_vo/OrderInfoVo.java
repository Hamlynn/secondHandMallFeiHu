package cn.edu.cqu.entity.query_vo;

import cn.edu.cqu.entity.Product;
import cn.edu.cqu.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoVo implements Serializable {


    private static final long serialVersionUID = 1L;



    private Integer oId;

    private Integer pId;

    private String pName;

    private String pPrice;

    private int pState;

    private Integer buyerId;
    private String receiverName;
    private String receiverAddr;
    private String receiverPhone;


    private Integer sellerId;

    private String sellerName;

    private String sellerPhone;

    private String buyerName;

    private String buyerPhone;

    private Integer buyerAddrId;




    private String oNum;

    private String pImg;

    private LocalDateTime oTime;

    private Integer oState;





    /**
     * 暂时不写 商品数量 和 商品总价格，因为需要更改数据库
     */
}
