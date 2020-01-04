package top.mypath.controller;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.mypath.commons.CodeMsg;
import top.mypath.commons.Result;
import top.mypath.domain.Detail;
import top.mypath.domain.User;
import top.mypath.service.DetailService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/25 15:01
 */
@Controller
@RequestMapping(path = "/details")
public class DetailsController {

    @Autowired
    private DetailService detailService;

    @RequestMapping("/getMyDetails")
    public Result getMyDetailsByMonth(HttpSession session, Date month){
        User user=(User)session.getAttribute("loginUser");
        List<Detail> details=detailService.findMyDetails(user.getUserId(),month);
        return Result.success(details);
    }

    @RequestMapping(path = "/insertDetail")
    @ResponseBody
    public Result insertDetail(HttpSession session,Detail detail){
        User user=(User)session.getAttribute("loginUser");
        detail.setUser(user);
        boolean insertFlag=detailService.insertDetail(detail);
        if(insertFlag){
            return Result.success(detail);
        }else {
            return Result.error(CodeMsg.DETAIL_INSERT_FAIL);
        }
    }

    @RequestMapping(path = "/updateDetail")
    @ResponseBody
    public Result updateDetail(HttpSession session,Detail detail){
        User user=(User)session.getAttribute("loginUser");
        detail.setUser(user);
        return detailService.updateDetail(detail);
    }

    public Result deleteDetail(HttpSession session,Integer detailId){
        User user=(User)session.getAttribute("loginUser");
        return detailService.deleteDetail(user,detailId);
    }


}
