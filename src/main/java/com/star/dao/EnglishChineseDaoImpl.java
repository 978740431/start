package com.star.dao;

import com.star.mapper.EnglishChineseMapper;
import com.star.model.EnglishWord;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 张楠
 * @Date 2017-05-2017/5/14 下午2:14
 * @Describe
 * @Version
 */
@Repository("englishChineseDao")
public class EnglishChineseDaoImpl implements EnglishChineseDao{

    @Resource
    private EnglishChineseMapper englishChineseMapper;

    @Override
    public List<EnglishWord> queryUserWordList() {
        return englishChineseMapper.queryUserWordList();
    }

    @Override
    public void addWord(EnglishWord englishWord) {
        englishChineseMapper.addWord(englishWord);
    }

    @Override
    public void updateWord(EnglishWord englishWord) {
        englishChineseMapper.updateWord(englishWord);
    }
}
