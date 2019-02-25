package cn.com.demo.permission.service.impl;

import cn.com.demo.permission.dao.ActOrderMapper;
import cn.com.demo.permission.model.ActOrder;
import cn.com.demo.permission.service.IActOrderService;
import cn.com.demo.permission.core.AbstractService;
import cn.com.demo.permission.service.IActOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
* @author: jimw
* @date: 2019/01/23 17:59:03
* @description: ActOrder服务实现
*/
@Service
@Transactional
public class ActOrderServiceImpl extends AbstractService<ActOrder> implements IActOrderService {
    @Resource
    private ActOrderMapper webActOrderMapper;

}
