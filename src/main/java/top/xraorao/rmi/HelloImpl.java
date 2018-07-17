/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: HelloImpl.java
 * Date: 18-7-17 下午2:34
 * Author: Xiong Raorao
 */

package top.xraorao.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * .
 *
 * @author Xiong Raorao
 * @since 2018-07-17-14:34
 */
public class HelloImpl extends UnicastRemoteObject implements Hello {

  private static final long serialVersionUID = -271947229644133464L;

  protected HelloImpl() throws RemoteException {
    super();
  }

  @Override
  public String sayHello(String name) throws RemoteException {
    return "Hello, " + name;
  }
}

