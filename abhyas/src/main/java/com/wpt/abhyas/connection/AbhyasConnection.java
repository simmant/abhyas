package com.wpt.abhyas.connection;

import java.io.FileInputStream;

public class AbhyasConnection extends FileConnections{

	public FileInputStream getUserConnection() {
		return super.getUserConnection();
	}
	
	public FileInputStream getQuestionsConnection() {
		return super.getQuestionsConnection();
	}
	public FileInputStream getAnsConnection() {
		return getAnswer();
	}
}
