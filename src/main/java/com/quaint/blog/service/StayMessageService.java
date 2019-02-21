package com.quaint.blog.service;

import com.github.pagehelper.PageInfo;
import com.quaint.blog.pojo.StayMessage;

public interface StayMessageService {

    /**
     * 记录一个留言
     * @return
     */
    int insertSelective(StayMessage stayMessage);

    /**
     * 前台分页查询留言
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<StayMessage> selectStayMessageList(int pageNo, int pageSize);

}