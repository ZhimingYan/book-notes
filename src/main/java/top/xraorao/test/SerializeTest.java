/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: SerializeTest.java
 * Date: 18-7-17 上午11:05
 * Author: Xiong Raorao
 */

package top.xraorao.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象序列化测试.
 *
 * @author Xiong Raorao
 * @since 2018-07-17-11:05
 */
public class SerializeTest {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    A a = new A();
    a.setName("hhh");
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\oos"));
    oos.writeObject(a);
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\oos"));
    A aa = (A) ois.readObject();
    System.out.println(aa.getName());
  }

  static class A implements Serializable {

    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
