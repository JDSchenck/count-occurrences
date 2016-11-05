/**
 * A class to count the number of occurrences of an element in a 2-D array
 * @author Jason Schenck
 */
public class CountOccurrence {

	
	
	
	/**
	 * This method counts the number of occurrences of query in the array.
	 * @param query
	 * @return count
	 */
	public static int count(int[][]array, int query){
            int count = 0; // count variable for query 
            
            // loop column by column one at a time
            for(int column = 0; column < array[0].length; column++){    
                // determine if the query was found in the column by checking first occurence
                // if first occurrence != -1 then at least one match found in column, continue
                if (binarySearchFirstOccurrence(array, query, column) != -1){
                // to find count using binary search with duplicate queries in each column
                // count = first occurence index - last occurrence index +1
                int firstOccurrence = binarySearchFirstOccurrence(array, query, column);
                int lastOccurrence = binarySearchLastOccurrence(array, query, column);
                // increase running count by the number of times that query was found in this column
                count = count + (lastOccurrence - firstOccurrence + 1);                   
                }

            }
            // return the total count of the query in the 2D array
            return count;
        }
            
          	
        // method which binary searches one column and returns the first occurrence index
        public static int binarySearchFirstOccurrence(int[][]array, int query, int column){
            int size = 1000; // constant column size
            int low = 0; 
            int high = size - 1;
            int result = -1; 
            
            while (high >= low){
                int mid = (low + high)/2;
                
                // if mid = query, update result as mid
                // update high as one less than mid, to check for first occurrence before mid
                if(array[mid][column] == query){
                    result = mid;
                    high = mid - 1;
                }
                if(array[mid][column] < query){
                    low = mid + 1;
                }
                if(array[mid][column] > query){
                    high = mid - 1;
                }
            }
            // return the index of the first occurrence of query in this column, if not found -1
            return result;
        }
        
        // method which binary searches one column and returns the last occurrence index
        public static int binarySearchLastOccurrence(int[][]array, int query, int column){
            int size = 1000; // constant size of column
            int low = 0;
            int high = size - 1;
            int result = -1;
            
            while (high >= low){
                int mid = (low + high)/2;
                
                if(array[mid][column] == query){
                    result = mid; // update result as mid
                    low = mid + 1; // continue searching by increasing the low to check for dups
                }
                if(array[mid][column] < query){
                    low = mid + 1;
                }
                if(array[mid][column] > query){
                    high = mid - 1;
                }
            }
            // return the index of the last occurrence of query in this column, if not found -1
            return result;
        }            
   }
		
