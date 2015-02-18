
package sci_codejam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.text.SimpleDateFormat;

/********************************************************
 *                                                      *
 *    Mureithi David Wachira (P15/2204/2011)            *
 *    davidwachira90@students.uonbi.ac.ke               *
 *                                                      *
 *    Monday 16 February 2015                           *
 *                                                      *
 *    SCI Code Jam - Week 3                             *
 *    http://codejam.sci.website/2015/02/week-3/        *
 *                                                      *
 *    Challenge B (Circular Primes)                     *
 *                                                      *
 ********************************************************/


public class Circular_Primes 
{
    ArrayList circular_primes_list = new ArrayList();
    int maximum_number = 100;
    
    public void Circular_Primes() 
    {
        ArrayList al = new ArrayList();
      
        int array_counter = 0;
        Print_Ouput_to_Text_File ("\n********************************************************\n\n" + Get_System_Date_and_Time () + "\n\n"); 
        Print_Ouput_to_Text_File ("\nPrime numbers between 0 and "+ maximum_number +"\n");
        
        al.add(2); /* Two is a prime number but the algorithm does not cater for it*/
        //Print_Ouput_to_Text_File (al.get(0) +" ");
        
    	for (int i_count=2; i_count < maximum_number; i_count++)
    	{
                if(Check_number_if_Prime(i_count)== true)
    		{
                        al.add(i_count);
                        if (array_counter%10 == 0)
                        {
                         Print_Ouput_to_Text_File ("\n");
                        }
                        
                        Print_Ouput_to_Text_File (al.get(array_counter) +" ");
                        array_counter++;
    		}	
    	}
        int array_list_size = al.size();
        Print_Ouput_to_Text_File ("\nTotal Prime numbers between 0 and "+maximum_number+" = " + array_list_size +"");
    	Print_Ouput_to_Text_File ("\n********************************************************\n\n");
          
    	Find_Circular_Primes(al, array_list_size);
    }
    
    public void Find_Circular_Primes(ArrayList Primes_Array_list, int al_size)
    {
        circular_primes_list.add(2);
        //Loop through each of the primes
        for(int p_count = 0; p_count < al_size; p_count++) 
        {
            
            String temp = "" + Primes_Array_list.get(p_count).toString();
            boolean circular_prime_test = false;
            for (int j_count = 0; j_count < temp.length(); j_count++) 
            {
                temp = temp.charAt(temp.length() - 1) + temp;
                temp = temp.substring(0, temp.length() - 1);
                
                int temp_int = Integer.parseInt(temp);
                
                if (Check_number_if_Prime(temp_int)== false)
                {
                  circular_prime_test = false;
                  break;
                }
                else
                {
                  circular_prime_test = true;
                }
            } 
              
             if (circular_prime_test==true) 
                {
                  circular_primes_list.add(Primes_Array_list.get(p_count));
                }
         
        }
      
      Print_Ouput_to_Text_File ("\n\n\n\n\n\n\n\nCircular Primes between 0 and "+maximum_number+":\n");
      for (int u_count = 0; u_count < circular_primes_list.size(); u_count++) 
        {
            if (u_count%20 == 0)
               {
                  Print_Ouput_to_Text_File ("\n");
               }
	    Print_Ouput_to_Text_File(circular_primes_list.get(u_count) + " ");
	}
      Print_Ouput_to_Text_File ("\n********************************************************\n\n\n\n\n\n");
      
      System.out.println("There are " + circular_primes_list.size() + " circular primes between 0 and "+ maximum_number+" \n");
      Print_Ouput_to_Text_File("There are " + circular_primes_list.size() + " circular primes between 0 and "+ maximum_number+" \n");
      Fibonacci(circular_primes_list);
    }
    
    public String Get_System_Date_and_Time ()
    {
      Date dNow = new Date( );
      SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
      return "" + ft.format(dNow);
      
    }
    
    public boolean Check_number_if_Prime (int particular_number)
    {
    	if(particular_number%2 == 0)
    	{
           return false;
        }
        
        for (int i=3; i*i<= particular_number; i+=2)	
        {
        	if(particular_number%i == 0)
        	 return false;		
        }
        
        return true;
    }
    
    public void Check_array_for_repetitions (int[] arr)
    {
    	for(int i=0;i<arr.length;i++){
            boolean isDistinct = false;
            for(int j=0;j<i;j++){
                if(arr[i] == arr[j]){
                    isDistinct = true;
                    break;
                }
            }
            if(!isDistinct){
                Print_Ouput_to_Text_File (arr[i]+"; ");
            }
        }
    }
    
    public void Fibonacci(ArrayList c_primes_list) 
    {
        Print_Ouput_to_Text_File ("\n\nFibonacci of the Circular Primes between 0 and "+maximum_number+":\n");
        
         long[] Fibonacci_Series = new long[circular_primes_list.size()];
              
         
         for(int I_count=2; I_count< circular_primes_list.size(); I_count++)
         {
             Fibonacci_Series[I_count] = ((Integer)c_primes_list.get(I_count-1)) + ((Integer)c_primes_list.get(I_count - 2));
             Print_Ouput_to_Text_File (Fibonacci_Series[I_count] + " ");
         }
         
         
         
         
        Print_Ouput_to_Text_File ("\n********************************************************\n\n");
    }
    		
    public void Print_Ouput_to_Text_File (String content) {
	try {
  
			File file = new File("ouput_two.txt");
 
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
	    } catch (IOException e) 
                {
			e.printStackTrace();
		}
	}  
    
}