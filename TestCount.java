/**
 * A tester class for CountOccurrence. The count method is tested on a large 2D array in file array.txt
 * @author Jason Schenck
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class TestCount {
	
	public static void main(String args[]){
		try{
			
			//Reading data from array.txt and load it into two dimensional array data
			Scanner fileIn = new Scanner(new File("src/array.txt"));
			
			//The first line contains the number of rows and columns
			int row = fileIn.nextInt();
			int col = fileIn.nextInt();
			int data[][] = new int[row][col];
			
			System.out.println("Reading in data...");
			for(int r = 0; r < row; r++){
				fileIn.nextLine();
				for(int c = 0; c < col; c++){
					data[r][c] = fileIn.nextInt();
				}
			}
			
			
			//Reading the query.txt file and testing the count method for each number in the query.txt
			fileIn = new Scanner(new File("src/query.txt"));
			System.out.println("Starting query...");
			
			//Creating an output file to store the count result
			File f= new File ("src/count_result.txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			
			
			//marking the start and end times to measure the running time of the algorithm
			long start = System.nanoTime();
			//Calling the count method for each line in the query.txt
                        
                        // FOR TESTING

                        
                        
                        
			while(fileIn.hasNextLine()){
				int query = fileIn.nextInt();
				output.write("query "+query +" occurred "+ CountOccurrence.count(data,query)+ " times\n");
				fileIn.nextLine();
			}
			long end = System.nanoTime();
			System.out.println("Querying has ended...");
			System.out.println((end - start)/1000000 + "ms");
			fileIn.close();
			output.close();
			
			
		} catch(Exception e){e.printStackTrace();
		}
	}
	
	
		
}