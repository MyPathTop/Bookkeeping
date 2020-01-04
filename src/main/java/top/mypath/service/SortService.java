package top.mypath.service;

import org.springframework.stereotype.Service;
import top.mypath.domain.Sort;

import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/24 15:37
 */

public interface SortService {
    public Integer insert(Sort sort);

    public boolean update(Sort sort);

    public List<Sort> findAll();
}
