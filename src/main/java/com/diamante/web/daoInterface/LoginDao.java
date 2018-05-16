package com.diamante.web.daoInterface;

import com.diamante.web.model.Login;

public interface LoginDao {
	public Login validate(String username, String password);

}
