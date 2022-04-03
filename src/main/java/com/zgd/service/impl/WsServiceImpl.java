package com.zgd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zgd.entity.Ws;
import com.zgd.mapper.WsMapper;
import com.zgd.service.WsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zgd.vo.info;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public Ws checklogin(String username, String password) {
        QueryWrapper<Ws> qw=new QueryWrapper<Ws>();
        qw.eq("username",username);
        qw.eq("password",password);

        return wsMapper.selectOne(qw);
    }
//    2 账号重复  1 成功  0 失败
    @Override
    public int register(Ws ws) {
        String username=ws.getUsername();
        QueryWrapper<Ws> qw=new QueryWrapper<>();
        List<Ws> l=wsMapper.selectList(qw);
        for(Ws w:l){
            if(w.getUsername().equals(username)){
                return 2;
            }
        }
        return wsMapper.insert(ws);

    }

    @Override
    public boolean updateinfo(info info) {
        QueryWrapper<Ws> qw=new QueryWrapper<>();
        qw.eq("id",info.getId());
        Ws ws=new Ws();
        ws.setName(info.getName());
        ws.setEmail(info.getEmail());
        ws.setAutograph(info.getAutograph());
        ws.setBirthday(info.getBirthday());
        return wsMapper.update(ws,qw)!=0?true:false;
    }
}
