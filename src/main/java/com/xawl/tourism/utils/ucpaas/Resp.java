package com.xawl.tourism.utils.ucpaas;

import com.xawl.tourism.utils.ucpaas.rest.models.TemplateSMS;

public class Resp {
	private String respCode;
	
	private String failure;
	
	private TemplateSMS templateSMS;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getFailure() {
		return failure;
	}

	public void setFailure(String failure) {
		this.failure = failure;
	}

	public TemplateSMS getTemplateSMS() {
		return templateSMS;
	}

	public void setTemplateSMS(TemplateSMS templateSMS) {
		this.templateSMS = templateSMS;
	}
	
}
