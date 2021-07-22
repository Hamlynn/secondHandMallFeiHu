package cn.edu.cqu.entity.query_vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyInfoVo {



    private Long buyId;


    private String buyProductName;


    private String buyIntro;


    private Long buyBuyerId;



    private String buyBuyerName;


    private String buyBuyerSchool;

    private String buyBuyerPhone;




    private LocalDateTime buyTime;


    private String buyImg;


    private String buyPhone;
}
