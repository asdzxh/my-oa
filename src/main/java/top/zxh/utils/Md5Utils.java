package top.zxh.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Date:2023/3/1
 * Author：zxh
 * Description: Md5 加密工具类
 */
public class Md5Utils {

    /**
     * 对源数据生成 MD5 摘要
     *
     * @param source 源数据
     * @return MD5 摘要
     */
    public static String md5Digest(String source) {
        return DigestUtils.md2Hex(source);
    }

    /**
     * 对源数据加盐混淆后生成 MD5 摘要
     *
     * @param source 源数据
     * @param salt   盐值
     * @return MD5 摘要
     */
    public static String md5Digest(String source, Integer salt) {
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + salt);
        }
        String target = new String(chars);
        return DigestUtils.md5Hex(target);
    }
}
