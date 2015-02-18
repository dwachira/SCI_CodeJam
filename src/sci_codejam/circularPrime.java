
/**
 * http://www.codechef.com/viewsolution/2972948
 **/

package sci_codejam;

import java.util.ArrayList;
import java.util.Scanner;
 
class circularPrime {
static int get(int n,int i,int digit)
{
int p;
p=(int)Math.pow(10,i-1);
n=n/p;
return n%10;
}
static boolean isprime(int n)
{
for(int i=2;i<n ; i++)
{
if(n%i==0)
return false;
}
return true;
}
static int shift(int n,int digit)
{
int i,j,a,sum=0;
for(i=1,j=1 ; i<=digit ; i++,j++ )
{
a=get(n,i,digit);
if(i==digit)
sum+=a;
else
sum+=a*Math.pow(10,j);
}
return sum;
}
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
int n,digit,i;
ArrayList<Integer> ans=new ArrayList<Integer>(0);
for(int k=0 ; k<t ; k++){
n=sc.nextInt();
digit=(int) (Math.log10(n)+1);
for(i=1; i<digit ; i++)
{
n=shift(n,digit);
//System.out.println("NUM "+n);
if(!isprime(n))
{
ans.add(k,0);
//System.out.println("NO");
break;
}
}
if(i==digit)
{ans.add(k,1);//System.out.println("YES");
}
}
for(i=0 ; i<t ; i++)
{
if(ans.get(i)==0)
System.out.println("No");
if(ans.get(i)==1) 
    System.out.println("Yes");
}
}
}
