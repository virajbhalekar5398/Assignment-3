import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class CricketScore {
	public static void main(String[] args) {
		Map<String, String> cricket_scores= new HashMap<>(); //Map Creation
        File current = new File("");
        String path = current.getAbsolutePath();
		String line = "";
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(path + "\\most-wickets-in-powe-ipl.csv"));//importing csv file
			while ((line = br.readLine()) != null) {  // exclude first line
				String[] values = line.split(","); 

				if(values[0] != null) {
					cricket_scores.put(values[6], values[2]);    //Store values from csv file of particular columns as key and values 
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		long startTime, endTime;    
        startTime = System.nanoTime();  //start time of the insertion operation for sorted priority queue 

        SortedPriorityQueue formin = new SortedPriorityQueue();
        
        for (String k : cricket_scores.keySet()) {
            formin.insert(cricket_scores.get(k), k );
        }
      
        endTime = System.nanoTime();
        System.out.println("Sorted Priority Queue Implementation\n");
        System.out.println("Execution time : " + (endTime - startTime) + " nanoseconds");
        
        
        
        long staTime, endofTime;
        staTime = System.nanoTime();//start time of the traversal operation for sorted priority queue
		System.out.println("Maximum_average  is: " + formin.removeMin().getKey() + "   " + formin.removeMin().getValue());
		System.out.println("Minimum_average  is: " + formin.removeMax().getKey() + "   " + formin.removeMax().getValue());
		endofTime = System.nanoTime();
        System.out.println("Execution time : " + (endofTime - staTime) + " nanoseconds\n");


       
		long stTime, edTime;
        stTime = System.nanoTime();//start time of the insertion operation for heap priority queue

       
        UnsortedPriorityQueue us = new UnsortedPriorityQueue();
        
        
        for (String k : cricket_scores.keySet()) {
            us.insert(cricket_scores.get(k), k );
        }
      
        edTime = System.nanoTime();
        System.out.println("Unsorted Priority Queue Implementation\n");
		System.out.println("Execution time : " + (edTime - stTime) + " nanoseconds\n");
		
		
		long startofTime, edofTime;
        startofTime = System.nanoTime();//start time of the traversal operation for unsorted priority queue
		System.out.println("Maximum_average  is: " + us.removeMin().getKey() + "   " + us.removeMin().getValue());
		System.out.println("Minimum_average  is: " + us.removeMax().getKey() + "   " + us.removeMax().getValue());
		edofTime = System.nanoTime();
		System.out.println("Execution time : " + (edofTime - startofTime) + " nanoseconds\n");
		
		long sTime, eTime;
        sTime = System.nanoTime();//start time of the insertion operation for heap priority queue

		
		HeapPriorityQueue hp =new  HeapPriorityQueue(); // Here weare using heap priority queue whee we use insert function for heap and then it
		//will perform the downheap on that and give the answer for remove min()
		
		 for (String k : cricket_scores.keySet()) {
	            hp.insert(cricket_scores.get(k), k );
	        }
	      
	    eTime = System.nanoTime();
	    System.out.println("Heap Priority Queue Implementation\n");
	    
		System.out.println("Execution time : " + (eTime - sTime) + " nanoseconds");
		
		
		
		long starTime, endsTime;
        starTime = System.nanoTime();//start time of the traversal operation for heap priority queue
		System.out.println("Maximum_average  is: " + hp.removeMin().getKey() + "   " + hp.removeMin().getValue());
        endsTime = System.nanoTime();
		System.out.println("Execution time : " + (endsTime - starTime) + " nanoseconds");

	}
		
}