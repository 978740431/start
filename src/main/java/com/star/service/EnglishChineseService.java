package com.star.service;

import com.star.model.EnglishWord;

import java.util.List;

/**
 * @Author 张楠
 * @Date 2017-05-2017/5/14 下午2:14
 * @Describe
 * @Version
 */
public interface EnglishChineseService {
    List<EnglishWord> queryUserWordList();

    void addWord(EnglishWord englishWord);
}
