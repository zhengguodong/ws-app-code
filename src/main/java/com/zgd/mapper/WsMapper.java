package com.zgd.mapper;

import com.zgd.entity.Ws;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2022-03-21
 */
public interface WsMapper extends BaseMapper<Ws> {
    int updatetx(Ws ws);
}
