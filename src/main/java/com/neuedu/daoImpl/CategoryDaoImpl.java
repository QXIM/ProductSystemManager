package com.neuedu.daoImpl;



import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.JDBC;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
	
		Connection con=null;
		PreparedStatement st=null;
		//ʵ����������
		try {
			//��ȡ����
			con=JDBC.conn();
			//��ȡstatement����ִ��sql���
			
			System.out.println(category);
			int _id=category.getCategoryid();
			String name=category.getName();
			int parent_id=category.getParent_id();
			int  status=category.getStatus();
			int sort_order=category.getSort_order();
			
			System.out.println(category);
			String sql="insert into category(name,parent_id,status,sort_order,create_time,update_time)  values(?,?,?,?,now(),now())";
			st= con.prepareStatement(sql);
			//'"+name+"','"+price+"','"+image+"','"+stock+"','"+detail+"'
			st.setString(1, name);
			st.setInt(2, parent_id);
			st.setInt(3, status);
			st.setInt(4, sort_order);
			
			
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
	public PageModel<Category> findAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageModel<Category> PageModel=new PageModel<Category>();
			Connection con=null; 
			PreparedStatement st =null;
			ResultSet re=null;
			
			try {
				System.out.println("����dao");	
				con=JDBC.conn();
				
				String sqlcount="select count(categoryid) from category";
				st=con.prepareStatement(sqlcount);
				 
				re=st.executeQuery();
				System.out.println("2");	
				if(re.next()) {
					
				int totalcount= re.getInt(1);//�ܼ�¼
				//�������Ҷ
			int totalPage=(totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize+1);
			PageModel.setTotalPage(totalPage);
			System.out.println("3");
				}
				
				
				String sql=" select categoryid,parent_id,"
						+ "name,status,sort_order,create_time,update_time "
						+ "from category limit ?,? " ;
				st=con.prepareStatement(sql);
				 st.setInt(1,(pageNo-1)*pageSize);
				 st.setInt(2,pageSize);
				 
				re=st.executeQuery();
				List<Category> pros=new ArrayList<Category>();
				System.out.println("1");	
				while(re.next()) {
					int categoryid=re.getInt("categoryid");
					String  name=re.getString("name");
					int parent_id=re.getInt("parent_id");
					int status=re.getInt("status");
					int sort_order=re.getInt("sort_order");
					int create_time=re.getInt("create_time");
					int update_time=re.getInt("update_time");
					
					Category pro=new Category();
					pro.setCategoryid(categoryid);
					pro.setName(name);
					pro.setParent_id(parent_id);
					pro.setStatus(status);
					pro.setSort_order(sort_order);
					pro.setCreate_time(create_time);
					pro.setUpdate_time(update_time);
					pros.add(pro);
					
					System.out.println("4");
				}
				PageModel.setDate(pros);
				
			}  catch (SQLException e) {
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
		return PageModel;	
			
		}
		
		
		
	

	private long now() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		
		Connection con=null;//
		PreparedStatement st=null;
		//ʵ����������
		try {
			//��ȡ����
			con=JDBC.conn();
			//��ȡstatement����ִ��sql���
			String sql="delete	from category where categoryid= ?";
			st= con.prepareStatement(sql);
			st.setInt(1, id);
			st.execute();		
			
		}catch (SQLException e) {
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
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		
		Connection con=null;//
		PreparedStatement st=null;
		//ʵ����������
		try {
			//��ȡ����
			con=JDBC.conn();
			//��ȡstatement����ִ��sql���
			
			System.out.println("t1");
			int _id=category.getCategoryid();
			String name=category.getName();
			int  parent_id=category.getParent_id();
			int status=category.getStatus();
			int sort_order=category.getSort_order();
			
			
			
			String sql="update	category set name=? , parent_id=? ,status=?, sort_order=?   where categoryid=? ";
			st= con.prepareStatement(sql);
			st.setString(1, name);
			st.setInt(2, parent_id);
			st.setInt(3, status);
			st.setInt(4, sort_order);
			st.setInt(5, _id);
			System.out.println("t2");
			
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
		return true;
	}

	@Override
	public Category findcategoryById(int id) {
		// TODO Auto-generated method stub
		

		Category category=new Category();
		Connection con=null;
		PreparedStatement st =null;
		ResultSet re=null;
		
		try {
			
			con=JDBC.conn();
			
			String sql="select * from category where categoryid=?";
			st=con.prepareStatement(sql);
			st.setInt(1, id);
			
			re=st.executeQuery();
			if(re.first()){
				if(re.getInt("categoryid")==id) {
					
					
					category.setCategoryid(id);
					category.setName(re.getString("name"));
					category.setParent_id(re.getInt("parent_id"));
					category.setStatus(re.getInt("status"));
					category.setSort_order(re.getInt("sort_order"));	
					
					System.out.println("���ҵ�"+category);
				return category;
				}else {
					
				}
			}
			
		}  catch (SQLException e) {
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
	return category;
		
		
		
		
	}

}