package com.ran.designpattern.decorate;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * LowCaseInputStream
 * 创建新的装饰者，将输入流所有大写转小写
 * @author rwei
 * @since 2023/6/15 17:58
 */
public class LowCaseInputStream extends FilterInputStream {
    public LowCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return c == -1? c:Character.toLowerCase((char) c);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off; i < off + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}
