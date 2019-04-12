package homework13.cripto;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CryptoOutStrem extends FilterOutputStream {
 private byte[] key;
 private int currenkey;

     public CryptoOutStrem(OutputStream out) {
        super(out);
    }

    public CryptoOutStrem(OutputStream out, byte[] key) {
        super(out);
        this.key = key;

    }

    @Override
    public void write(int b) throws IOException {
         ///шифрование
        super.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        super.write(b, off, len);
    }

   }
