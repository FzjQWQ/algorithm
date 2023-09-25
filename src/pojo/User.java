package pojo;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author roy f
 */
public class User implements Serializable {
    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public User() {
        System.out.println("构造");
    }

    private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
//        this.name = "tom";
//        this.age = 8;
//        stream.writeObject(name);
//        stream.writeInt(8);
        stream.defaultWriteObject();
    }

    private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
//        System.out.println(name + "," + age);
    }
}
