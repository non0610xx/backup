package com.internousdev.ecsite2.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;


public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;

	public String execute() {
		String result ="login";
		if (session.containsKey("id")) {
			BuyItemDAO
		}
	}

}
