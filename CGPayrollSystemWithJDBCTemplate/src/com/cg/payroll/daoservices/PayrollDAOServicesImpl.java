package com.cg.payroll.daoservices;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cg.payroll.bean.Associate;
import com.cg.payroll.bean.BankDetails;
import com.cg.payroll.bean.Salary;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.utilities.PayrollUtility;
@Component(value="payrollDAOServices")
public class PayrollDAOServicesImpl implements PayrollDAOServices {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int insertAssociate(Associate associate) throws SQLException {
		jdbcTemplate.update("insert into associate(yearlyInvestmentUnder80C,firstName, lastName, department, designation, pancard,emailId) values(?,?,?,?,?,?,?)",associate.getYearlyInvestmentUnder80C(),associate.getFirstName(),associate.getLastName(),associate.getDepartment(),associate.getDesignation(),associate.getPancard(),associate.getEmailId());
		int associateID=jdbcTemplate.queryForObject("select max(associateID)from associate", Integer.class);
		jdbcTemplate.update("insert into  salary(associateID,basicSalary, epf, companyPf) values(?,?,?,?)",associateID,associate.getSalary().getBasicSalary(),associate.getSalary().getEpf(),associate.getSalary().getCompanyPf());
		jdbcTemplate.update("insert into  bankdetails(associateID,accountNumber, bankName, ifscCode) values(?,?,?,?)",associateID,associate.getBankDetails().getAccountNumber(),associate.getBankDetails().getBankName(),associate.getBankDetails().getIfscCode());
		return associateID;	
	}
	@Override
	public boolean updateAssociate(Associate associate) throws SQLException {
		jdbcTemplate.update("update associate set yearlyInvestmentUnder80C=?,firstName=?, lastName=?, department=?, designation=?, pancard=?,emailId=? where associateID=?",associate.getYearlyInvestmentUnder80C(),associate.getFirstName(),associate.getLastName(),associate.getDepartment(),associate.getDesignation(),associate.getPancard(),associate.getEmailId(),associate.getAssociateID());
		jdbcTemplate.update("update salary set basicSalary=?, epf=?, companyPf=? where associateID=?",associate.getAssociateID(),associate.getSalary().getBasicSalary(),associate.getSalary().getEpf(),associate.getSalary().getCompanyPf());
		jdbcTemplate.update("update bankdetails set accountNumber=?, bankName=?, ifscCode=? where associateID=?",associate.getAssociateID(),associate.getBankDetails().getAccountNumber(),associate.getBankDetails().getBankName(),associate.getBankDetails().getIfscCode());
		return true;
	}
	@Override
	public boolean deleteAssociate(int associateID) {
		jdbcTemplate.update("delete from Associate where associateID=?", associateID);
		return true;

	}
	@Override
	public Associate getAssociate(int associateID) {
		return null;

	}
	@Override
	public List<Associate> getAssociates() {
		return null;

	}	
}