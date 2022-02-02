package com.question3;

/**
 * @author zyk
 * @version 1.0
 * @fileName O43
 * @description :TODO 1-n整数中1出现的次数
 * @date 2022/2/2 15:20
 */
public class O43 {
    public int countDigitOne(int n) {
        int digit =1,res=0;
        //高位，当前位，低位
        int high = n/10,cur=n%10;
        int low = 0;
        while(high!=0||cur!=0){
            //当前位为0
            if (cur==0){
                res+=high*digit;
            }else if (cur==1){
                res+=high*digit+low+1;
            }else{
                res+=(high+1)*digit;
            }
            //低位前进，当前位前进，高位回退，digit*10
            low+=cur*digit;
            cur=high%10;
            high/=10;
            digit*=10;
        }
        return res;
    }
}
