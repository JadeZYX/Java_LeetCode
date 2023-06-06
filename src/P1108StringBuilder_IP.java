public class P1108StringBuilder_IP {
    public String defangIPaddr(String address){
        StringBuilder res=new StringBuilder();
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)=='.'){
                res.append("[.]");
            }
            else{
                res.append(address.charAt(i));
            }
        }
        return res.toString();
    }
}/*
      P1108StringBuilder_IP p1108=new P1108StringBuilder_IP();
       System.out.println(p1108.defangIPaddr("1.1.1.1"));
*/