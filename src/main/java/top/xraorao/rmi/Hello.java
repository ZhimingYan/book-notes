/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Hello.java
 * Date: 18-7-17 下午2:33
 * Author: Xiong Raorao
 */

package top.xraorao.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * .
 *
 * @author Xiong Raorao
 * @since 2018-07-17-14:33
 */
public interface Hello extends Remote {

  String sayHello(String name) throws RemoteException;
}
