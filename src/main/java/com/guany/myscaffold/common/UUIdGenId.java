package com.guany.myscaffold.common;

import tk.mybatis.mapper.genid.GenId;

import java.util.UUID;

/**
 * @Auther: guany
 * @Date: 2023/02/12
 */
public class UUIdGenId implements GenId<String> {
    public UUIdGenId() {
    }

    @Override
    public String genId(String table, String column) {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
