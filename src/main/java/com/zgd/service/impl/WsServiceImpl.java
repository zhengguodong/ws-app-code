package com.zgd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zgd.entity.Ws;
import com.zgd.mapper.WsMapper;
import com.zgd.service.WsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2022-03-21
 */
@Service
public class WsServiceImpl extends ServiceImpl<WsMapper, Ws> implements WsService {
    @Resource
    private WsMapper wsMapper;
    @Override
    public boolean updatetx(Ws ws) {
        return wsMapper.updatetx(ws)!=0?true:false;
    }
}
