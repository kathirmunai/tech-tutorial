package com.kathirmunai.cms.multiple.ds.exception;

public class KathirmunaiException extends Throwable {

	private static final long serialVersionUID = 1L;

	public KathirmunaiException() {
	}

	public KathirmunaiException(String msg) {
		super(msg);
	}

	public KathirmunaiException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public KathirmunaiException(Throwable cause) {
		super(cause);
	}

}