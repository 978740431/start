package com.star.service;

import com.star.dao.EnglishChineseDao;
import com.star.model.EnglishWord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 张楠
 * @Date 2017-05-2017/5/14 下午2:15
 * @Describe
 * @Version
 */
@Service
public class EnglishChineseServiceImpl implements EnglishChineseService{


    @Resource
    private EnglishChineseDao englishChineseDao;

    @Override
    public List<EnglishWord> queryUserWordList() {
        return englishChineseDao.queryUserWordList();
    }

    @Override
    public void addWord(EnglishWord englishWord) {
        englishChineseDao.addWord(englishWord);
    }

    @Override
    public void updateWord(EnglishWord englishWord) {
        englishChineseDao.updateWord(englishWord);
    }
}
