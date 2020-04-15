package com.qfedu.controller;

import com.qfedu.entity.FreshGoods;
import com.qfedu.entity.GoodType;
import com.qfedu.service.FreshGoodsService;
import com.qfedu.service.GoodTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (FreshGoods)表控制层
 *
 * @author makejava
 * @since 2020-04-10 13:49:07
 */
@Controller
public class FreshGoodsController {
    /**
     * 服务对象
     */
    @Resource
    private FreshGoodsService freshGoodsService;
    /**
     * 服务对象
     */
    @Resource
    private GoodTypeService goodTypeService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public FreshGoods selectOne(String id) {
        return this.freshGoodsService.queryById(id);
    }

    /**
     * 进入商品详情
     * @return
     */
    @GetMapping("getGoodDetailsByFdid")
    public String getFreshGoodsByFDID(@RequestParam(value = "fdid") String fdid,Model model){
        FreshGoods goodsone = freshGoodsService.queryById(fdid);

        String[] imgs = goodsone.getImg().split("-");

        model.addAttribute("imgs",imgs);
        model.addAttribute("freshGoods",goodsone);

        return "single";
    }

    /**
     * 热销商品的分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("getFreshGoodsPage")
    @ResponseBody
    public List<FreshGoods>  getFreshGoodsByPage(@RequestParam(value = "gtid",defaultValue = "1") int gtid,
                                                 @RequestParam(value = "cp",defaultValue = "1") int currentPage,
                                                 @RequestParam(value = "ps",defaultValue = "5") int pageSize){

        currentPage = currentPage < 1 ? 1: currentPage;
        pageSize =  pageSize < 1 ? 1: pageSize;

        int offset =(currentPage-1)*pageSize;

        return freshGoodsService.queryAllByLimit(gtid,offset,pageSize);
    }

    /**
     *
     * 根据商品条件（类型）分页查询
     * 展示商品类型
     * 展示用户是否登陆判断
     * @param gtid
     * @param model
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("getAllFreshView")
    public String getFreshGoodsView(@RequestParam(value = "gtid",defaultValue = "1") int gtid,
                                    @RequestParam(value = "cp",defaultValue = "1") int currentPage,
                                    @RequestParam(value = "ps",defaultValue = "5") int pageSize ,
                                    Model model,HttpSession session){

        /*获取所有商品数据*/
        currentPage = currentPage < 1 ? 1: currentPage;
        pageSize =  pageSize < 1 ? 1: pageSize;

        int offset =(currentPage-1)*pageSize;

        List<FreshGoods> list = freshGoodsService.queryAllByLimit(gtid,0, 200);
        model.addAttribute("freshGoods",list);

        /*处理装配商品类型*/
        GoodType goodType = goodTypeService.queryById(gtid);
        model.addAttribute("goodType",goodType);

        /*处理装配商品图片  第一个String:商品id  第二个String商品图片路径*/
        Map<String,String> imgs = new HashMap<>();
        for (FreshGoods freshGoods : list) {
            String img = freshGoods.getImg();

            String[] split = img.split("-");

            String is=split[0];

            imgs.put(freshGoods.getFdid(),is);
        }
        model.addAttribute("imgs",imgs);

        session.setAttribute("users","zhangsan");

        return "product";
    }

}