/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: HelloServer.java
 * Date: 18-7-17 下午2:45
 * Author: Xiong Raorao
 */

package top.xraorao.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * .
 *
 * @author Xiong Raorao
 * @since 2018-07-17-14:45
 */
public class HelloServer {

  public static void main(String[] args) {
    try {
      Hello h = new HelloImpl();

      //创建并导出接受指定port请求的本地主机上的Registry实例。
      LocateRegistry.createRegistry(12312);

      /**  Naming 类提供在对象注册表中存储和获得远程对远程对象引用的方法
       *  Naming 类的每个方法都可将某个名称作为其一个参数，
       *  该名称是使用以下形式的 URL 格式（没有 scheme 组件）的 java.lang.String:
       *  //host:port/name
       *  host：注册表所在的主机（远程或本地)，省略则默认为本地主机
       *  port：是注册表接受调用的端口号，省略则默认为1099，RMI注册表registry使用的著名端口
       *  name：是未经注册表解释的简单字符串
       */
      //Naming.bind("//host:port/name", h);
      Naming.bind("rmi://192.168.1.5:12312/Hello", h);
      System.out.println("HelloServer启动成功");

    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (AlreadyBoundException e) {
      e.printStackTrace();
    }
  }

}
