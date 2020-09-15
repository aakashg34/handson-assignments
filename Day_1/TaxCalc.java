class TaxCalc{
	public static void main(String[] args)
	{
	int amt = Integer.parseInt(args[1]);
	switch(args[0])
		{
		case "KA" : System.out.println("Tax is 10%");
				System.out.print("Amount is " + (amt-amt*0.1));
				break;
		case "TN" :  System.out.println("Tax is 15%");
				System.out.print("Amount is " + (amt - amt*0.15));
				break;
		case "MP" : System.out.println("Tax is 20%");
				System.out.print("Amount is " + (amt - amt*0.2));
				break;
		case "RJ" : System.out.println("Tax is 18%");
				System.out.print("Amount is " + (amt - amt*0.18));
				break;  
		default: System.out.println("Sorry invalid");
				break;
		}	
	}	
}