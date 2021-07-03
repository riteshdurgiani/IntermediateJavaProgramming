package IOJava;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int i;
//        BufferedInputStream br = new BufferedInputStream(System.in);
//
//        while((i= br.read())!=-1){
//            System.out.println((char) i);
//        }
//        br.close();

        //File Reading and Writing
//        FileOutputStream fos = new FileOutputStream("./a.txt");
//        BufferedInputStream bis = new BufferedInputStream(System.in);
//        while((i=bis.read())!=-1){
//            fos.write(i);
//        }
//        bis.close();
//        fos.close();
//        FileInputStream fis = new FileInputStream("./a.txt");
//        while((i=fis.read())!=-1){
//            System.out.print((char)i);
//        }
//        fis.close();

        //try with resources , copying contents of one file to another
//        try(FileInputStream fis = new FileInputStream("./a.txt");
//                BufferedInputStream bis = new BufferedInputStream(fis);
//                    FileOutputStream fos = new FileOutputStream("./b.txt")
//                ){
//
//            while((i=bis.read())!=-1){
//                fos.write(i);
//                System.out.print((char)i);
//            }
//            fos.close();
//            fis.close();
//            bis.close();
//
//        }catch (FileNotFoundException e){
//            System.out.println(e.toString());
//        }catch (Exception e){
//            System.out.println(e.toString());
//        }

        //FileReader
//        FileWriter fw = new FileWriter("./fileWriterA.txt");
//        FileReader fr = new FileReader("./a.txt");
//        BufferedReader br = new BufferedReader(fr);
//        while((i=br.read())!=-1){
//            fw.write((char)i);
//        }
//        fw.append("THIS IS APPENDED STRING");
//        fw.close();
//        fr.close();
//        br.close();
//        FileReader fr1 = new FileReader("./fileWriterA.txt");
//        BufferedReader br1 = new BufferedReader(fr1);
//        while((i=br1.read())!=-1){
//            System.out.print((char)i);
//        }
//
//        //Scanner Reading
//        FileInputStream fis = new FileInputStream("./a.txt");
//        Scanner sc = new Scanner(fis);
//        StringBuffer sb = new StringBuffer();
//        while(sc.hasNext()){
//            sb.append(sc.next());
//        }
//
//        FileOutputStream fos = new FileOutputStream("./scannerFile.txt");
//        Iterator it = sb.chars().iterator();
//        while(it.hasNext()){
//            fos.write((int)it.next());
//        }
//
//        FileInputStream fis1 = new FileInputStream("./scannerFile.txt");
//        sc = new Scanner(fis1);
//        StringBuffer sb1 = new StringBuffer();
//        while(sc.hasNext()){
//            sb.append(sc.next());
//        }




    }
}
