package com.sc.service;

import java.util.List;

import com.sc.domain.Book;
import com.sc.domain.Reader;

public interface BookService
{

	public String add(Book book);

	public List<Book> select(Book book);

	public String edit(Book book);

	public String delete(Integer bk_id);

}
