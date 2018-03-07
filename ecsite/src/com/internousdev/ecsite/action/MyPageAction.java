package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{
            public Map<String,Object> session;
            private MyPageDAO myPageDAO = new MyPageDAO();
            private MyPageDTO myPageDTO = new MyPageDTO();
            private String deleteFlg;
            private String message;
			private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();


            public String execute() throws SQLException{

            	if (!session.containsKey("id")) {
            		return ERROR;
            	}

            	if(deleteFlg == null) {

            		String item_transaction_id = session.get("id").toString();
            		String user_master_id = session.get("login_user_id").toString();


            		myPageList= myPageDAO.getMyPageUserInfo(item_transaction_id,
            				user_master_id);

              //商品履歴を削除する場合
            	}else if(deleteFlg.equals("1")) {
            		delete();
            	}
            	String result = SUCCESS;
            	return result;
            }

            public void delete() throws SQLException{

            	String item_transaction_id = session.get("id").toString();
            	String user_master_id = session.get("login_user_id").toString();

            	int res = myPageDAO.buyItemHistoryDelete(item_transaction_id,
            			user_master_id);

            	if(res > 0) {
            		myPageList = null;
            		setMessage("商品情報を正しく削除しました。");
            	}else if(res == 0) {
            		setMessage("商品情報の削除に失敗しました。");

            	}
            }

            public String getDeleteFlg() {
            	return deleteFlg;

            }

            public void setDeleteFlg(String deleteFlg) {
            	this.deleteFlg = deleteFlg;
            }

            @Override
            public void setSession(Map<String,Object> session) {
            	this.session = session;
            }

            public ArrayList<MyPageDTO> getMyPageList(){
            	return this.myPageList;
            }

            public String getMessage() {
            	return this.message;
            }

            public void setMessage(String messsage) {
            	this.message = message;
            }

			public MyPageDTO getMyPageDTO() {
				return myPageDTO;
			}

			public void setMyPageDTO(MyPageDTO myPageDTO) {
				this.myPageDTO = myPageDTO;
			}


}