package top.mypath.dao;

import org.springframework.stereotype.Repository;
import top.mypath.domain.Sort;

import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/24 12:33
 */
@Repository
public interface SortDao {

    public Integer insert(Sort sort);

    public boolean update(Sort sort);

     public List<Sort> findAll();
}
