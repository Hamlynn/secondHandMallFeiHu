package cn.edu.cqu.service.impl;

import cn.edu.cqu.entity.AlipayBean;
import cn.edu.cqu.service.PayService;
import cn.edu.cqu.utils.Alipay;
import com.alipay.api.AlipayApiException;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayServiceImpl implements PayService {

    @Resource
    private Alipay alipay;


    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }
}
