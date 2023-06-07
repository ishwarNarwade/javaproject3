package com.Assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Assignment.model.Staff;
import com.Assignmentservice.StaffService;

@RestController
public class StaffController {
	
	@Autowired
	StaffService ss;
	
	
	//1......................................................................
	@GetMapping("dispall")
	public List<Staff> allrecord()
	{
		return ss.alrecord();
	}

	//2......................................................................
	@GetMapping("onerecord/{staffid}")
	public Staff staffid_3(@PathVariable int staffid )
	{
		return ss.staffid_3(staffid);
	}
	
	
	//3......................................................................

	@PostMapping("insert")
	public String insertstaff(@RequestBody Staff s )
	{
		return ss.insertstaff(s);
	}
	
	
	//4......................................................................

		@GetMapping("salarygt")
		public List<Staff> salary_gt_staff()
		{
			return ss.salary_gt_staff();
		}
		
		//5......................................................................

		@GetMapping("expbetween")
		public List<Staff> expbetween_staff()
		{
				return ss.expbetween_staff();
		}
	
		//6......................................................................

				@GetMapping("maxsalary")
				public List<Staff> maxsalary()
				{
						return ss.maxsalary();
				}
	
		//7......................................................................

		@PutMapping("update/{staffid}")
		public String updatesalary(@PathVariable int staffid)
		{
				return ss.updatesalary(staffid);
		}
		
		//8......................................................................

		@GetMapping("minexp")
		public String minexp()
		{
				return ss.minexp();
		}
		
		//9......................................................................

				@GetMapping("profiletrainer")
				public List<Staff> profiletrainer()
				{
						return ss.profiletrainer();
				}
				
	//10......................................................................

				@GetMapping("notprofiletrainer")
				public List<Staff> notprofiletrainer()
				{
						return ss.notprofiletrainer();
				}


	
}
