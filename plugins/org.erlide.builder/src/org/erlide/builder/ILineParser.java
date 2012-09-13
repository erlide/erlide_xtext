package org.erlide.builder;

public interface ILineParser<T> {

    T parseLine(String line);

}
