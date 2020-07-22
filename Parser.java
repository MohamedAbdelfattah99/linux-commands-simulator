package commands;
import commands.Terminal;

/**
 *
 * @author Mahmoud
 * @author Ta7a
 */
    public class Parser {

   static boolean flag1 = false;
   static boolean flag2 = false;
   private  String cmd ;
   private String[] arg = new String[100] ;
    public boolean Zeroarg (String  cmd , int x)
    {
        if(x == 1)
            {
                return true;
            }
            else
            {
                System.out.println("this command must take 0 arguments ");
                return false ;
            }
    }
    public boolean onearg(String cmd , int x)
    {
            if(x == 2)
            {
                return true;
            }
            else
            {
                System.out.println("this command must take 1 arguments ");
                return false ;
            }
    }
    public boolean twoarg (String cmd , int x)
    {
             if(x == 3)
            {
                return true;
            }
            else
            {
                System.out.println("this command must take 2 arguments ");
                return false ;
            }
    }
    
    
    
    public boolean parse(String input)
    {
        boolean check = false ;
        arg = input.split(" ");
        cmd = arg[0];
        if(cmd.equals("clear") ||  cmd.equals("date")  || cmd.equals("help") || cmd.equals("exit"))
        {
            check = Zeroarg(cmd , arg.length);
        }
        else if(cmd.equals("more") ||cmd.equals("rm") || cmd.equals("mkdir") || cmd.equals("rmdir"))
        {
           check = onearg(cmd , arg.length); 
        }
        else if(cmd.equals("cb") || cmd.equals("mv"))
        {
            check = twoarg(cmd , arg.length);
        }
        else if(cmd.equals("args"))
        {
            check = onearg(cmd , arg.length);
            
        }
        else if(cmd.equals("cat"))
        {
            check = true;
        }
        else if (cmd.equals("pwd")){
                if(arg.length == 1)
                {
                    check = true;
                }
                else if(arg.length  == 3)
                {
                    if(arg[1].equals(">"))
                    {
                        flag1 = true;
                        check  = true;
                    }
                    else if(arg[1].equals(">>"))
                    {
                       flag2 = true;
                       check  = true;
                    }
                }
        
        }
        else if (cmd.equals("ls"))
        {
            if(arg.length == 1)
                {
                    check = true;
                }
            else if(arg.length == 3)
            {
                if(arg[1].equals(">"))
                {
                    flag1 = true;
                        check  = true;
                }
                else if(arg[1].equals(">>"))
                {
                     flag2 = true;
                     check  = true;
                }
            }
        }
        else if ( cmd.equals("cd") )
        {
            if( arg.length == 2  )
                    {
                        check  = true;
                    }
            else if(arg.length == 1)
            {
                check = true;
            }
            else 
            {
                System.out.println("the number of argument is wrong");
               check = false ;
            }
           
        }
        else 
        {
            System.out.println("there is no such command  ");
        }
        
            return check;
    }
    public String getcmd ()
    {
        return cmd;
    }
    
    public String[] getarg ()
    {
        return arg;
    }
    
}
