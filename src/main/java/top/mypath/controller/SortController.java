package top.mypath.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.mypath.commons.Result;
import top.mypath.domain.Sort;
import top.mypath.service.SortService;

import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/25 14:50
 */
@Controller
@RequestMapping(path = "/sort")
public class SortController {

    @Autowired
    private SortService sortService;

    @RequestMapping(path = "/findAll")
    public Result getAllSort(){
        List<Sort> sorts=sortService.findAll();
        return Result.success(sorts);
    }
}
