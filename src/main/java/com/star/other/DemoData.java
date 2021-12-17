package com.star.other;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class DemoData {
    @ExcelProperty("日期")
    private String date;
    @ExcelProperty("btc增加数量")
    private Double btcAddCount;
    @ExcelProperty("btc价格")
    private Double btcPrice;
    @ExcelProperty("btc总数量")
    private Double addTotalCount;

}