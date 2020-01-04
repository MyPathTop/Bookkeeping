package top.mypath.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mypath.dao.SortDao;
import top.mypath.domain.Sort;
import top.mypath.service.SortService;

import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/24 15:37
 */
@Service(value = "sortService")
public class SortServiceImpl implements SortService {

    @Autowired
    private SortDao sortDao;

    @Override
    public Integer insert(Sort sort) {
        return sortDao.insert(sort);
    }

    public boolean update(Sort sort){
        return sortDao.update(sort);
    }

    @Override
    public List<Sort> findAll() {
        return sortDao.findAll();
    }


}
