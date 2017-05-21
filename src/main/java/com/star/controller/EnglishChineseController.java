package com.star.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.star.model.EnglishWord;
import com.star.service.EnglishChineseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 张楠
 * @Date 2017-05-2017/5/14 下午2:11
 * @Describe
 * @Version
 */

@Controller
@RequestMapping("/english_to_chinese")
public class EnglishChineseController {

    @Resource
    private EnglishChineseService englishChineseService;

    @RequestMapping(value = "/word_list", method = RequestMethod.GET)
    public ModelAndView index() {

        List<EnglishWord> wordList = englishChineseService.queryUserWordList();
        /*for (EnglishWord englishWord : wordList) {
            String phonetic = englishWord.getPhonetic();
            if (null != phonetic && phonetic.contains("'")){
                englishWord.setPhonetic(phonetic.replace("\'","\\\'"));
            }
        }*/
        ModelAndView mv = new ModelAndView();
        mv.setViewName("word_list");
        mv.addObject("wordList", wordList);
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/add_word", method = RequestMethod.POST)
    public String addWord(EnglishWord englishWord) {
        ObjectMapper mapper = new ObjectMapper();
        englishChineseService.addWord(englishWord);
        try {
            return mapper.writeValueAsString("error");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/update_word", method = RequestMethod.POST)
    public String updateWord(EnglishWord englishWord) {
        /*try {
            englishWord.setChinese(new String(englishWord.getChinese().getBytes("ISO-8859-1"), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        ObjectMapper mapper = new ObjectMapper();
        englishChineseService.updateWord(englishWord);
        try {
            return mapper.writeValueAsString("error");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
