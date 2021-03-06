package com.quaint.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quaint.blog.mapper.StayMessageMapper;
import com.quaint.blog.pojo.StayMessage;
import com.quaint.blog.service.StayMessageService;
import com.quaint.blog.utils.LayJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 留言实现类
 * @author quaint
 * @Date 2019/2/20
 */
@Component("StayMessageService")
public class StayMessageServiceImpl implements StayMessageService {

    @Autowired
    private StayMessageMapper stayMessageMapper;

    @Override
    public int insertSelective(StayMessage stayMessage) {
        return stayMessageMapper.insertSelective(stayMessage);
    }

    @Override
    public StayMessage selectByPrimaryKey(Integer sId) {
        return stayMessageMapper.selectByPrimaryKey(sId);
    }

    /**
     * 前台分页查询留言
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<StayMessage> selectStayMessageList(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<StayMessage> list = stayMessageMapper.select(); //用PageInfo对结果进行包装
        PageInfo<StayMessage> page = new PageInfo<StayMessage>(list);
        return page;
    }

    @Override
    public List<StayMessage> selectByRe(Integer sid) {
        return stayMessageMapper.selectByRe(sid);
    }

    @Override
    public LayJson<StayMessage> select(LayJson<StayMessage> layJson) {
        List<StayMessage> list =stayMessageMapper.selectWithRe();
        //设置查询出来的全部数据
        layJson.setData(list);
        return layJson;
    }

    @Override
    public int deleteByPrimaryKey(Integer sId) {
        return stayMessageMapper.deleteByPrimaryKey(sId);
    }

    @Override
    public int updateByPrimaryKeySelective(StayMessage stayMessage) {
        return stayMessageMapper.updateByPrimaryKeySelective(stayMessage);
    }

}
