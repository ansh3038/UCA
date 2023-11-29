/* package codechef; // don't place package name! */

import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Name of the class has to be "Main" only if the class is public. */
class Test
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // Q. List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)

        // Q. Sort employees based on firstName, for same firstName sort by salary.

        // Q. Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).

        // Q. Print min salary.

        //Q. Print list of all employee with min salary.

        // Q. List of people working on more than 2 projects.

        // Q. Count of total laptops assigned to the employees.

        // Q. Count of all projects with Robert Downey Jr as PM.

        // Q. List of all projects with Robert Downey Jr as PM.

        // Q. List of all people working with Robert Downey Jr.

        // Q. Create a map based on this data, they key should be the year of joining, and value should be list of all the employees who joined the particular year.

        // Q.  Create a map based on this data, the key should be year of joining and value should be the count of people joined in that particular year.


        List<Employee> employeeList = new ArrayList<>();
        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        employeeList.stream().filter( w -> w.getFirstName().charAt(0) == 'B').forEach(x -> System.out.println(x.toString())); //1
        employeeList.stream().filter( w -> w.getId().substring(0,4).equals("2023")).forEach((w -> System.out.println(w.getFirstName()))); //2
        System.out.println();

        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(2) // Skip the first two highest salaries
                .findFirst()
                .ifPresent(employee -> {
                    System.out.println("Names of employees with the 3rd highest salary: ");
                    System.out.println(employee.getFirstName() + " " + employee.getLastName());
                });
 //Get the third highest salary
        List<Project> projectsWithRobertDowneyJrAsPMList = employeeList.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .filter(project -> project.getProjectManager().equals("Robert Downey Jr"))
                .collect(Collectors.toList());
        System.out.println("Projects with Robert Downey Jr as PM: ");
        projectsWithRobertDowneyJrAsPMList.forEach(project -> System.out.println(project.getName()));

        List<Employee> salary = employeeList.stream().sorted(Comparator.comparingInt(Employee::getSalary)).collect(Collectors.toList());
        System.out.println(salary.get(salary.size()-3));
        salary.forEach(x-> System.out.println(x.getFirstName() + " "+ x.getSalary()));

        int minsalary =  salary.get(0).getSalary();
        employeeList.stream().filter(x -> x.getSalary() == minsalary).forEach(x -> System.out.println(x.getFirstName()));

        employeeList.stream().filter(x-> x.getProjects().size()>2).forEach(System.out::println);

//        employeeList.stream().filter(x-> x.getProjects().stream().filter(x-> x.getProjectManager().equals("Robert Downey Jr"))).distinct().forEach(System.out::println);
        //QnA



    }
}

class Project {

    private String name;
    private String team;
    private String projectManager;

    Project(){
    }

    public Project(String name, String team, String projectManager) {
        this.name = name;
        this.team = team;
        this.projectManager = projectManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }
}

class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private int salary;
    private int totalLaptopsAssigned;
    // OneToMany
    private List<Project> projects;

    Employee(){
    }

    public Employee(String id, String firstName, String lastName, int salary, int totalLaptopsAssigned,
                    List<Project> projects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.totalLaptopsAssigned = totalLaptopsAssigned;
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", projects="
                + projects + "]";
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public List<Project> getProjects() {
        return projects;
    }
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    public int getTotalLaptopsAssigned() {
        return totalLaptopsAssigned;
    }
    public void setTotalLaptopsAssigned(int totalLaptopsAssigned) {
        this.totalLaptopsAssigned = totalLaptopsAssigned;
    }
}

class EmployeeFactory extends Employee {

    ArrayList<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployee(){

        Project Delta = new Project("Delta Model", "Login", "Robert Downey Jr");
        Project Beta = new Project("Beta Enhancement", "Authentication", "Chris");
        Project TwoFactorAuth = new Project("Two Factor Authentication", "Authentication", "MSD");
        Project CommonUI = new Project("Common UI", "UI", "Robert Downey Jr");
        Project Pegasus = new Project("Pegasus Model", "Data", "Vikram");
        Project CustomerOnboarding = new Project("Customer Onboarding", "Ads", "Vedha");
        Project Verification = new Project("Source Verification", "Data", "Pablo");
        Project RemoveUsers = new Project("Remove Invalid User", "Proxy", "Jeetu");
        Project SiteReliability = new Project("Site Reliability", "Admin", "Zaheer Khan");
        Project DataTransition = new Project("Data Transition", "Data", "Atif Aslam");
        Project TwoPhaseDeployment =new Project("Two Phase Deployment", "Deployment", "Shaktiman");

        employees.add(new Employee("2020Emp0234", "Bhaskar", "Sharan", 900000, 1, Arrays.asList(Delta, Beta)));
        employees.add(new Employee("2012Emp1923", "Dev", "Sharma", 3500000, 3, Arrays.asList(Pegasus, CustomerOnboarding, Beta, SiteReliability)));
        employees.add(new Employee("2017Emp0721", "Priti", "Kabir", 1800000, 3, Arrays.asList(TwoFactorAuth, Beta, CommonUI)));
        employees.add(new Employee("2017Emp00031", "Chris", "Martin", 2200000, 2, Arrays.asList(Delta, TwoFactorAuth)));
        employees.add(new Employee("2013Emp0872", "Sanjay", "Singhania", 2200000, 3, Arrays.asList(Pegasus, Delta, RemoveUsers, DataTransition)));
        employees.add(new Employee("2022Emp0087", "Babu", "Rao", 900000, 1, Arrays.asList(TwoFactorAuth)));
        employees.add(new Employee("2019Emp0050", "Dev", "Anand", 1300000, 1, Arrays.asList(RemoveUsers, CommonUI)));
        employees.add(new Employee("2023Emp0934", "Shruti", "Sen", 1100000, 1, Arrays.asList(Pegasus)));
        employees.add(new Employee("2023Emp1033", "Akshay", "Kumar", 1200000, 0, Arrays.asList(Delta)));
        employees.add(new Employee("2015Emp0009", "Babu", "Dutt", 2600000, 2, Arrays.asList(Verification, RemoveUsers, TwoPhaseDeployment)));

        return employees;
    }
}