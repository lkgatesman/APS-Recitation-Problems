import java.util.*;     
    
public class Main {    
    public static void main(String[] args) {   
          
        Scanner in = new Scanner(System.in);   

        String str1;    //Original string
        String str2;    //Second string

        while (in.hasNextLine()){

            //Read in each string
            str1 = in.nextLine();   
            str2 = in.nextLine(); 
             
            //Call the function and print out the result for the length of LCS between the 2 strings
            System.out.println(lengthOfLCS(str1, str2)); 

        }  

        in.close();
                  
    }  

    //Method that finds the length of the longest common substring
    public static int lengthOfLCS(String str1, String str2) {  

        int s = str1.length();
        int t = str2.length();
      
        //Declare the array that will hold the length of each LCS for each length i of str1 and j of str2  
        int[][] DP = new int[s + 1][t + 1];  
  
        //Bottom up approach to finding the LCS 
        for (int i = 0; i <= s; i++) {      //For each char i in str1

            for (int j = 0; j <= t; j++) {      //For each char j in str2

                if (i == 0 || j == 0) {
                    DP[i][j] = 0;  //Initialize each value where i=0 or j=0 to 0 at first 
                } 

                //If the characters are equal, then we need to increase the LCS by 1
                //And we know there is at least an LCS of DP[i-1][j-1]
                //So we set the value to DP[i-1][j-1] + 1
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                }   

                //Else if the characters are not equal, we continue onto the next 2 substrings    
                else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                } 
            }  
        }  
      
        return DP[s][t];  //Return the largest value
         
    }
}  
