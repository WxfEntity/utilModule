package com.wxf.uitl;

/**
 * Created by wxf on 2017/12/19.
 */
public class CallByValue {
    public static int x=10;

    public static void updateValue(int value){
        value = 3 * value;
    }


    public static void updateUser(User student){
        student.setName("Lishen");
        student.setAge(18);
    }

    private static User user=null;
    private static User stu=null;
    public static void swap(User x,User y){
        User temp =x;
        x=y;
        y=temp;
        System.out.println(x+"  ~~~~~ "+y);

    }
    public static void main(String[] args) {
        System.out.println("调用前x的值："+x);
        updateValue(x);
        System.out.println("调用后x的值："+x);
        user = new User("zhangsan",26);
        System.out.println("调用前user的值："+user.toString());
        updateUser(user);
        System.out.println("调用后user的值："+user.toString());

        user = new User("user",26);
        stu = new User("stu",18);
        System.out.println("调用前user的值："+user.toString());
        System.out.println("调用前stu的值："+stu.toString());
        swap(user,stu);
        System.out.println("调用后user的值："+user.toString());
        System.out.println("调用后stu的值："+stu.toString());
    }

}
