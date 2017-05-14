package com.star.mapper;

import com.star.model.EnglishWord;

import java.util.List;

/**
 * Created by zhangnan on 16/11/13.
 *
 */
public interface EnglishChineseMapper {


    List<EnglishWord> queryUserWordList();

    void addWord(EnglishWord englishWord);
}
