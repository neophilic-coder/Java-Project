import java.util.Scanner;

//abstract class that has abstract and non-abstract methods
abstract class C_Private
{
	Scanner sc = new Scanner(System.in);
	C_Private(){
		System.out.println();
		System.out.println("----We are in the abstract class and calling the constructor of an abstract class.----");
	}
	public void fees(){
		
		System.out.println("------We are accessing abstract method of abstract class------\nEnter amount");
		int fee = sc.nextInt();
		System.out.println("Money taken by 4-year graduation course of B.Tech CSE is: "+fee);
	}
	abstract void Paper();
}

class Q_Paper extends C_Private
{
	Scanner sc = new Scanner(System.in);
	int avg = 0;
	int total;
	public void Paper()    //implementation of abstract method
	{ 
		System.out.println();
		System.out.println("----This class has been extended from an abstract class.----\n\tEnter marks of students now.");
		int[] arr = new int[6];
		int i;
		for(i =0;i<6;i++)
		{
			System.out.println("Marks of student"+(i+1)+" in Object Oriented Programming are: ");
			arr[i] = sc.nextInt();
			total = total+arr[i];
		}
		avg = total/6;
		System.out.println("The average marks scored by students in OOPs are: "+avg);
		System.out.println("Average grades scored by students are: ");
		if(avg<40){
			System.out.println("FAIL");
		}
		else if(avg>=41 && avg<=74){
			System.out.println("PASS");
		}
		else if(avg>=75 && avg<=90){
			System.out.println("ABOVE DISTINCTION");
		}
		else{
			System.out.println("OUTSTANDING");
		}
	}
}
//Interface declaration
interface Library
{
	void AIML();
}
interface Students
{
	void print();
}
//Implementation by the second user
class A1 implements Library
{
	Scanner sc = new Scanner(System.in);
	public void AIML()
	{
		System.out.println("Enter number of subjects: ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Start entering book names");
		for(int i=0;i<=n;i++)
		{
			String book_name = sc.nextLine();
		}
	}
}

//Multiple Inheritance
class A2 implements Library, Students
{
	Scanner sc = new Scanner(System.in);
	public void AIML()
	{
		System.out.println("*************************************");
		System.out.println("A2 class is being executed, enter books number in library and students number.");
		int number = sc.nextInt();
		System.out.println("Number of books in library for AIML are: "+number);
	}
	public void print()
	{
		int student = sc.nextInt();
		System.out.println("Number of students in AIML 2nd year are: "+student);
	}
}
class Furniture{
	void bench(){
		System.out.println("This is main Furniture class");  //Runtime polymorphism can't be achieved by data members.
	}
	int block;
	int floor;
	Furniture(int block, int floor){
		this.block = block;
		this.floor = floor;
	}
	void fans(){
		System.out.println("Number of fans in Block 9 are: 450");
	}
	//this.fans();  //to invoke current class constructor
}
class F1 extends Furniture{
	String t_name;
	void bench(){
		System.out.println("Furniture class extended 1 time.");
	}
	F1(int block, int floor,String t_name){
		super(block,floor);  //reusing parent constructor
		this.t_name = t_name;
	}
	void display()
	{
		System.out.println("Class is scheduled in "+block+" on floor "+floor+ " and the teacher will be: "+t_name); 
	}
}
class F2 extends Furniture{
	String c_name;
	void bench()
	{
		System.out.println("Furniture class extended 2 times.");
	}
	F2(int block, int floor, String t_name, String c_name)
	{
		super(block,floor);
		this.c_name = c_name;
	}
	void display()
	{
		System.out.println("Class is scheduled in "+block+" on floor "+floor+" and the subject taught will be: "+c_name);
	}
}

//Main Class
class College{
	Scanner sc = new Scanner(System.in);
	//static binding or early binding
	private void batch(){
		System.out.println("Number of batches in AIML non-hons are: 6 for second year");
	}
	void Name(final String clg_name){
		System.out.println("Name of the college is: "+clg_name);
	}
	int std;
	long total;
	long fee;
	College(){
		System.out.println("Total students in Bidholi are: ");
		int std = sc.nextInt();
		System.out.println("Average fees for total students is: ");
		long fee = sc.nextLong();
		total = (fee*std);
		System.out.println("Therefore total payment collected by the college from students all over is: "+total);
	}
	College(String place){
		System.out.println("Total students in "+place+" are: ");
		int std = sc.nextInt();
		System.out.println("Average fees for total students is: ");
		long fee = sc.nextLong();
		total = (fee*std);
		System.out.println("Therefore total payment collected by the college from students all over is: "+total);
	}
	public static void main(String[] args)
	{
		College clg = new College();
		clg.Name("University of Petroleum and Energy Studies");
		clg.batch();
		College clg1 = new College("Kandoli");
		Library obj = new A1();
		obj.AIML();
		A2 obj1 = new A2();
		obj1.AIML();
		obj1.print();
		C_Private obj2 = new Q_Paper();
		obj2.Paper();
		obj2.fees();
		Furniture f = new Furniture(9,2);
		F1 f1 = new F1(9, 2,"Mr. Deepak Kumar" );
		F2 f2 = new F2(9, 2,"Mr. Deepak Kumar", "Object Oriented Programming");
		f.bench();
		f1.bench();
		f2.bench();
		f1.display();
		f2.display();
	}
}   
