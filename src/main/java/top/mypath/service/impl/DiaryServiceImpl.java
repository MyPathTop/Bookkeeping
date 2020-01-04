package top.mypath.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mypath.dao.DiaryDao;
import top.mypath.domain.Diary;
import top.mypath.service.DiaryService;

import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/24 23:05
 */
@Service(value = "diaryService")
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    private DiaryDao diaryDao;

    @Override
    public List<Diary> findAllByUser(String userId) {
        return null;
    }

    @Override
    public boolean insert(Diary diary) {
        return false;
    }

    @Override
    public boolean update(Diary diary) {
        return false;
    }
}
