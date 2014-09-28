import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {

	/**
	 * @param args
	 */
	public static players[] arr=new players[100];
	public static void main(String[] args) {
		players[] arr = new  players[100];
		
		main obj=new main();
		int counter=obj.entry();
		obj.sort(counter);
		
		
		// TODO Auto-generated method stub
		

	}

	/*
	 * the csvreader starts
	 */
	  int entry() {
		
			String csvFile = "C:/Users/johnn_000/Downloads/data.csv";
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";
			int count=0;
			try {
		 
				br = new BufferedReader(new FileReader(csvFile));
				while ((line = br.readLine()) != null) {
		 
				        // use comma as separator
					String[] playerrecords = line.split(cvsSplitBy);
					
					//calculating the passer rating as per wikipedia
					double a,b,c,d,rating;
					
					//System.out.println(count);
					
					a=((Integer.parseInt(playerrecords[4])/Integer.parseInt(playerrecords[5]))-.3)*5;
					
					b=((Integer.parseInt(playerrecords[7])/Integer.parseInt(playerrecords[5]))-3)*.25;
					
					c=((Integer.parseInt(playerrecords[10])/Integer.parseInt(playerrecords[5])))*20;
					
					d=2.375-((Integer.parseInt(playerrecords[11])/Integer.parseInt(playerrecords[5]))*25);
					
					rating=((Math.max(0,Math.min(2.375,a))+Math.max(0,Math.min(2.375,b))+Math.max(0,Math.min(2.375,c))+Math.max(0,Math.min(2.375,d)))/6)*100;
					
					//putting the data in the objects
					
					arr[count] = new  players(Integer.parseInt(playerrecords[0]),playerrecords[1], playerrecords[3] , Integer.parseInt(playerrecords[4]) , Integer.parseInt(playerrecords[5]), Double.parseDouble(playerrecords[6]) ,Integer.parseInt(playerrecords[7]) ,  Double.parseDouble(playerrecords[8]) ,  Integer.parseInt(playerrecords[9]), Integer.parseInt(playerrecords[10]),Integer.parseInt(playerrecords[11]), Integer.parseInt(playerrecords[12]),rating);
					
					//System.out.println(rating);
					
					count++;
		 
				}
		 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		 return count;
			
		  }
		 void sort(int counter)
		 { int i,max,min;
		
		   double array[][]=new double[counter][2];
		   double temp1,temp2;
		   System.out.println(counter);
		   for(i=0;i<counter;i++)
		   {
			   array[i][0]=arr[i].rating;
			   array[i][1]=arr[i].RK;
		   }
		   System.out.println(counter);
		   for(int x=0; x<counter; x++)

			{

				for(int y=0; y<counter-1; y++)

				{

					if(array[y][0]>array[y+1][0])

					{

						temp1 = array[y+1][0];
						temp2=array[y+1][1];

						array[y+1][0] = array[y][0];
						array[y+1][1] = array[y][1];

						array[y][0] = temp1;
						array[y][1] = temp2;

					}

				}

			}
		   max=(int)array[0][1];
		   min=(int)array[counter-1][1];
		  for (i=0;i<counter;i++)
		  {
			 System.out.println(array[i][0]+"and "+ array[i][1]);
		  }
		  int median=(int)array[(i)/2][1];
		 System.out.println(median);
			System.out.println(arr[max].name +" is max and his rating is"+arr[max].rating + arr[min].name +" is min and his rating is"+arr[min].rating+arr[median].name +"is median and his rating is"+arr[median].rating) ;
			
		 }
		}

class players { 
	 public int RK;
	 public String name; 
	 public String team;
	 public int COMP,ATT,YDS,LONG,TD,INTs,SACK;
	 public double PCT,YDSA,rating;
	 
	 public players(int rk, String name, String team , int comp , int att ,double pct,int yds ,double ydsa,int longs , int td , int ints ,int sack,double rating ) {
		 
		 this.RK=rk;
		 this.name=name;
		 this.team=team;
		 this.COMP=comp;
		 this.ATT=att;
		 this.YDS=yds;
		 this.LONG=longs;
		 this.TD=td;
		 this.INTs=ints;
		 this.SACK=sack;
		 this.PCT=pct;
		 this.YDSA=ydsa;
		 this.rating=rating;
		
		 
	 }
	 
	 
	
}




  