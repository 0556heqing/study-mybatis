package com.heqing.mybatis.service;

/**
 * @author heqing
 * @since 2021-07-21
 */
public interface TransactionaService {

    /**
     * 保存信息
     * @param isbug
     * @throws Exception
     */
    void save(boolean isbug) throws Exception;

}
