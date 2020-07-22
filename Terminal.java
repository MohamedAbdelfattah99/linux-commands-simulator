package commands;

import commands.Parser;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.io.PrintWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.W;

/**
 *
 * @author Mahmoud
 * @author ta7a
 * @author moussa
 */

public class Terminal {
    static boolean flag1 = false ;
    static boolean flag2 = false;
    static String dir = "E:/";
    Parser p1 = new Parser();
    private Iterable<File> filelist;
    String Is_Short(String s)
    {
        char[] ch = s.toCharArray();
        boolean flag = true;
        String s2 = dir;
        for(int i=0 ; i<ch.length ; i++)
        {
            if(ch[i]==(':'))
            {
               flag = false;
            }
        }
        if(flag == true)
        {
           s2 = s2 + '/' + s;
           return s2;
        }
        else
        {
            return s;
        }
    }
            public void pwd ()
    {
        System.out.println(dir);
        
        
    }
    public void pwd (String s1 , String s2) throws IOException{
            {
                
               if(s1.equals(">"))
                        {
                            File f1 =  new File (s2);
                            if(f1.isFile())
                            {
                          //  f1.createNewFile();
                   String STR = "kjsdhgksdkfgjlskfs";
                      FileWriter writer = new FileWriter(s2);
                      writer.write(dir);
                      writer.close();
                            }
                            else 
                            {
                      f1.getParentFile().mkdirs();
                      f1.createNewFile();
                      String STR = "mm";
                      FileWriter writer = new FileWriter(s2);
                      writer.write(dir);
                      writer.close();
                                  
                            }
                        }
                else if(s1.equals(">>"))
                     {
                         File f1 = new File(s2);
                         if(f1.isFile())
                         {
                          try (BufferedWriter bw= new BufferedWriter(new FileWriter(s2, true))) {
                              bw.newLine();
                          bw.write(dir);
                          bw.newLine();
                          bw.flush();
                    }       catch (IOException ex) {
                            ex.printStackTrace();
                    }
                         }
                         else
                         {
                             f1.getParentFile().mkdirs();
                                  f1.createNewFile();
                                  String STR = "mm";
                      FileWriter writer = new FileWriter(s2);
                      writer.write(dir);
                      writer.close();
                         }
                     }
            }
                       
            }
    
    public void cb (String s1 , String s2)
    {
        try {
        String[] filename =  s1.split("/");
        String STR = s2 + "/" + filename[filename.length - 1];
        String readfFile ;
        BufferedReader read = new BufferedReader(new FileReader(s1));
        File file=new File(STR);
        file.getParentFile().mkdirs();
        file.createNewFile();
        PrintWriter pw = new PrintWriter(new FileWriter (file)) ;
            while (( readfFile = read.readLine()) != null)
            {
                pw.println(readfFile);
                readfFile = "";
            }
            pw.close();
            read.close();
    }
        catch (Exception e) {
            System.out.println("No such Directory");
        }
    }
    
    public void mv (String s1 , String s2) throws IOException
    {
        cb(s1 , s2);
        File f1 = new File (s1);
        f1.delete();
    }
    public void more (String s1) throws IOException
    {
        File f1 = new File(s1);
        String readline  , str;
        BufferedReader read = new BufferedReader (new FileReader(s1));
        System.out.println("if you want to scroll down press d  and if you want to exit press q : ");
        
        for(int i=0 ; i<10 ; i++)
        {
        if((readline = read.readLine()) != null)
        {
            System.out.println(readline + " ");
        }
        }
            
        while(true)
        {
          Scanner input = new Scanner (System.in);
          str = input.nextLine();
            if(str.equals("d"))
            {
                if((readline = read.readLine()) != null)
                {
                for(int i=0 ; i<10 ; i++)
                {
                System.out.println(readline + " ");
                readline = read.readLine() ;
                }
                }
                else {
                    System.out.println("the end : ");
                    break;
                }
            }
            else if(str.equals("q"))
            {
                break;
            }
            else if( (readline = read.readLine()) == null)
            {
               break;
            }
        }

    }
    public void cd (String s1)
    {
        dir = s1;
    }
    public void cd ()
    {
        dir = "c://desktop";
    }
    public void rm(String loction){
        String []Str=loction.split(" ");
        String ss1 = Is_Short(Str[Str.length-1]);
        File file = new File(ss1);
        if(file.exists()){
            System.out.println("file Remved ");
            file.delete();
        }
        else{
            System.out.println("File is not found ");
        }
    }
public void Cat(String cat) throws FileNotFoundException, IOException {
        String[] Arr_cat = cat.split(" ");
        File file = new File(Arr_cat[0]);
       // System.out.println(Arr_cat[1]);
        List<String> list = new ArrayList<String>();
        for (int i = 1; i < Arr_cat.length-2; i++) {
           FileReader fileReader = new FileReader(Arr_cat[i]);
            BufferedReader in = new BufferedReader(new FileReader(Arr_cat[i]));
            
            String str;
            while ((str = in.readLine())!= null) {
                list.add(str);
            }          
        }
     
        
        if(Arr_cat[(Arr_cat.length) - 2].equals(">>"))
        {   
            //System.out.println(Arr_cat[(Arr_cat.length)-2]);
            for(int i = 0; i < list.size(); i++) {
            try (BufferedWriter bw= new BufferedWriter(new FileWriter(Arr_cat[(Arr_cat.length - 1)], true))) {
                String s;
                s = list.get(i);
                bw.write(s);
                bw.newLine();
                bw.flush();
            } 
            catch (IOException ex) {
                ex.printStackTrace();
            }
            }
        }
        else if(Arr_cat[(Arr_cat.length) - 2].equals(">")){
            File f1 = new File(Arr_cat[Arr_cat.length-1]);
            if(f1.isFile())
            {
                FileWriter write =new FileWriter(Arr_cat[Arr_cat.length-1]);
            for(int i=0;i<list.size();i++){
            
            String s=list.get(i);
             write.write(s);
             write.write("\n");
            }
            write.close();
            }
            else
            {
                f1.getParentFile().mkdir();
                f1.createNewFile();
                FileWriter write =new FileWriter(Arr_cat[Arr_cat.length-1]);
                 for(int i=0;i<list.size();i++){
            
            String s=list.get(i);
             write.write(s);
            }
                 write.close();
            }
        }

        
            
          else{
             List<String> list1 = new ArrayList<String>();
             for (int i = 1; i < Arr_cat.length; i++) {
            FileReader fileReader1 = new FileReader(Arr_cat[i]);
            BufferedReader in = new BufferedReader(new FileReader(Arr_cat[i]));
            
            String str1;
            while ((str1 = in.readLine())!= null) {
                list1.add(str1);
            }          
        }
          for(int i =0;i<list1.size();i++){
            System.err.println(list1.get(i));
        }
                  
        }
}

        

    public void Rmdir(String Rmdir) {
           String[] str=Rmdir.split(" ");
           String ss1 = Is_Short(str[str.length-1]);
           File dir=new File(ss1);
           //System.out.println(str);
           if (dir.isDirectory()){
               String[] check=dir.list();
               if(check.length>0){
                   System.out.println("Dir is not empty cannot remove it ");
               }
               else{
                     dir.delete();
                   System.out.println("Dir removed ");
               }
           } 
      


    }
    public void Mkdir(String Dirctory ) throws IOException{
        String[] s1=Dirctory.split(" ");
        String ss1 = Is_Short(s1[s1.length-1]);
        File New_Dir = new File(ss1);
         boolean check= New_Dir.mkdirs();
       if(check==true){
           System.out.print("Dir is crated at dir :"+s1[s1.length-1]);
        New_Dir.createNewFile();
        
       }
       else {
           System.out.println("Fialed to create a Dir");
       }
  
      
    }
    public void ls () throws IOException{
        try{
        File Dir = new File(dir);
        File[] filesList = Dir.listFiles();
        for (File f : filesList) {
            if (f.isDirectory()){
              System.out.println(f.getName());
            }
            else if(f.isFile()){
                System.out.println(f.getName());
            }
        }
        }
        catch (Exception e) {
            System.out.println("No such Directory");
        }
        }

       public void ls (String s1 , String s2) throws IOException{
        String[] fille = null;
        String ff="";
        File Dir = new File(dir);
        File[] allfiles = Dir.listFiles();
        try{         
           for (int j=0 ;j<allfiles.length;j++){
           ff+= allfiles[j].toString();
           ff+="\n";
        }
         System.out.print(ff);
        }
        catch (Exception e) {
            System.out.println("No such Directory");
        }
        if(s1.equals(">"))
                        {
                            File f1 =  new File (s2);
                            f1.createNewFile();
                            {
                                
                                try (  
                                   FileWriter writer = new FileWriter(s2)) {
                                   writer.write(ff);
                                   writer.close();
                                }
                            }
       
                        }
        if(s1.equals(">>")){
            System.out.println("saas");
            try (BufferedWriter bw= new BufferedWriter(new FileWriter(s2, true))) {
              
                bw.write(ff);
                bw.newLine();
                bw.flush();
            } 
            }
    }
    
                  
    public  void lsa() throws IOException{
     try{
        Path path= Paths.get(dir);
        Stream<Path> subPaths=Files.walk(path); //get al files in path
        subPaths.forEach(System.out::println);
     }
     catch(IOException e){
         System.out.println("No such Directory");
     }
   }
    public void Date(){
                Date date=new Date();
                System.out.println(date.toString());
            }
    public void ClearScreen() {
            for (int i=0;i<20;i++)System.out.println(" ");
        }
    public void args(String arg){
            if(arg.equals( "clear") || arg.equals("Pwd") || arg.equals("date")  || arg.equals("ls") || arg.equals("help"))
                {
                    System.out.println("Number of args is 0 ");
                }
          else if(arg.equals("mkdir") || arg.equals("emdir") ||  arg.equals("cd"))
                {
                    System.out.println("Number of args is 1: Destination Path");
                }
          else if (arg.equals("more")){
              System.out.println("Number of args is 1: Source Path");
          }
          else if ( arg.equals("arg")  ){
              System.out.println("Number of args is 1: Command Type");
          }
          else if (arg.equals("cb") || arg.equals("mv")){
              System.out.println("Number of args is 2: Source Path ,Destination path");
          }
          else if (arg.equals("rm")){
              System.out.println("Number of args is 1: Source Path");
          }
          else{
              System.out.println("Many Number of args: The File Directories");

          }
    }
    public void help () throws IOException
    {
        Vector<String>all = new Vector();
        all.addElement("\\clear:\\ , restart the cmd , Takes no Arguments");
        all.addElement("\\Date:\\ , \\show the date , Takes no Arguments");
        all.addElement("\\cd:\\ , \\change the current directory to the defult one , Takes no Arguments");
        all.addElement("\\pwd:\\ , \\show the current directory, Takes no Arguments");
        all.addElement("\\ls:\\ , \\show all the file in the current directory, Takes no Arguments");
        all.addElement("\\Mkdir:\\ , \\make a directory in specfic path, Takes 1 Arguments which is New Directory Path");
        all.addElement("\\Rmdir:\\ , \\delete a directory in specfic path, Takes 1 Arguments which is the new Path of the directory");
        all.addElement("\\Cat:\\ , \\Concatenate files and print on the standard output , Takes 1 Arguments which is  The Files to be concatenated");
        all.addElement("\\more:\\ , \\display and scroll down the output in one direction only , Takes 1 Arguments which is the Path of the file");
        all.addElement("\\rm:\\ , \\delete file  , Takes 1 Arguments which is the Path of the file");
        all.addElement("\\cb:\\ , \\copy the file to new dirctory , Takes 2 Arguments : 1st , the source file path , 2nd , the destination file path ");
        all.addElement("\\mv:\\ , \\move the file to a new directory , Takes 2 Arguments : 1st , the source file path , 2nd , the destination file path ");
        for(int i=0 ; i<all.size() ; i++)
        {
            System.out.println(all.get(i));
        }
    }
}
