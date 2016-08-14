package com.star.service;

import com.star.dao.VisitRecordInterceptorDao;
import com.star.model.VisitRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangnan on 16/7/27.
 */
@Service
public class VisitRecordInterceptorImpl implements VisitRecordInterceptorService{

    @Resource
    private VisitRecordInterceptorDao visitRecordInterceptorDao;
    @Override
    public void saveVisitRecord(VisitRecord visitRecord) {

        visitRecordInterceptorDao.saveVisitRecord(visitRecord);

    }
}
