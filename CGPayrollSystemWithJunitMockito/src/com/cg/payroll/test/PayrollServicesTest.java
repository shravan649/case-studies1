package com.cg.payroll.test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import com.cg.payroll.bean.Associate;
import com.cg.payroll.bean.BankDetails;
import com.cg.payroll.bean.Salary;
import com.cg.payroll.daoservices.PayrollDAOServices;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
import com.cg.payroll.utilities.PayrollUtility;
public class PayrollServicesTest {
	private static PayrollServices payrollServices;
	private static PayrollDAOServices mockDaoServices;
	ArrayList<Associate> associateList=new ArrayList<>();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mockDaoServices=Mockito.mock(PayrollDAOServices.class);
		payrollServices=new PayrollServicesImpl(mockDaoServices);
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		mockDaoServices=null;
		payrollServices=null;
	}
	@Before
	public void setUp() throws Exception {
		Associate associate1=new Associate(111, 50000, "shravan", "kumar", "training", "analyst", "GSDGK", "shravan@gmail.com", 
				new Salary(22000, 500, 500), new BankDetails(543154, "sbi", "sbin0823"));
		Associate associate2=new Associate(112, 12000, "ss", "k", "training", "analyst", "ILSAD", "ssk@gmail.com", 
				new Salary(25000, 500, 500), new BankDetails(123354, "sbi", "sbin0001"));
		ArrayList<Associate> associateList=new ArrayList<>();
		associateList.add(associate1);
		associateList.add(associate2);
		Mockito.when(mockDaoServices.getAssociate(111)).thenReturn(associate1);
		Mockito.when(mockDaoServices.getAssociate(112)).thenReturn(associate2);
	}
	@After
	public void tearDown() throws Exception {
		associateList.clear();
	}
	@Test 
	public void testAcceptAssociateDetailsForValidDate() throws PayrollServicesDownException{
		int expectedId=113;
		int actualId=payrollServices.acceptAssociateDetails("chitraksh", "s", "chitraksh@gmail.com", "training", "hr", "IHASJSA", 13000, 9000, 500, 500, 1546416, "sbi", "sbin003");
		Mockito.verify(mockDaoServices).insertAssociate();
		Assert.assertEquals(expectedId, actualId);
	}
	@Test
	public void testCalculateNetSalaryForValidData()throws PayrollServicesDownException,AssociateDetailsNotFoundException{

	}
	@Test(expected=AssociateDetailsNotFoundException.class)
	public void testCalculateNetSalaryForInvalidData() throws AssociateDetailsNotFoundException,PayrollServicesDownException{

	}
	@Test(expected=AssociateDetailsNotFoundException.class)
	public void testGetAssociateDetailsForInvalidData()throws AssociateDetailsNotFoundException,PayrollServicesDownException{
		payrollServices.getAssociateDetails(113);
		Mockito.verify(payrollServices.getAssociateDetails(113));
	}
	@Test
	public void testGetAssociateDetailsForValidData()throws AssociateDetailsNotFoundException,PayrollServicesDownException{
		Associate expectedAssociate=new Associate(111, 50000, "shravan", "kumar", "training", "analyst", "GSDGK", "shravan@gmail.com", 
				new Salary(22000, 500, 500), new BankDetails(543154, "sbi", "sbin0823"));
		Associate actualAssociate=payrollServices.getAssociateDetails(111);
		Mockito.verify(mockDaoServices).getAssociate(111);
		Assert.assertEquals(expectedAssociate, actualAssociate);
	}
}
