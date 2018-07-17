/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: HelloClient.java
 * Date: 18-7-17 下午3:03
 * Author: Xiong Raorao
 */

package top.xraorao.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * .
 *
 * @author Xiong Raorao
 * @since 2018-07-17-15:03
 */
public class HelloClient {

  public static void main(String[] args) {
    try {
      Hello h = (Hello) Naming.lookup("rmi://192.168.1.5:12312/Hello");
      System.out.println(h.sayHello("zx"));
    } catch (MalformedURLException e) {
      System.out.println("url格式异常");
    } catch (RemoteException e) {
      System.out.println("创建对象异常");
      e.printStackTrace();
    } catch (NotBoundException e) {
      System.out.println("对象未绑定");
    }
  }

}
