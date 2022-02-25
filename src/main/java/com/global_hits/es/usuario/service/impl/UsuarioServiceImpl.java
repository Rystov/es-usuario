package com.global_hits.es.usuario.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global_hits.es.usuario.model.User;
import com.global_hits.es.usuario.repository.contract.IUsuarioDAO;
import com.global_hits.es.usuario.service.contract.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	IUsuarioDAO repo;

	@Override
	public User adduser(User body) throws SQLException {
		// TODO Auto-generated method stub
	return this.repo.adduser(body);	
	}

	@Override
	public void deleteUser(String userId) throws SQLException {
		// TODO Auto-generated method stub
		 this.repo.deleteUser(userId);
	}

	@Override
	public List<User> getUser() throws SQLException {
		// TODO Auto-generated method stub
		return this.repo.getUser();
	}

	@Override
	public User getUserById(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return this.repo.getUserById(userId);
	}

	@Override
	public User updateUser(User body) throws SQLException {
		// TODO Auto-generated method stub
		return this.repo.updateUser(body);
	}


}
