package top.mypath.service;

import top.mypath.domain.Diary;

import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/24 23:04
 */
public interface DiaryService {
    public List<Diary> findAllByUser(String userId);

    public boolean insert(Diary diary);

    public boolean update(Diary diary);
}
