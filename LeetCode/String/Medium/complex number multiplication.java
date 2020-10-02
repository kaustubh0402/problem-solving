//https://leetcode.com/problems/complex-number-multiplication/
//problem no. 537

class Solution {
    public String complexNumberMultiply(String a, String b) {
        int first_real=0,second_real=0,first_complex=0,second_complex=0;
        int i=0;
        while(a.charAt(i)!='+') // for real number
        {
            i++;
        }
        first_real=Integer.parseInt(a.substring(0,i));
        int j=++i;    //Starting of imaginary part at index j
        while(a.charAt(i)!='i')  // for imaginary part
        {
            i++;
        }
        first_complex=Integer.parseInt(a.substring(j,i));
        
        
        i=0;
        while(b.charAt(i)!='+')
        {
            i++;
        }
        second_real=Integer.parseInt(b.substring(0,i));
        int k=++i;
        while(b.charAt(i)!='i')
        {
            i++;
        }
        second_complex=Integer.parseInt(b.substring(k,i));
        
        
        StringBuilder ans=new StringBuilder();
        int real_part=first_real*second_real-first_complex*second_complex;
        int imaginary_part=first_real*second_complex+first_complex*second_real;
        
        ans.append(real_part);
        ans.append('+');
        ans.append(imaginary_part);
        ans.append('i');
        
        return ans.toString();
    }
}
