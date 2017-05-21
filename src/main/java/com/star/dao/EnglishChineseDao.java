package com.star.dao;

import com.star.model.EnglishWord;

import java.util.List;

/**
 * @Author 张楠
 * @Date 2017-05-2017/5/14 下午2:14
 * @Describe
 * @Version
 */
public interface EnglishChineseDao {
    List<EnglishWord> queryUserWordList();

    void addWord(EnglishWord englishWord);

    void updateWord(EnglishWord englishWord);
}
