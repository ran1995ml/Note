package com.ran.javase.designpattern.decorator.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * LowerCaseInputStream
 * 自定义IO，把输入的大写字符转成小写
 * @author rwei
 * @since 2023/4/3 09:48
 */
public class LowerCaseInputStream extends FilterInputStream {
    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    //针对字节
    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }
}
