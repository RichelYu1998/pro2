package cn.tedu.pojo;
/*
* POJO:简单java对象，就是用于封装数据的实体类
* eg:为了封装用户信息而创建的User类，就是一个pojo类
* JavaBean:通过Java语言所编写的可重用组件
* 业务bean:用于处理业务逻辑
* 实体bean:用于封装数据(POJO)
* */
public class User {
    private String name;
    private int age;
    private String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }
}
