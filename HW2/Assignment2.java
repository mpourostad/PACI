import java.util.Scanner;
public class Assignment2
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two time in military format: ");
		int time1 = input.nextInt();
		int time2 = input.nextInt();
		int ss1 = time1 % 100;
		int mm1 = (time1 / 100) % 100;
		int hh1 = time1 / 10000;
		int ss2 = time2 % 100;
		int mm2 = (time2 / 100) % 100;
		int hh2 = time2 / 10000;
		int value1 = ((hh1 * 3600) + (mm1 * 60) + ss1);
		int value2 = ((hh2 * 3600) + (mm2 * 60) + ss2);
		int time3 = (value1 - value2);
		int hh3 = (time3 / 3600);
		int mm3 = (time3 % 3600) /60;
		int ss3 = (time3 % 3600) % 60;
		time3 = ((hh3 * 10000) + (mm3 * 100) + ss3);

		System.out.println(time3);
	}
}