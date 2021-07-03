package IOJava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOJava {
    public static void main(String[] args) throws IOException {
        //create directories
//        Path p = Paths.get("LearnNIO");
//        Path donePath = Files.createDirectories(p);
//        Path p1 = Paths.get("./src");
//        System.out.println(Files.isWritable(p));
//        System.out.println("Directory Created at + " + donePath.toString());

        //create file
//        Path f = Paths.get("LearnNIO/file1.txt");
//        Path f1 = Files.createFile(f);
//        System.out.println("File created at "+ f1.toString());

        //read from file
//        Path r = Paths.get("LearnNIO/file1.txt");
//        List<String> fileData = Files.readAllLines(r);
//        Iterator<String> it = fileData.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }

        //writing to file :
        //1. using byte array:
//        Path p2 = Paths.get("LearnNIO/file2.txt");
//        String content = "This is content of file 2 written as byte array ";
//        Files.write(p2,content.getBytes());
//        System.out.println("File 2 text written using bytes array");

        //2. using array of strings
//        Path r = Paths.get("LearnNIO/file1.txt");
//       List<String> fileData = Files.readAllLines(r);
//       Path p3 = Paths.get("LearnNIO/file3.txt");
//       Files.write(p3,fileData);
//        System.out.println("File 3 written ");


        //Moving a file
        //look at the power of NIO , moving 50 mb file in less than a second
//        Path source = Paths.get("C:\\Users\\rdurg\\Downloads\\SampleZIPFile_50mbmb.zip");
//        Path destination = Paths.get("LearnNIO/pastedHere.zip");
//        System.out.println("Started at : "+new Date());
//        Files.move(source,destination);
//        System.out.println("Ended at : "+ new Date());
//        System.out.println("Moved Succesfully");


        //copying a file
//        Path source = Paths.get("LearnNIO/pastedHere.zip");
//        Path destination = Paths.get("LearnNIO/pastedHere1.zip");
//        System.out.println("Started at : "+new Date());
//        Files.copy(source,destination);
//        System.out.println("Ended at : "+ new Date());
//        System.out.println("Moved Succesfully");


        //append a file
        Path p2 = Paths.get("LearnNIO/file2.txt");
        String content = "This is content of file 2 written as byte array appended toend ";
        //this lines move cursor to next line
        Files.write(p2,System.getProperty("line.separator").getBytes(),StandardOpenOption.APPEND);
        Files.write(p2,content.getBytes(), StandardOpenOption.APPEND);
        System.out.println("File 2 appended");
    }
}
