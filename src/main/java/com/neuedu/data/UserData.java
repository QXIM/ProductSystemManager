package com.neuedu.data;

import java.util.ArrayList;
import java.util.List;


import com.neuedu.entity.User;

public class UserData {
	
	public static List<User> users=new ArrayList<User>();
	public UserData() {
		User user = new User(1, "admin", "admin");
		users.add(user);
	}
	
	
	
	
	
	

}
