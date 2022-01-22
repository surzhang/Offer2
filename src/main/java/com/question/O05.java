package com.question;

/**
 * @author zyk
 * @version 1.0
 * @fileName O5
 * @description :TODO 替换空格
 * @date 2022/1/22 14:31
 */
public class O05 {
    //方法1：遍历添加
    public static String replaceSpace(String s){
        StringBuilder res = new StringBuilder();
        for (Character c:s.toCharArray()) {
            if(c==' '){
                res.append("%20");
            }
            else{
                res.append(c);
            }
        }
        return res.toString();
    }
    //字符数组
    public String replaceSpace2(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }


    public static void main(String[] args) {
        O05.replaceSpace("i love you");
    }
}
