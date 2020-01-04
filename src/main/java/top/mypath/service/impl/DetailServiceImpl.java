package top.mypath.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mypath.commons.CodeMsg;
import top.mypath.commons.Result;
import top.mypath.dao.DetailsDao;
import top.mypath.dao.UserDao;
import top.mypath.domain.Detail;
import top.mypath.domain.User;
import top.mypath.service.DetailService;

import java.util.Date;
import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/24 23:06
 */
@Service(value = "detailService")
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailsDao detailsDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<Detail> findMyDetails(String userId, Date month) {
        return detailsDao.findAllDetailsByDate(userId,month);
    }

    @Override
    public boolean insertDetail(Detail detail) {
        boolean detailFlag=detailsDao.insert(detail);
        User user=userDao.findById(detail.getUser().getUserId());
        if(detail.getInOut()==1){               //代表收入
            user.setMyBalance(user.getMyBalance()+detail.getMoney());
        }else {
            user.setMyBalance(user.getMyBalance()-detail.getMoney());
        }
        boolean userFlag=userDao.update(user);
        if(detailFlag&&userFlag)
            return true;
        else
            return false;

    }

    @Override
    public Result updateDetail(Detail newDetail) {
        Detail oldDetail=detailsDao.findById(newDetail.getDetailId());
        User user=userDao.findById(newDetail.getUser().getUserId());
        double oldBalance;                                                                          //插入数据前的余额
        double newBalance;                                                                          //修改数据后的余额
        if ((oldDetail.getUser().getUserId()).equals(user.getUserId())) {              //判断修改的数据是否是当前登录用户所拥有的数据
            boolean inOutFlag = (newDetail.getInOut()).equals(oldDetail.getInOut());                  //判断修改的数据是否修改了收支类别
            boolean moneyFlag = newDetail.getMoney().equals(oldDetail.getMoney());                   //判断钱数是否修改了
            if (inOutFlag && moneyFlag) {
                boolean flag = detailsDao.update(newDetail);
                if (flag) {
                    return Result.success("修改成功");
                } else {
                    return Result.error(CodeMsg.ERROR);
                }
            } else {
                if (oldDetail.getInOut() == 1) {                                                   //判断以前的是收入还是支出 1代表收入
                    oldBalance = user.getMyBalance() - oldDetail.getMoney();
                } else {
                    oldBalance = user.getMyBalance() + oldDetail.getMoney();
                }
                if (newDetail.getInOut() == 1) {                                                    //判断这次修改的是收入还是支出 1代表收入
                    newBalance = oldBalance + newDetail.getMoney();
                } else {
                    newBalance = oldBalance - newDetail.getMoney();
                }
                boolean detailFlag=detailsDao.update(newDetail);
                user.setMyBalance(newBalance);
                boolean userFlag=userDao.update(user);
                if(detailFlag&&userFlag)
                    return Result.success("修改成功");
                else
                    return Result.error(CodeMsg.ERROR);
            }
        } else {
            return Result.error(CodeMsg.DETAIL_UPDATE_USER_ERROR);
        }
    }

    @Override
    public Result deleteDetail(User user, Integer detailId) {
        Detail detail=detailsDao.findById(detailId);
        if(detail==null){
            return Result.error(CodeMsg.DETAIL_NULL);
        }
        if(detail.getUser().getUserId().equals(user.getUserId())){
            User dbUser=userDao.findById(user.getUserId());
            boolean flag=detailsDao.deleteDetail(detailId);
            if(flag) {
                if (detail.getInOut() == 1) {
                    dbUser.setMyBalance(dbUser.getMyBalance() - detail.getMoney());
                } else {
                    dbUser.setMyBalance(dbUser.getMyBalance() + detail.getMoney());
                }
                userDao.update(dbUser);
                return Result.success("删除成功");
            } else
                return Result.error(CodeMsg.ERROR);
        }else
            return Result.error(CodeMsg.DETAIL_UPDATE_USER_ERROR);
    }
}
