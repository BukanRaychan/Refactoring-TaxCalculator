package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Employee extends Person{

	private String employeeId;
	private String firstName;
	private String lastName;
	private String address;

	private EmploymentPeriod employmentPeriod;

	private boolean isForeigner;
	private boolean gender; //true = Laki-laki, false = Perempuan

	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;

	private Person spouse;
	private List<Person> children;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, EmploymentPeriod employmentPeriod, boolean isForeigner, boolean gender) {
		super(firstName + " " + lastName, idNumber);
		
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.isForeigner = isForeigner;
		this.gender = gender;
		
		this.employmentPeriod = employmentPeriod;
		children = new ArrayList<>();
	}

	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */

	public void setMonthlySalary(int grade) {
		if (grade == 1) {
			monthlySalary = 3000000;
		} else if (grade == 2) {
			monthlySalary = 5000000;
		} else if (grade == 3) {
			monthlySalary = 7000000;
		}
		if (isForeigner) {
			monthlySalary = (int) (monthlySalary * 1.5);
		}
	}

	public void setAnnualDeductible(int deductible) {
		this.annualDeductible = deductible;
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}
	
	public void addChild(List<Person> children) {
		this.children = children;
	}
}
