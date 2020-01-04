package top.mypath.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.mypath.domain.Detail;

import java.util.Date;
import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/24 12:44
 */
@Repository
public interface DetailsDao {

    public List<Detail> findAllDetailsByDate(@Param("userId") String userId,@Param("month") Date month);

    public boolean insert(Detail detail);

    public boolean update(Detail detail);

    public boolean userBalance(Double balance,String userId);

    public boolean deleteDetail(Integer detailId);

    public Detail findById(Integer detailId);
}
