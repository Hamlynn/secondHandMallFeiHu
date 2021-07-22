package cn.edu.cqu;

import cn.edu.cqu.entity.Board;
import cn.edu.cqu.entity.Product;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.query_vo.OrderInfoVo;
import cn.edu.cqu.mapper.BoardMapper;
import cn.edu.cqu.mapper.StoreMapper;
import cn.edu.cqu.mapper.UserOrderMapper;
import cn.edu.cqu.service.IBoardService;
import cn.edu.cqu.service.IUserOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SecondHandMallApplicationTests {

    @Test
    void contextLoads() {
    }


    @Resource
    IUserOrderService userOrderService ;


//    @Test
//    void deleteOrderByIDTest(){
//
//        ResultVo resultVo=userOrderService.deleteOrderByOrderId(4);
//        System.out.println(resultVo);
//        System.out.println("执行成功");
//    }
//    @Test
//    void sleectOrderAsUserAndBuyer(){
//        ResultVo resultVo=userOrderService.lookUpSellOrder(1001);
//        System.out.println(resultVo);
//        resultVo=userOrderService.lookUpBuyOrder(1001);
//        System.out.println(resultVo);
//    }
//
//    @Resource
//    IBoardService boardService;
//
//    @Resource
//    BoardMapper boardMapper;

//    @Test
//    void removeBoardTest(){
//      //int flag=boardMapper.deleteById(3);
//
//        boolean flag=boardService.removeById(34);
//
//      System.out.println("forever yong:::"+flag);
//
//    }

    /*ddwauigdfagftieaitfueiafy
     */
    //



//    @Resource
//    StoreMapper storeMapper;
//    @Test
//    void testy(){
//        List<Product> productList=storeMapper.lookUpStoreProductByUserId(1001);
//        System.out.println(productList);
//    }
//
//
//    @Resource
//    UserOrderMapper userOrderMapper;
//    @Test
//    void test(){
//        OrderInfoVo orderVo=userOrderMapper.lookUpDetailedOrderInfoById(2);
//        System.out.println("输出的结果结果结果："+orderVo);
//    }
//
//
//    @Resource
//    UserOrderMapper userOrderMapper;
//    @Test
//    void twer(){
//
//        List<OrderInfoVo> list =userOrderMapper.lookUpDetailedOrderInfoByBuyerId(1001);
//
//        System.out.println(list);
//    }




}
