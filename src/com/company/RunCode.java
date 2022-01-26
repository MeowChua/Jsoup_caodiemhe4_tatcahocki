package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class RunCode {
    public static void main(String []args)throws Exception{
        String content[]=new String [50];
        try {
            Formatter f = new Formatter("/Users/hominhcanh/IdeaProjects/Jsoup/out/production/Jsoup/com/company/file_he4.txt");
    try {
        File x = new File("/Users/hominhcanh/IdeaProjects/Jsoup/out/production/Jsoup/com/company/input.txt");
        Scanner sc = new Scanner(x);

        int i =0;
        while(sc.hasNextLine()) {
            content[i] = sc.nextLine()+"\r\n";
            i++;
        }
        for(int j =0;j<content.length;j++)
            if(content[j]!=null){
                //System.out.print(content[j]+"\n");
                //
            }
        sc.close();
    } catch (
    FileNotFoundException e) {
        System.out.println("Error");
    }
        String url ="http://thongtindaotao.sgu.edu.vn/Default.aspx?page=xemdiemthi&id=";
        //String st[]={"3119410039","3119410033"};
        for(int i =0;i<content.length;i++) {
            if (content[i] != null) {
                System.out.print(content[i]);
                f.format("%s", content[i]+":\n");
                final Document document = Jsoup.connect(url.concat(content[i])).get();
                //System.out.println(document.outerHtml());
                //System.out.print(content );
                String stmp[]= new String [2];
                for (Element row : document.select("table tr")) {

                    final String title = row.select(".row-diemTK").text();
                    if (title.startsWith("Điểm trung bình học kỳ hệ 4:")) {
                        String[] a;
                        //System.out.println(title);
                        a = title.split(":");
                        System.out.print("\t" + a[1] + "\t");
                        f.format("%s", a[1]+":\t");
                    }

                }

                //Tạo mới và viết nội dung vào file




                    //f.close();


                System.out.println();
            }
        }
        } catch (Exception e) {
            System.out.println("Error");
        }

}
}
