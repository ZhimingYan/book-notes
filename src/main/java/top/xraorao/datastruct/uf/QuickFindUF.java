/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: QuickFindUF.java
 * Date: 18-7-22 下午3:32
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct.uf;

/**
 * 可以快速进行 find 操作，即可以快速判断两个节点是否连通。.
 *
 * @author Xiong Raorao
 * @since 2018-07-22-15:17
 */
public class QuickFindUF extends UF {

  public QuickFindUF(int N) {
    super(N);
  }

  @Override
  public int find(int p) {
    return id[p];
  }

  @Override
  public void union(int p, int q) {
    int pID = find(p);
    int qID = find(q);

    if (pID == qID) {
      return;
    }

    for (int i = 0; i < id.length; i++) {
      if (id[i] == pID) {
        id[i] = qID;
      }
    }
  }
}
