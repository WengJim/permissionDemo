package cn.com.demo.permission.service.impl;

import cn.com.demo.permission.dao.ActivityMapper;
import cn.com.demo.permission.model.Activity;
import cn.com.demo.permission.service.IActivityService;
import cn.com.demo.permission.core.AbstractService;
import cn.com.demo.permission.service.IActivityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* @author: jimw
* @date: 2019/01/23 15:25:23
* @description: Activity服务实现
*/
@Service
@Transactional
public class ActivityServiceImpl extends AbstractService<Activity> implements IActivityService {
    @Resource
    private ActivityMapper webActivityMapper;

}
