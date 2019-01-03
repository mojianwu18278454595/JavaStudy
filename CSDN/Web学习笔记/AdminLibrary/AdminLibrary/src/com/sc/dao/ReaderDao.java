package com.sc.dao;

import java.util.List;

import com.sc.domain.Reader;

public interface ReaderDao
{

	public Reader login(Reader reader);

	public String add(Reader reader, Integer rd_type);

	public List<Reader> select(Reader reader);

	public Reader edit(Reader reader,Integer readerType);

	public Reader operation(Reader editReader, int number);

}
