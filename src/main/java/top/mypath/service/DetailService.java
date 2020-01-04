package top.mypath.service;

import top.mypath.commons.Result;
import top.mypath.domain.Detail;
import top.mypath.domain.User;

import java.util.Date;
import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/24 23:04
 */
public interface DetailService {
    public List<Detail> findMyDetails(String userId, Date month);

    public boolean insertDetail(Detail detail);

    public Result updateDetail(Detail newDetail);

    Result deleteDetail(User user,Integer detailId);
}
