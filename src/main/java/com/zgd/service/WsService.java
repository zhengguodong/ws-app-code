package com.zgd.service;

import com.zgd.entity.Ws;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zgd.vo.info;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2022-03-21
 */
public interface WsService extends IService<Ws> {
    boolean updatetx(Ws ws);
    Ws checklogin(String username,String password);
    int register(Ws ws);
    boolean updateinfo(info info);
}
