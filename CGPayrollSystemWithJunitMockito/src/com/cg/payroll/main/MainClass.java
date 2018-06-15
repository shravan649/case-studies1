package com.cg.payroll.main;

import java.util.List;
import java.util.Scanner;

import com.cg.payroll.bean.Associate;
import com.cg.payroll.bean.BankDetails;
import com.cg.payroll.bean.Salary;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

public class MainClass {

	public static void main(String[] args) {	
		try{
		PayrollServices payrollServices = new PayrollServicesImpl();
		int associateId;
		int key=0;
		Scanner sc=new Scanner(System.in);
		while(key!=7){
			System.out.println("Enter\n1 : Insert New employee"+"\n"+"2 : Update Associate Details"+"\n"+
					"3 : To get Associate Details of employee"+"\n"+
					"4 : To get  All Associate Details of employee"+"\n"+"5 : To Calculate salary of employee"+"\n"+
					"6 : To delete an employee"+"\n"+"7 : Exit");
			key=sc.nextInt();
			switch(key){
			case 1: System.out.println("Enter First Name : ");
			String firstName=sc.next();
			System.out.println("Enter Last Name");
			String lastName=sc.next();
			System.out.println("Enter Designation");
			String designation=sc.next();
			System.out.println("Enter Department");
			String department=sc.next();
			System.out.println("Enter Pancard Number");
			String pancard=sc.next();
			System.out.println("Enter EmailId");
			String emailId=sc.next();
			System.out.println("Enter YearlyInvestment");
			int yearlyInvestmentUnder80C=sc.nextInt();
			System.out.println("Enter Basic Salary");
			float basicSalary=sc.nextFloat();
			System.out.println("Enter epf");
			float epf=sc.nextFloat();
			System.out.println("Enter cpf");
			float companyPf=sc.nextFloat();
			System.out.println("Enter Account number");
			int accountNumber=sc.nextInt();
			System.out.println("Enter Bank Name");
			String bankName=sc.next();
			System.out.println("Enter IFSC Code");
			String ifscCode=sc.next();
			associateId=payrollServices.acceptAssociateDetails(firstName, lastName, emailId, department, designation, pancard, yearlyInvestmentUnder80C, basicSalary, epf, companyPf, accountNumber, bankName, ifscCode);
			System.out.println(associateId);
			break;
			case 2: System.out.println("Enter the Details to be Updated");
			System.out.println("Enter Associate ID : ");
			int id=sc.nextInt();
			System.out.println("Enter First Name : ");
			String firstName1=sc.next();
			System.out.println("Enter Last Name");
			String lastName1=sc.next();
			System.out.println("Enter Designation");
			String designation1=sc.next();
			System.out.println("Enter Department");
			String department1=sc.next();
			System.out.println("Enter Pancard Number");
			String pancard1=sc.next();
			System.out.println("Enter EmailId");
			String emailId1=sc.next();
			System.out.println("Enter YearlyInvestment");
			int yearlyInvestmentUnder80C1=sc.nextInt();
			System.out.println("Enter Basic Salary");
			float basicSalary1=sc.nextFloat();
			System.out.println("Enter epf");
			float epf1=sc.nextFloat();
			System.out.println("Enter cpf");
			float companyPf1=sc.nextFloat();
			System.out.println("Enter Account number");
			int accountNumber1=sc.nextInt();
			System.out.println("Enter Bank Name");
			String bankName1=sc.next();
			System.out.println("Enter IFSC Code");
			String ifscCode1=sc.next();
			payrollServices.updateAssociateDetails(new Associate(id, yearlyInvestmentUnder80C1, firstName1, lastName1, department1, designation1, pancard1, emailId1, new Salary(basicSalary1, epf1, companyPf1), new BankDetails(accountNumber1, bankName1, ifscCode1)));
			System.out.println("Updated Values");
			System.out.println(payrollServices.getAssociateDetails(id).toString());
			break;
			case 3: System.out.println("Enter the AssociateId of employee to get the Details");
			associateId=sc.nextInt();
			System.out.println(payrollServices.getAssociateDetails(associateId).toString());
			break;
			case 4: System.out.println("Following are the Employee details of Entire Array");
			List<Associate> associate=payrollServices.getAllAssociateDetails();
			for(Associate associate1:associate)
			System.out.println(associate1);
			break;
			case 5: System.out.println("Enter the AssociateId of employee to calculate the salary");
			associateId=sc.nextInt();
			System.out.println(payrollServices.calculateNetSalary(associateId));
			break;
			case 6: System.out.println("Enter the AssociateId of employee to be deleted");
			associateId=sc.nextInt();
			System.out.println(payrollServices.deleteAssociateDetails(associateId));
			case 7: System.out.println("Exit");
			break;
			default:
			break;
			}
		}
		}
		catch(AssociateDetailsNotFoundException e){
			e.printStackTrace();
		}
		catch(PayrollServicesDownException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
}
}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*	try {
			PayrollServices payrollServices=new PayrollServicesImpl();
			int associateId=payrollServices.acceptAssociateDetails("Shravan", "kumar", "shravan.com", "java", "analyst", "IJSJKLASJ", 1000000, 15015, 500, 500, 146541566, "vskp", "CITI0092");
			int associateId1=payrollServices.acceptAssociateDetails("Rohit", "kumar", "rohit.com", "java", "analyst", "IJSJKLASJ", 100000, 16010, 500, 500, 146541566, "vskp", "CITI0092");
			payrollServices.getAssociateDetails(111);
			payrollServices.deleteAssociateDetails(114);
			System.out.println(payrollServices.deleteAssociateDetails(114));
			System.out.println(associateId);
			System.out.println(payrollServices.getAssociateDetails(associateId).getFirstName());
			System.out.println(payrollServices.getAssociateDetails(associateId).getLastName());
			System.out.println("Salary  :"+payrollServices.calculateNetSalary(associateId));
			System.out.println("Monthly Tax :"+payrollServices.getAssociateDetails(associateId).getSalary().getMonthlyTax());
			System.out.println("Net Salary :"+payrollServices.getAssociateDetails(associateId).getSalary().getNetSalary());
			System.out.println(associateId1);
			System.out.println(payrollServices.getAssociateDetails(associateId1).getFirstName());
			System.out.println(payrollServices.getAssociateDetails(associateId1).getLastName());
			System.out.println("Salary  :"+payrollServices.calculateNetSalary(associateId1));
			System.out.println("Monthly Tax :"+payrollServices.getAssociateDetails(associateId1).getSalary().getMonthlyTax());
			System.out.println("Net Salary :"+payrollServices.getAssociateDetails(associateId1).getSalary().getNetSalary());
		} catch (AssociateDetailsNotFoundException e) {
			System.out.println("associate not found");
		} catch (Exception e) {
			System.out.println("associateid not available");
			e.printStackTrace();
		}
		
}
}*/

























//		int yearlyInvestment=50000;
//		String firstName="Shravan";
//		Associate associate=searchAssociateId(yearlyInvestment,firstName);
//		if(associate!=null)
//		System.out.println(associate.getFirstName()+" has greater than "+yearlyInvestment);
//		else
//		System.out.println("Not found");
//		}
//		public static Associate searchAssociateId(int yearlyInvestment,String firstName){
//		Associate[] associateteam=new Associate[5];
//		associateteam[0]=new Associate(101, 60000, "Shravan", "Kumar", "java", "Analyst", "ILAKSJLKLAS", "abc@asd.com",new Salary(15000, 500, 1000, 2000, 500, 200, 1000, 1000, 100, 17000, 15500),new Bank(12121212,"CITI","CITI000021")) ;
//		associateteam[1]=new Associate(102, 8000, "Chitraksh", "Singisetti", "Java", "Analyst", "NJIH8659HGJ", "def@abc.com",new Salary(15000, 500, 1000, 2000, 500, 100, 2000, 13000, 1030, 17040, 16500),new Bank(12121222,"CITI","CITI000022"));
//		associateteam[2]=new Associate();
//		for (Associate associate : associateteam) 
//		if(associate!=null&&associate.getFirstName()==firstName&&associate.getYearlyInvestmentUnder80C()>=yearlyInvestment)
//		return associate;
//		return null;
//		}
		
//}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	//	int associateIdToBeSearch=222;
	//	Associate associate=searchAssociate(associateIdToBeSearch);
	//	if(associate!=null)
	//		System.out.println(associate.getFirstName()+" "+associate.getLastName());
	//	else
	//		System.out.println("associate details with Id"+associateIdToBeSearch+"Not found");
	  //  }
//public static Associate searchAssociate(int associateID){
	//	Associate [] associates=new Associate[5];
	//	associates[0] = new Associate(111, 25000, "Shravan", "Kumar", "java", "Analyst", "ILASNJ717", "abc.com");
	//	associates[1] = new Associate(222, 10000, "Sindhu", "Kalakonda", "java", "Analyst", "ILASNJ717", "abc.com");
	//	for(Associate associate : associates){
	//		if(associate!=null&&associate.getAssociateId()==associateID)
	//			return associate;
	//		if(associate.getFirstName()=="Shravan"&&associate.getYearlyInvestmentUnder80C()==25000);
	//			System.out.println(associate.getEmailId());
			
	//	}
	//	return null;
//}		

//}		
		
		
		
		
		
		
		
//		Associate associate1=new Associate();
//		associate1.setFirstName("shravan");
//		Associate associate2 = new Associate(101,150000,"shravan","kumar","java","analyst","500090","asdf.com");
//		Associate associate3 = new Associate(102,150000,"sindhu","kalakonda","java","analyst","500090","asdf.com");

//		System.out.println(associate1.getFirstName());
//		System.out.println(associate3.getFirstName());

//	}

//}
