package com.ja.visitor_reg.common.util;

/**
 * 位操作工具类
 */
public class BitUtil {

    private BitUtil() {
        throw new Error("Do not BitUtil instance");
    }

    /**
     * 查询哪一位未0
     *
     * @param value  需要查询的值
     * @param nStart 开始位置
     * @param nEnd   结束位置
     * @return int 哪一位 (从0开始,负数代表没有)
     */
    public static int query_BitIsZero(int value, int nStart, int nEnd) {
        int nBit = -1;
        //check
        if (nStart < 0 || nEnd < 0) {
            return -2;
        }
        if (nStart > nEnd) {
            return -3;
        }
        if (nStart > 15 || nEnd > 15) {
            return -4;
        }
        for (; nStart < nEnd; nStart++) {
            if (0 == (value & (0x01 << nStart))) {
                nBit = nStart;
                break;
            }
        }
        return nBit;
    }

    /**
     * 设置bit的值
     *
     * @param value 值
     * @param pos 位置 (从0开始)
     * @return int 设置后的值
     */
    public static int set_BitValue(int value, int pos){
        return value | (1 << pos);
    }

    /**
     * 清除bit的值
     *
     * @param value 值
     * @param pos 位置 (从0开始)
     */
    public static int clear_BitValue(int value, int pos){
        return value & (~(1 << pos));
    }
}
