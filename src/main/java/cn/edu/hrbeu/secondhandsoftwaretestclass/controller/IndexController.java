package cn.edu.hrbeu.secondhandsoftwaretestclass.controller;

import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.Commodity;
import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.User;
import cn.edu.hrbeu.secondhandsoftwaretestclass.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    CommodityService commodityService;

    @RequestMapping({"/","/index.html"})
    public String indexShow(HttpSession session){
        List<Commodity> commodityList = commodityService.find9FirstCommodity();
        session.setAttribute("indexCommodityList",commodityList);
        User user = new User();
        user.setUserName("zzzz");
        session.setAttribute("user",user);
        return "index";
    }
}
