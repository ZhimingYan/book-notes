/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: WeightedQuickUnionUF.java
 * Date: 18-7-22 下午3:32
 * Author: Xiong Raorao
 */

package top.xraorao.datastruct.uf;

/**
 * 为了解决 quick-union 的树通常会很高的问题，加权 quick-union 在 union 操作时会让较小的树连接较大的树上面。理论研究证明，加权 quick-union
 * 算法构造的树深度最多不超过 logN。.
 *
 * @author Xiong Raorao
 * @since 2018-07-22-15:26
 */
public class WeightedQuickUnionUF extends UF {

  // 保存节点的数量信息
  private int[] sz;

  public WeightedQuickUnionUF(int N) {
    super(N);
    sz = new int[N];
    for (int i = 0; i < N; i++) {
      sz[i] = 1;
    }
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
    int i = find(p);
    int j = find(q);
    if (i == j) {
      return;
    }
    if (sz[i] < sz[j]) {
      id[i] = j;
      sz[j] += sz[i];
    } else {
      id[j] = i;
      sz[i] += sz[j];
    }
  }
}
