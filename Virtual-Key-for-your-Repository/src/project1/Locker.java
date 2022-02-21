package project1;

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.PrintWriter;
        import java.util.Arrays;
        import java.util.Collections;
        import java.util.List;
        import java.util.Scanner;

public class Locker {
    public static void listingFile() {
        File fileDir = new File("D:\\java\\eclipse\\ExceptionHandling\\src\\Virtual Key for Your Repositories\\src\\list");
        if(fileDir.isDirectory()){
            List <String>listFile = Arrays.asList(fileDir.list());
            Collections.sort(listFile);
            System.out.println("---------------------------------------");
            System.out.println("Sorting by filename in ascending order");
            for(String s:listFile){
                System.out.println(s);
            }
            //  just for practice writing in decending order.
            System.out.println("---------------------------------------");
            System.out.println("Sorting by filename in descending order");
            Collections.sort(listFile,Collections.reverseOrder());
            for(String s:listFile){
                System.out.println(s);
            }

        }
        else{
            System.out.println(fileDir.getAbsolutePath() + " is not a directory");
        }
    }
    public static void createFile() {
        Scanner sc = new Scanner(System. in ); //object of Scanner class
        System.out.println("Enter the file name : ");
        String name = sc.nextLine(); //variable name to store the file name
        File file = new File("D:\\java\\eclipse\\ExceptionHandling\\src\\Virtual Key for Your Repositories\\src\\list\\"+name);

        try {
            if (file.createNewFile()) {
                System.out.println("File Created!");
            } else {
                System.out.println("File already exists :(");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }




    public static void deleteMethod() {
        String filename;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the Name of File to Delete: ");
        filename = scan.nextLine();

        File file= new File("D:\\java\\eclipse\\ExceptionHandling\\src\\Virtual Key for Your Repositories\\src\\list\\"+filename);

        if (file.delete()) {
            System.out.println("File deleted successfully");
        }
        else {
            System.out.println("Failed to delete the file");
        }

    }
    public static void searchMethod() {
        System.out.println("Enter the name of the file to Search");
        Scanner s1 = new Scanner(System.in);
        String folderName = s1.next();
        File file = new File("D:\\java\\eclipse\\ExceptionHandling\\src\\Virtual Key for Your Repositories\\src\\list\\"+folderName);

        if (file.exists()) {
            System.out.println("Yep! File found!");
        } else {
            System.out.println("Sorry, File is not here (File Not Found)");
        }

        try {
            PrintWriter pw = new PrintWriter(file);
            pw.println("saved");
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {

        System.out.println("**********************");
        System.out.println("Welcome to LOCK ME :) ");
        System.out.println(" LockerMe.com");
        System.out.println("Develop by JAY");
        System.out.println("**********************");
        int option = 0;
        int choice=0;

        Scanner sc=new Scanner(System.in);

        while(true) {
            System.out.println("Please select one the following");
            System.out.println("1 for current file names in ascending order ");
            System.out.println("2 for your personal file");
            System.out.println("3 for exit application");
            try {
                option=sc.nextInt();
            }catch(Exception e){
                System.out.println("You did not choose valid number please run program again and enter valid number from 1-3");
                System.exit(option);
            }


            switch(option) {
                case 1 :
                    System.out.println("These are the files in ascending");
                    listingFile();
                    break;
                case 2 :
                    System.out.println("You have selected your personal file");
                    System.out.println("Please choose one of the following options :");
                    System.out.println("1. Create a file");
                    System.out.println("2. Delete a File");
                    System.out.println("3. Search for a File");
                    try {
                        choice=sc.nextInt();
                    }catch(Exception e) {
                        System.out.println("please run program again and enter valid number");
                    }
                    switch(choice) {
                        case 1:
                            System.out.println("You have selected option 1");
                            // String fileCreate=sc.next();
                            createFile();

                            continue;
                        case 2:
                            System.out.println("You have selected to Delete file");
                            deleteMethod();
                            continue;
                        case 3:
                            System.out.println("You have Selected to search file");
                            searchMethod();
                            continue;
                        case 4:
                            System.out.println("going back");
                            break;
                    }


                    break;
                case 3 :
                    System.out.println("Have a nice day!! Thanks for using locker ");
                    System.out.println("Application closed");

                    System.exit(option);
                    break;
                case 4:
                default:
                    System.out.println("Oops!! please enter the valid number");

            }
        }
    }


}