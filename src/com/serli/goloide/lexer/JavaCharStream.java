package com.serli.goloide.lexer;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import org.netbeans.spi.lexer.LexerInput;

/**
 *
 * @author david
 */

public class JavaCharStream extends fr.insalyon.citi.golo.compiler.parser.JavaCharStream {

    private LexerInput input;

    static boolean staticFlag;

    public JavaCharStream(LexerInput input) {
        super((Reader)null);
        this.input = input;
    }

    JavaCharStream(Reader stream, int i, int i0) {
        super((Reader)null, i, i0);
        throw new UnsupportedOperationException("Not yet implemented");
    }

    JavaCharStream(InputStream stream, String encoding, int i, int i0) throws UnsupportedEncodingException {
        super((InputStream)null, i, i0);
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public char BeginToken() throws IOException {
        return readChar();
    }

    @Override
    public String GetImage() {
        return input.readText().toString();
    }

    @Override
    public char[] GetSuffix(int len) {
        if (len > input.readLength()) {
            throw new IllegalArgumentException();
        }
        return input.readText(input.readLength() - len, input.readLength()).toString().toCharArray();
    }

    @Override
    public void ReInit(Reader stream, int i, int i0) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void ReInit(InputStream stream, String encoding, int i, int i0) throws UnsupportedEncodingException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void backup(int i) {
        input.backup(i);
    }

    @Override
    public int getBeginColumn() {
        return 0;
    }

    @Override
    public int getBeginLine() {
        return 0;
    }

    @Override
    public int getEndColumn() {
        return 0;
    }

    @Override
    public int getEndLine() {
        return 0;
    }

    @Override
    public char readChar() throws IOException {
        int result = input.read();
        if (result == LexerInput.EOF) {
            throw new IOException("LexerInput EOF");
        }
        return (char) result;
    }
}