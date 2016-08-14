package com.star.dao;

import com.star.mapper.VisitRecordInterceptorMapper;
import com.star.model.VisitRecord;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhangnan on 16/7/27.
 */
@Repository
public class VisitRecordInterceptorDaoImpl implements VisitRecordInterceptorDao{

    @Resource
    private VisitRecordInterceptorMapper visitRecordInterceptorMapper;
    @Override
    public void saveVisitRecord(VisitRecord visitRecord) {

        visitRecordInterceptorMapper.saveVisitRecord(visitRecord);

    }
}
