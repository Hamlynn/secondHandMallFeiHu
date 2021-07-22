package cn.edu.cqu.service.impl;

import cn.edu.cqu.entity.Product;
import cn.edu.cqu.entity.ShoppingcarProduct;
import cn.edu.cqu.entity.Store;
import cn.edu.cqu.entity.UserOrder;
import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.entity.common_vo.StatusVo;
import cn.edu.cqu.entity.query_vo.ProductDetailVo;
import cn.edu.cqu.entity.query_vo.WaterfallVo;
import cn.edu.cqu.mapper.ProductMapper;
import cn.edu.cqu.service.IProductService;
import cn.edu.cqu.service.IShoppingcarProductService;
import cn.edu.cqu.service.IStoreService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author FEIHU
 * @since 2021-07-15
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Resource
    private IProductService productService;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private IShoppingcarProductService  shoppingcarProductService;

    @Resource
    private IStoreService storeService;


    @Override
    public ResultVo listAllProduct() {
        List<Product> productList=productService.list();
        if(productList.isEmpty()){
            return new ResultVo(StatusVo.NO,"没有商品", null);
        }else {
            return new ResultVo(StatusVo.OK,"列出所有商品成功",productList);
        }
    }

    @Override
    public ResultVo listProductByCombinedCondition() {
        return null;
    }

    @Override
    public ResultVo listProductByCategory(Integer categoryId) {

        Map<String, Object> map = new HashMap<>();
        //增加查询条件,字段需要与数据库表中的字段一致
        map.put("c_Id", categoryId);

        List<Product> productList=productMapper.selectByMap(map);

        if(productList.isEmpty()){
            return  new ResultVo(StatusVo.NO,"当前分类下没有商品",null);
        }else{
            return  new ResultVo(StatusVo.OK,"查询分类商品成功",productList);
        }
    }

    @Override
    public ResultVo lookUpProductById(Integer productId) {

        Product product=productService.getById(productId);

        if(product==null){
            return  new ResultVo(StatusVo.NO,"该商品不存在",null);
        }else {
            return  new ResultVo(StatusVo.NO,"查询商品信息成功",product);
        }
    }


    @Override
    public ResultVo lookUpWaterfallProduct() {
        List<WaterfallVo> waterfallVoList=productMapper.lookUpWaterfallProduct();
        return new ResultVo(StatusVo.OK,"查询瀑布流商品成功",waterfallVoList);
    }

    @Override
    public ResultVo lookUpProductDetail() {
        List<ProductDetailVo> productDetailVoList=productMapper.lookUpProductDetail();
        return new ResultVo(StatusVo.OK,"查询商品具体信息成功",productDetailVoList);

    }

    @Override
    public ResultVo lookUpProductDetailByPid(Integer id) {
        ProductDetailVo productDetailVo=productMapper.lookUpProductDetailByPid(id);
        if(productDetailVo!=null){
            return new ResultVo(StatusVo.OK,"查询商品成功",productDetailVo);
        }
        return new ResultVo(StatusVo.NO,"商品不存在",null);

    }

    @Override
    public ResultVo listProductByCname(String cname) {
        List<ProductDetailVo> productDetailVoList=productMapper.listProductByCname(cname);
        return new ResultVo(StatusVo.OK,"查询商品成功",productDetailVoList);
    }

    @Override
    public ResultVo listProductByPriceRange(int price_low, int price_high) {
        List<ProductDetailVo> productDetailVoList=productMapper.listProductByPriceRange(price_low,price_high);
        return new ResultVo(StatusVo.OK,"查询商品成功",productDetailVoList);
    }

    @Override
    public ResultVo listProductByViewNumRange(int viewNum_low, int viewNum_high) {
        List<ProductDetailVo> productDetailVoList=productMapper.listProductByViewNumRange(viewNum_low,viewNum_high);
        return new ResultVo(StatusVo.OK,"查询商品成功",productDetailVoList);
    }

    @Override
    public ResultVo updateProductStateAfterSellByPid(Long id) {
        Product product= Product.builder().pId(id).pState(1).build();
        boolean flg=productService.updateById(product);
        if (flg){
            return new ResultVo(StatusVo.OK,"更新商品状态成功",null);
        }
       else return new ResultVo(StatusVo.NO,"更新商品状态失败",null);


    }

    @Override
    public ResultVo lookMaxIdInProduct() {
        int maxId=productMapper.lookMaxIdInProduct();
        return new ResultVo(StatusVo.OK,"最大商品id",maxId);
    }

    @Override
    public ResultVo lookUpProductInfoByPname(String pname) {
        List<ProductDetailVo> productDetailVoList=productMapper.lookUpProductInfoByPname('%'+pname+'%');
        return new ResultVo(StatusVo.OK,"查询成功",productDetailVoList);

    }

    //<!-----------------------------------------------------------------------
    /**
     * 与商品发布有关的方法
     * @param product
     * @return
     *
     */
    @Override
    public ResultVo releaseProduct(Product product) {
        boolean flg=productService.save(product);
        if(flg){
            return  new ResultVo(StatusVo.OK,"发布商品成功",null);
        }
        return  new ResultVo(StatusVo.NO,"发布商品失败",null);

    }

    @Override
    public ResultVo changeProductInfo(Product product) {
        boolean flg=productService.updateById(product);
        if(flg){
            return  new ResultVo(StatusVo.OK,"修改所发布商品成功",null);
        }
        return  new ResultVo(StatusVo.NO,"修改所发布商品失败",null);
    }

    @Override
    public ResultVo deleteReleasedProductByPid(Integer id) {

        boolean flg=productService.removeById(id);
        if(flg){
            return  new ResultVo(StatusVo.OK,"删除所发布商品成功",null);
        }
        return  new ResultVo(StatusVo.NO,"删除所发布商品失败",null);
    }

    @Override
    public ResultVo lookUpReleasedProductByUid(Integer id) {
        Map<String, Object> map = new HashMap<>();
        //增加查询条件,字段需要与数据库表中的字段一致
        map.put("seller_Id", id);
        List<Product> productList=productMapper.selectByMap(map);
        if(productList!=null){
            return new ResultVo(StatusVo.OK,"查询用户所有发布商品成功",productList);
        }
        return new ResultVo(StatusVo.OK,"当前用户还没有发布商品哦",null);

    }




}
