package com.neuedu.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.neuedu.dao.UserDao;

import com.neuedu.entity.JDBC;
import com.neuedu.entity.User;



public class UserDaoImpl2 implements UserDao{
	
	
	public User checkUser(String name, String password) {
		
		User accs=null;
		Connection con=null;
		PreparedStatement st = null;
		ResultSet re=null;
		
		try {
			
			con=JDBC.conn();
			
			String sql="select * from account "
			+ " where username=? and userpassword=? ";
			st=con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, password);
			System.out.println("com/neuedu/dao");
			
			re=st.executeQuery();
			if(re.first()) {
				
				String _username = re.getString("username");
				String _password = re.getString("userpassword");
				int accountid=re.getInt("accountid");
				
				accs = new User( accountid,_username, _password);
				
				return accs;
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				JDBC.close(con, st, re);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
		
		
		
	}

	public static List<User> findAll(){
		JDBC JDBC=new JDBC();
		List<User> accs=new ArrayList<User>();
		Connection con=null;
		Statement st =null;
		ResultSet re=null;
		
		try {
			
			con=JDBC.conn();
			st=con.createStatement();
			String sql="select username,userpassword from account     " ;
			re=st.executeQuery(sql);
			
			while(re.next()) {
				int accountid=re.getInt("accountid");
				String  username=re.getString("username");
				String userpassword=re.getString("userpassword");
				User acc=new User();
				acc.setId(accountid);
				acc.setName(username);
				acc.setPassword(userpassword);
				accs.add(acc);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				JDBC.close(con, st, re);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	return accs;

}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		
		Connection con=null;//
		PreparedStatement st=null;
		//ʵ����������
		try {
			//��ȡ����
			con=JDBC.conn();
			//��ȡstatement����ִ��sql���
			
			
			int _id=user.getId();
			String name=user.getName();
			String password=user.getPassword();
			
			
			String sql="insert into account(username,userpassword)  values(?,?)";
			st= con.prepareStatement(sql);
			//'"+name+"','"+price+"','"+image+"','"+stock+"','"+detail+"'
			st.setString(1, name);
			st.setString(2, password);
			st.execute();		
			System.out.println("��ӳɹ�");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBC.close(con, st);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
		
	}

	@Override
	public void updateTokenByAccountid(String token,User user) {
		// TODO Auto-generated method stub
		
		Connection con=null;//
		PreparedStatement st=null;
		//ʵ����������
		try {
			//��ȡ����
			con=JDBC.conn();
			//��ȡstatement����ִ��sql���
			System.out.println(user);
			String sql="update	account set token=?  where accountid=?";
			st= con.prepareStatement(sql);
			st.setString(1,token);
			st.setInt(2, user.getId());
			System.out.println(sql);
			st.execute();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBC.close(con, st);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@SuppressWarnings("resource")
	@Override
	public String findTokenByAccountid(int Accountid) {
		// TODO Auto-generated method stub
		
		
		
		
		Connection con=null;
		PreparedStatement st =null;
		ResultSet re=null;
		
		try {
			
			con=JDBC.conn();
			String sql="select * from account where accountid=? " ;
			st=con.prepareStatement(sql);
			st.setInt(1, Accountid);
			re=st.executeQuery();
			
			if(re.first()) {
				
				String token = re.getString("token");
				
				return token;
				
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				JDBC.close(con, st, re);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	
		
		
		
	}

	
}
