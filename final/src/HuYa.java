

import java.io.*;
import java.util.*;

public class HuYa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入完整文章路径：");
        String pathname1 = scanner.next();
        System.out.println("请输入单词文件路径：");
        String pathname2 = scanner.next();
        System.out.println("重复出现过的单词为：");

        try {
            String s1 = readString1(pathname1);
            // System.out.println(s1);
            String s2 = readString2(pathname2);


            //System.out.println(s2);
            Set<String> set = find(s1, s2);
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (Exception e) {
        }


    }

    //将文章内容转化为字符串
    public static String readString1(String pathname) {
        String str = "";
        File file = new File(pathname);
        try {
            FileInputStream in = new FileInputStream(file);
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            str = new String(buffer, "utf-8");
        } catch (IOException e) {
            return null;
        }
        return str;
    }

    //将单词表转化为字符串
    public static String readString2(String name) throws Exception {
        File file = new File(name);//定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s = bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
        }
        bReader.close();
        String str = sb.toString();
        return str;

    }

    //找出两个文件中重复出现的单词
    public static Set<String> find(String str1, String str2) {
        //TreeSet存储不重复元素
        Set<String> a = new TreeSet<>();

        String m1 = str1.replaceAll("\\n", " ");
        String m2 = m1.replaceAll(",", " ");
        String m3 = m2.replaceAll("!", " ");
        String m4 = m3.replace("?", " ");
        String m5 = m4.replace(".", " ");
        String m6 = m5.replace("-", " ");
        String m7 = m6.replace(":", " ");
        String m8 = m7.replace("(", " ");
        String m9 = m8.replace(")", " ");
        String m10 = m9.replace("\"", " ");

        //System.out.println(m4);
        String str3 = str2.replaceAll("\\n", " ");
        // System.out.println(str3);
        //将出现过的元素添加到TreeSet中
        String[] b1 = m6.split(" ");
        String[] b2 = str3.split(" ");
        for (int i = 0; i < b1.length; i++) {
            for (int j = 0; j < b2.length; j++) {
                if (b1[i].equals(b2[j])) {
                    a.add(b1[i]);

                }
            }
        }
        return a;
    }
}








