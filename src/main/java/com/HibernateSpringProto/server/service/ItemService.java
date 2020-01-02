package com.HibernateSpringProto.server.service;

import java.util.Date;
import java.util.List;

import com.HibernateSpringProto.server.model.User;

public interface ItemService {
	public List <String> getAllItems(long itemId);
	public void addItem (long id, String desc, double value, boolean available, User idCreator, Date CreationDate);
}
