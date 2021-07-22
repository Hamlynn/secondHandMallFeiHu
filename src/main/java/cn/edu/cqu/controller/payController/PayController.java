package cn.edu.cqu.controller.payController;

import cn.edu.cqu.config.AlipayConfig;
import cn.edu.cqu.entity.AlipayBean;
import cn.edu.cqu.entity.UserOrder;
import cn.edu.cqu.service.IProductService;
import cn.edu.cqu.service.IUserOrderService;
import cn.edu.cqu.service.PayService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.apache.catalina.manager.Constants.CHARSET;

/**
 * 支付宝沙箱测试
 *
 * @author 小道仙
 * @date 2020年2月17日
 */
@Controller
public class PayController {

    @Resource
    private PayService payService;
    @Resource
    private AlipayConfig alipayConfig;
    @Resource
    private IProductService productService;

    @Resource
    private IUserOrderService userOrderService;
    /**
     * 阿里支付
     * @param
     * @param
     * @param
     * @param
     * @return
     * @throws AlipayApiException
     */
    @ResponseBody
    @GetMapping(value = "order/alipay")
    public String alipay(
            @RequestParam String outTradeNo,
            @RequestParam String subject,
            @RequestParam String totalAmount,
            @RequestParam String body) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(outTradeNo);
        alipayBean.setSubject(subject);
        alipayBean.setTotal_amount(totalAmount);
        alipayBean.setBody(body);
        return payService.aliPay(alipayBean);
    }


    @GetMapping(value = "/returnUrl")
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");
        System.out.println(request);
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        /**
         * {
         * charset=utf-8,
         * out_trade_no=9932957316,
         * method=alipay.trade.page.pay.return,
         * total_amount=100.00,
         * sign=eJoax1tyv/802bpRfmzJ+U64/adBPnTGE8JtgGMaI9zdIkZsWgrBtyUtECDGTBZuPfVdolInejVzISlO1SVZ8hvV7YwAfByrY7imxCGrP0JrcvzRIHPQJjZ1cKULGl
         * bPB6WHQZC9vy5q8+NHGs3UMtKcFd56yZmEbrhidsx/C87+NyWm/WCIldsAbi5RpbcD+XGSJVxC+mDg6hRz9f4rXuKw9irvporfFq7a9YtW5kp
         * mSt/jSoAWEBtTQxIxNb5snBDp4WcPsDUHCKmmQ4CUR5v6+AGZWJUr9tD3vD97cLJA02m5plC9EJrfwDfn6PQIPZDfIvUp8VwLrm4LLYyqIw==,
         * trade_no=2021072122001479480501752485,
         * auth_app_id=2021000117691776,
         * version=1.0,
         * app_id=2021000117691776,
         * sign_type=RSA2,
         * seller_id=2088621956178399,
         * timestamp=2021-07-21 11:44:32
         * }
         */
        //boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名

        System.err.println("charset---》"+(alipayConfig.getCharset()));
        System.err.println("sign_type---》"+(alipayConfig.getSignType()));
        System.err.println("sign---》"+(alipayConfig.getPublicKey()));

        /**
         * MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsi2l+rA1NL4EULerEGggQjveA0mLGsUXPhNC4ATPjDymN
         * q/+d2NiEyRk3oHBSaiw5UpI3adRUiRvQUTo/Poektu5+NIoQXmNQvcsPikdXEuj96jt4ru4oYBHMXTAOdfOjue03w+1TKYIcv67R4FS
         * SHx5O4YJhp/mtQl+kWKtLNaXqwTG45oEPbUOCEHoY5jcS1ytT+TAiKhk+Br3PvOnMFQc2xs4kLTuuQ5zoLuk/psLoiaOMvrVCyEEBNr+v7hKl6
         * bnPam/20Nc3gLbaPZoNKk90atxPJV4TmPm7EbAHTXpLdiyFGdgZykiPL41eUOiUe2vzN2A/A3EShK91eXeRQIDAQAB";
         * //è¿æ¯æ²ç®±æ¥å£è·¯å¾,æ­£å¼è·¯å¾ä¸ºhttps://openapi.alipay.com/gateway.do
         */

        boolean signVerified = AlipaySignature.rsaCheckV1(params, alipayConfig.getPublicKey(), alipayConfig.getCharset(), alipayConfig.getSignType());

        System.out.println("签名是否通过"+signVerified);
        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);

            String []orderInfo=out_trade_no.split("a");
            int pid=Integer.parseInt(orderInfo[0]);
            int buyerid=Integer.parseInt(orderInfo[2]);
            int buyeraddrid=Integer.parseInt(orderInfo[3]);
            out_trade_no=deleteString0(out_trade_no,'a');
            UserOrder userOrder=
                    UserOrder.builder().oState(0).
                            oNum(out_trade_no).pId((long) pid).
                            buyerId((long) buyerid).
                            buyerAddrId((long) buyeraddrid).build();
            userOrderService.orderCreate(userOrder);
            return "ok";//跳转付款成功页面

        }else{
            return "fail";//跳转付款失败页面
        }
    }
    public static String deleteString0(String str, char delChar){
        String delStr = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != delChar){
                delStr += str.charAt(i);
            }
        }
        return delStr;
    }
}
