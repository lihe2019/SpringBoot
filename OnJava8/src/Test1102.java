import java.util.Arrays;

public class Test1102 {

    public static void main(String[] args) {
        /*System.out.println(Converstion(11));*/
        //数组复制
        //System.arraycopy和Arrays.copyOfRange的见解(笔记)

        int [] arry=new int []{4,7,1,2,9,10};
        int [] dest=new int[6];
        //采用system.arraycopy的方式
        System.arraycopy(arry, 2, dest,3 , 2);//意思是从arry数组中的下标为2的位置开始复制到dest中下标为3的起始位置，只复制两个数

        for(int i:dest){
            System.out.print(i+" ");//结果0 0 0 1 2 0
        }
        System.out.println(dest.length);
        dest= Arrays.copyOfRange(arry, 2, 5);//会改变dest数组的引用，相当于重新指向另外一个返回的数组，从arry的第2个位置开始复制到5-1个位置给dest
        for(int i:dest){
            System.out.print(i+" ");//结果1 2 9

        }
        System.out.println("");
        System.out.println(dest.length);//长度为3，会改变数组的大小。
    }

}
