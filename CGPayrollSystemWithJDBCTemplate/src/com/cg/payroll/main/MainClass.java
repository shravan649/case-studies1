package com.cg.payroll.main;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.payroll.bean.Associate;
import com.cg.payroll.bean.BankDetails;
import com.cg.payroll.bean.Salary;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;


public class MainClass {

	public static void main(String[] args) throws PayrollServicesDownException, SQLException {	
/*		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("projectbeans.xml");
		PayrollServices payrollServices=(PayrollServices) applicationContext.getBean("payrollServices");



	}
}*/




















	
		try {
			ApplicationContext applicationContext=new ClassPathXmlApplicationContext("projectbeans.xml");
			PayrollServices payrollServices=(PayrollServices) applicationContext.getBean("payrollServices");

//		payrollServices.acceptAssociateDetails("s", "k", "ssk1@gmail.com", "mainframe", "fresher", "YQGH1", 13000, 23000, 500, 500, 12312, "sbi", "sbi0943");
//			Associate associate=new Associate(2, 20000, "chintoo", "s", "dotnet", "hr", "DASD23", "chint@gmail.com", new Salary(24000, 600, 600), new BankDetails(234112, "hdfc", "hdfc002"));
//			payrollServices.updateAssociateDetails(associate);
			payrollServices.deleteAssociateDetails(3);
			System.out.println("delete successfully");
		} catch (PayrollServicesDownException e) {
			e.printStackTrace();
		}
	}
}		








/*			PayrollUtility.getDBConnection();
			System.out.println("Connection open");
		} catch (ClassNotFoundException|IOException|SQLException e) {
			e.printStackTrace();
		}
	}
}*/