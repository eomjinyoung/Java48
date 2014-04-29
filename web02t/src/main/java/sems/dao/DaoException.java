package sems.dao;

@SuppressWarnings("serial")
public class DaoException extends Error {
	public DaoException(String msg) {
		super(msg);
	}
	
	public DaoException(Throwable cause) {
		super(cause);
	}
}
