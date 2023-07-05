package com.guany.myscaffold.constant;

/**
 * 常量
 *
 * @Auther: guany
 * @Date: 2023/04/28
 */
public class Constant {

    /**
     * 未删除
     */
    public static final int DELETED_FALSE_0 = 0;

    /**
     * 删除标志
     */
    public static final int DELETED_TRUE_1 = 1;

    /**
     * 否
     */
    public static final String NO = "0";

    /**
     * 是
     */
    public static final String YES = "1";

    /**
     * null
     */
    public static final String NULL_STR = "null";

    /**
     * 常量类是静态成员的集合,不需要实例化.
     */
    private Constant() {
        throw new IllegalStateException("Utility class");
    }
}
