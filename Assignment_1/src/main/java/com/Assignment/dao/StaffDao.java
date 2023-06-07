package com.Assignment.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Assignment.model.Staff;


@Repository
public class StaffDao {

	
	@Autowired
	SessionFactory sf;
	//1.....................................................

	public List<Staff> allrecord()
	{
		
		Session s=sf.openSession();
		Criteria c=s.createCriteria(Staff.class);
		List<Staff>l=c.list();
		s.close();
		return l;
	}
	//2.....................................................

	public Staff staffid_3(int staffid) {
		Session s=sf.openSession();
		
		Transaction tr=s.beginTransaction();
		Staff sr=s.get(Staff.class, staffid);	
		tr.commit();
		s.close();
		
		return sr;
	}
	//3.....................................................

	public String insertstaff(Staff s) {
		Session s1=sf.openSession();
		Transaction tr=s1.beginTransaction();
		
		s1.save(s);
		tr.commit();
		s1.close();
		return "!!----inserted successfully....!!!";
	}
	
	//4.....................................................

	public List<Staff> salary_gt_staff()
	{
		Session s=sf.openSession();
		Criteria c=s.createCriteria(Staff.class);
		c.add(Restrictions.gt("salary", 20000));
		List<Staff>l=c.list();
		s.close();
		return l;
	}
	
	//5.....................................................

			public List<Staff> expbetween_staff()
			{
				Session s=sf.openSession();
				Criteria c=s.createCriteria(Staff.class);
				c.add(Restrictions.between("experience", 10, 20));
				List<Staff>l=c.list();
				s.close();
				return l;

			}
	//6.....................................................

	public List<Staff> maxsalary() {
		Session s=sf.openSession();
		Criteria c=s.createCriteria(Staff.class);
		List<Staff>l=c.list();
		int max=0;
		for (Staff st : l) {
			System.out.println(st.getSalary());
			if(st.getSalary()>max)
			{
				max=st.getSalary();
			}
			
		}
		
		Criteria c1=s.createCriteria(Staff.class);
		c1.add(Restrictions.eq("salary", max));
		List<Staff>sr=c1.list();	
		s.close();
		return sr;
	}
	
	//7.....................................................

		public String updatesalary(int staffid)
		{
			Session s=sf.openSession();
			Transaction tr=s.beginTransaction();
			Staff st=s.get(Staff.class, staffid);
			System.out.println(st);
			st.setSalary(98000);
			s.update(st);
			tr.commit();
			s.close();
			
			return "!!----updated successfully....!!!";
		}
		//8.....................................................

				public String minexp()
				{
					Session s=sf.openSession();
					Criteria c=s.createCriteria(Staff.class);
					List<Staff>l=c.list();
					int min=500;
					for (Staff st : l) {
						
						if(st.getExperience()<min)
						{
							min=st.getExperience();
						}
						
					}
					
					Criteria c1=s.createCriteria(Staff.class);
					c1.add(Restrictions.eq("experience", min));
					List<Staff>sr=c1.list();
					
					System.out.println(sr);
					String name="";
					for (Staff st : sr) {
						name=st.getName();
					}
			
					s.close();
					
					return "!!----min exp= "+name;
				}
	//9.....................................................

				public List<Staff> profiletrainer()
				{
					Session s=sf.openSession();
					Criteria c=s.createCriteria(Staff.class);
					
					c.add(Restrictions.eq("profile", "trainer"));
					List<Staff>sr=c.list();
					
										
					return sr;
				}
				
	//10.....................................................

				public List<Staff> notprofiletrainer()
				{
					Session s=sf.openSession();
					Criteria c=s.createCriteria(Staff.class);
					
					c.add(Restrictions.ne("profile", "trainer"));
					List<Staff>sr=c.list();
					
										
					return sr;
				}
			
}
