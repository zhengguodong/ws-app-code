package com.zgd.service;

import com.zgd.entity.Ws;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
