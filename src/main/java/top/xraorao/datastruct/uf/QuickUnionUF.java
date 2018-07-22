/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: QuickUnionUF.java
 * Date: 18-7-22 下午3:32
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct.uf;

/**
 * 快速进行union操作.
 *
 * 可以快速进行 union 操作，只需要修改一个节点的 id 值即可（最顶上的id修改好就行了），但是查找会变慢
 *
 * @author Xiong Raorao
 * @since 2018-07-22-15:24
 */
public class QuickUnionUF extends UF {

  public QuickUnionUF(int N) {
    super(N);
  }

  @Override
  public int find(int p) {
    while (p != id[p]) {
      p = id[p];
    }
    return p;
  }

  @Override
  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot != qRoot) {
      id[pRoot] = qRoot;
    }
  }
}
