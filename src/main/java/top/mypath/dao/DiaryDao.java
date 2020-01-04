package top.mypath.dao;

import org.springframework.stereotype.Repository;
import top.mypath.domain.Diary;

import java.util.Date;
import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/24 12:40
 */
@Repository
public interface DiaryDao {
    public boolean insert(Diary diary);
    public boolean update(Diary diary);
    public List<Diary> findByUser(String userId);
}
