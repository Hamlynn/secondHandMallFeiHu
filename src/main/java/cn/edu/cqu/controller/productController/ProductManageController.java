package cn.edu.cqu.controller.productController;


import cn.edu.cqu.entity.common_vo.ResultVo;
import cn.edu.cqu.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/productManage")
@Api(value="提供商品管理接口",tags = "商品管理")
@CrossOrigin
public class ProductManageController {

    @Resource
    private IProductService productService;


    @GetMapping("/listAllProductByCombinedCondition")
    @ApiOperation(value = "根据组合条件查询商品信息",notes = "GET方式")
    public ResultVo listAllProductByCombinedCondition(){
        ResultVo resultVo=null;
        return resultVo;
    }

    @GetMapping("/listProductByCategory//{categoryId}")
    @ApiOperation(value = "根据分类id查询商品信息",notes = "GET方式")
    public ResultVo listProductByCid(@PathVariable("categoryId") Integer categoryId){
        ResultVo resultVo=productService.listProductByCategory(categoryId);
        return resultVo;
    }



    @GetMapping("/lookUpWaterfallProduct")
    @ApiOperation(value = "查询所有瀑布流商品",notes = "GET方式")
    public ResultVo lookUpWaterfallProduct(){
        ResultVo resultVo=productService.lookUpWaterfallProduct();
        return resultVo;
    }



    @GetMapping("/lookUpProductDetail")
    @ApiOperation(value = "查询所有商品具体信息",notes = "GET方式")
    public ResultVo lookUpProductDetail(){
        ResultVo resultVo=productService.lookUpProductDetail();
        return resultVo;
    }


    @GetMapping("/lookUpProductDetailByPid/{id}")
    @ApiOperation(value = "根据商品id查询商品具体信息",notes = "GET方式")
    public ResultVo lookUpProductDetailByPid(@PathVariable("id")Integer id){
        ResultVo resultVo=productService.lookUpProductDetailByPid(id);
        return resultVo;
    }


    @GetMapping("/listProductByCname/{cname}")
    @ApiOperation(value = "根据分类名称查询商品信息",notes = "GET方式")
    public ResultVo listProductByCname(@PathVariable("cname") String cname){
        ResultVo resultVo=productService.listProductByCname(cname);
        return resultVo;
    }


    @GetMapping("/updateProductStateAfterSellByPid/{id}")
    @ApiOperation(value = "售出商品后改变商品的状态",notes = "GET方式")
    public ResultVo updateProductStateAfterSellByPid(@PathVariable("id") Long id){
        ResultVo resultVo=productService.updateProductStateAfterSellByPid(id);
        return resultVo;
    }

    @GetMapping("/lookMaxIdInProduct")
    @ApiOperation(value = "查询商品的最大id",notes = "GET方式")
    public ResultVo lookMaxIdInProduct(){
        ResultVo resultVo=productService.lookMaxIdInProduct();
        return resultVo;
    }

    @GetMapping("/lookUpProductInfoByPname/{pname}")
    @ApiOperation(value = "根据商品名称模糊查询商品",notes = "GET方式")
    public ResultVo lookUpProductInfoByPname(@PathVariable("pname")String pname){
        ResultVo resultVo=productService.lookUpProductInfoByPname(pname);
        return resultVo;
    }




    @GetMapping("/listProductByPriceRange/{priceRange}")
    @ApiOperation(value = "根据价格范围查询商品信息",notes = "GET方式")
    public ResultVo listProductByPriceRange(@PathVariable("priceRange") String priceRange){
        String []price=priceRange.split("-");
        if(price.length==2){
            int price_low=Integer.parseInt(priceRange.split("-")[0]);
            int price_high=Integer.parseInt(priceRange.split("-")[1]);
            ResultVo resultVo=productService.listProductByPriceRange(price_low,price_high );
            return resultVo;
        }
        else{
            int price_low=Integer.parseInt(priceRange.split("-")[0]);
            int price_high=10000;
            ResultVo resultVo=productService.listProductByPriceRange(price_low,price_high );
            return resultVo;
        }

    }

    @GetMapping("/listProductByViewNumRange/{viewNumRange}")
    @ApiOperation(value = "根据浏览量范围查询商品信息",notes = "GET方式")
    public ResultVo listProductByViewNumRange(@PathVariable("viewNumRange") String viewNumRange){
        String []viewNum=viewNumRange.split("-");
        if(viewNum.length==2){
            int viewNum_low=Integer.parseInt(viewNumRange.split("-")[0]);
            int viewNum_high=Integer.parseInt(viewNumRange.split("-")[1]);
            ResultVo resultVo=productService.listProductByViewNumRange(viewNum_low,viewNum_high );
            return resultVo;
        }
        else{
            int viewNum_low=Integer.parseInt(viewNumRange.split("-")[0]);
            int viewNum_high=10000;
            ResultVo resultVo=productService.listProductByViewNumRange(viewNum_low,viewNum_high );
            return resultVo;
        }
    }



}
