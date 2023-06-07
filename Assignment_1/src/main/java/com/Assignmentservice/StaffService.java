package com.Assignmentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Assignment.dao.StaffDao;
import com.Assignment.model.Staff;

@Service
public class StaffService {
	
	@Autowired
	StaffDao sd;
	//1.....................................................
	public List<Staff> alrecord()
	{
		return sd.allrecord();
	}
	
	//2.....................................................

	public Staff staffid_3(int staffid)
	{
		return sd.staffid_3(staffid);
	}

	//3.....................................................

	public String insertstaff(Staff s) {
		return sd.insertstaff(s);
	
	}
	
	//4.....................................................

	public List<Staff> salary_gt_staff()
	{
		return sd.salary_gt_staff();
	}
	
	
	//5.....................................................

		public List<Staff> expbetween_staff()
		{
			return sd.expbetween_staff();
		}
		
	//6.....................................................
	public List<Staff> maxsalary()
	{
			return sd.maxsalary();
	}
	
	//7.....................................................

	public String updatesalary(int staffid)
	{
			return sd.updatesalary(staffid);
	}
	
	//8......................................................................
	public String minexp()
	{
			return sd.minexp();
	}
	
	//9......................................................................
		public List<Staff> profiletrainer()
		{
				return sd.profiletrainer();
		}
		
		//10......................................................................
				public List<Staff> notprofiletrainer()
				{
						return sd.notprofiletrainer();
				}


}
