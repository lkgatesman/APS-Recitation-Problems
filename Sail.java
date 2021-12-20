import java.util.*;
 
public class Main{
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);

        //Read in the number of directions
        int t = in.nextInt();

        int sx = in.nextInt();    //Starting x value / current x value
        int sy = in.nextInt();    //Starting y value / current y value
        int ex = in.nextInt();    //Goal x value
        int ey = in.nextInt();    //Goal y value

        in.nextLine();    //read out the line break

        String winds = in.nextLine();   //read in the winds/directions

        in.close(); //close thes scanner

        //If we are already at the goal point, print 0 and end program
        if(sx == ex && sy == ey){
            System.out.println(0);
            return;
        }

        //For each wind given...
        for(int i = 0; i < winds.length(); i++){

            char direction = winds.charAt(i);

            //Apply it to the current (x, y) position
            if(direction == 'N' && sy < ey){
                sy += 1;
            }
            else if(direction == 'S' && sy > ey){
                sy -= 1;
            }
            else if(direction == 'E' && sx < ex){
                sx += 1;
            }
            else if(direction == 'W' && sx > ex){
                sx -= 1;
            }
 
            //if we have reached the goal position, print the second we have reached it at
            if(sx == ex && sy == ey){
                System.out.println(i + 1);
                break;
            }
        }

        //If we have used all the winds and still are not at the end point, print -1 since
        // the destination was not reachable
        if(sx != ex || sy != ey){
            System.out.println(-1);
        }
    }
}
