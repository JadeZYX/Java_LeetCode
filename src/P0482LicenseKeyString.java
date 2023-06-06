import java.util.ArrayList;
import java.util.List;

public class P0482LicenseKeyString {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase().replace("-", "");// 把字母变成大写
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (len % k != 0) {
            sb.append(s.substring(i, i + (len % k)));
            i += (len % k);
        }

        while (i < s.length()) {
            if (sb.length() > 0) {
                sb.append('-');
            }

            sb.append(s.substring(i, i + k));
            i += k;
        }

        return sb.toString();
    }

    public String licenseKeyFormatting1(String s, int k) {
        s = s.toUpperCase().replace("-", "");// 把字母变成大写
        int len = s.length();
        List<String> sb = new ArrayList<>();
        int i = 0;
        if (len % k != 0) {
            sb.add(s.substring(i, i + (len % k)));
            i += (len % k);
        }

        while (i < s.length()) {
            sb.add(s.substring(i, i + k));
            i += k;
        }

        return String.join("-", sb);
    }

    public String licenseKeyformatting2(String s,int k){
        s=s.toUpperCase();//转大写
        s=s.replaceAll("-", "");//去除所有的dashes，用空字符串替代
        StringBuilder sb = new StringBuilder(s);//把整个string S添加到sb里
        for(int i=s.length()-k;i>0;i=i-k){
            sb.insert(i, "-");//从后面开始插入破折号
        }
        return sb.toString();
    }
}
       //P0482LicenseKeyString p482=new P0482LicenseKeyString();
       //System.out.println(p482.licenseKeyFormatting("5F3Z-2e-9-w", 4));
       //System.out.println(p482.licenseKeyFormatting("2-5g-3-J", 2));
       //System.out.println(p482.licenseKeyFormatting("---", 3));