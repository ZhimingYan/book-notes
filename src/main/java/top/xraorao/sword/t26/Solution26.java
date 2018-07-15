/*
 * Copyright (c) 2018.  Xiong Raorao. All rights reserved.
 * Project Name: book-notes
 * File Name: Solution26.java
 * Date: 18-6-27 上午8:28
 * Author: Xiong Raorao
 */

package top.xraorao.sword.t26;

/**
 * 复杂链表的复制.
 *
 * 思路：
 *
 * 第一步，根据原始链表的每个节点N创建对应的N', 把N'链接到N的后面 第二步，原链表的N的random节点对应复制出来的在N'的random在其后面 第三步，拆分链表
 *
 * @author Xiong Raorao
 * @since 2018-06-27-8:28
 */
public class Solution26 {

  public RandomListNode Clone(RandomListNode pHead) {
    RandomListNode pNode = pHead;
    while (pNode != null) {
      RandomListNode pCloned = new RandomListNode(pNode.label);
      pCloned.next = pNode.next;
      pCloned.random = pNode.random;

      // 新节点放在老节点后面
      pNode.next = pCloned;
      pNode = pCloned.next; // N' 已经复制了N，这里把N的下一个节点接在N'后面
    }

    pNode = pHead;
    while (pNode != null) {
      // N’
      RandomListNode pCloned = pNode.next;
      if (pNode.random != null) {
        pCloned.random = pNode.random.next;
      }
      pNode = pCloned.next;
    }

    // 拆分链表
    pNode = pHead;
    RandomListNode pClonedHead = null;
    RandomListNode pClonedNode = null;

    if (pNode != null) {
      pClonedHead = pClonedNode = pNode.next;
      pNode.next = pClonedNode.next;
      pNode = pNode.next;
    }

    // 这里 pNode 已经在 pClonedNode 后面一位
    while (pNode != null) {
      pClonedNode.next = pNode.next;
      pClonedNode = pClonedNode.next; // pCloned 移动到pNode后面
      pNode.next = pClonedNode.next;
      pNode = pNode.next; // pNode 移动后pCloned 后面
    }

    return pClonedHead;

  }

}


