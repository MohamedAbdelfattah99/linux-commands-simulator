package commands;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author Mahmoud
 * @author Ta7a
 * @author Moussa
 * 
 */
 
public class commands {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String str , comm;
        String[] arr;
        Terminal t1 = new Terminal();
        Parser p1 = new Parser();
        while(true)
        {
            System.out.println("enter the command and argument : ");
         str = "";
        Scanner input = new Scanner (System.in);
        str = input.nextLine();
         boolean l = p1.parse(str);
         //System.out.println(str);
       if(p1.parse(str))
       {
           String[] s1 = p1.getarg() ;
           //System.out.println(s1[0] + "   " + s1[1] );
           // System.out.println(p1.getcmd());
           if(p1.getcmd().equals("cd"))
           {
               
               if(s1.length == 2)
               {
                String ss1 = t1.Is_Short(s1[1]);
                   System.out.println(ss1);
               t1.cd(ss1);
               }
               else
               {
                   t1.cd();
               }
           }
           else if(p1.getcmd().equals("cb"))
           {
               String ss1 , ss2;
               ss1 = t1.Is_Short(s1[1]);
               ss2 = t1.Is_Short(s1[2]);
               t1.cb(ss1, ss2);
           }
           else if(p1.getcmd().equals("pwd"))
           {
               if(s1.length == 3)
               {
                   String ss1;
                   ss1 = t1.Is_Short(s1[2]);
                   t1.pwd(s1[1], ss1);
               }
               else 
               {
               t1.pwd();
               }
               
           }
           else if(p1.getcmd().equals("more"))
           {
               String ss1;
               ss1 = t1.Is_Short(s1[1]);
               t1.more(ss1);
           }
           else if(p1.getcmd().equals("mkdir"))
           {
               t1.Mkdir(str);;
           }
           else if(p1.getcmd().equals("rmdir"))
           {
               t1.Rmdir(str);
           }
           else if(p1.getcmd().equals("rm"))
           {
               t1.rm(str);
           }
           else if(p1.getcmd().equals("mv"))
           {
                String ss1 , ss2;
               ss1 = t1.Is_Short(s1[1]);
               ss2 = t1.Is_Short(s1[2]);
               t1.mv(ss1, ss2);
           }
           else if(p1.getcmd().equals("help"))
           {
               t1.help();
               t1.Date();
               break;
           }
           else if(p1.getcmd().equals("clear"))
           {
               t1.ClearScreen();
           }
           else if(p1.getcmd().equals("args"))
           {
               t1.args(s1[1]);
           }
           else if(p1.getcmd().equals("date"))
           {
               t1.Date();
           }
           else if(p1.getcmd().equals("ls"))
           {
               if(s1.length == 3)
               {
                   String ss1;
                   ss1 = t1.Is_Short(s1[1]);
                   t1.ls(s1[1], ss1);
               }
               else
               {
               t1.ls();
               }
           }
           else if(p1.getcmd().equals("cat"))
           {
               t1.Cat(str);
           }
           else if(p1.getcmd().equals("exit"))
           {
               break;
           }
       }
       else
       {
           
       }
    }
    }
}
    