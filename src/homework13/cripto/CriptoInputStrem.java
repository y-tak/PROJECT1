package homework13.cripto;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CriptoInputStrem extends FilterInputStream {


    private byte[] key;
    private int currenkey;

    protected CriptoInputStrem(InputStream in) {
        super(in);
    }

    public CriptoInputStrem(InputStream in, byte[] key) {
        super(in);
        this.key = key;

    }

    @Override
    public int read(byte[] b) throws IOException {
        ///дешифрование
        return super.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return super.read(b, off, len);
    }

    public static void main(String[] args) {

    }
}
