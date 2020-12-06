## 二叉堆
二叉堆（binary heap）是一种特殊的堆，二叉堆是完全二叉树或者是近似完全二叉树。二叉堆满足堆特性：父节点的键值总是保持固定的序关系于任何一个子节点的键值，且每个节点的左子树和右子树都是一个二叉堆。当父节点的键值总是大于或等于任何一个子节点的键值时为“最大堆”。当父节点的键值总是小于或等于任何一个子节点的键值时为“最小堆”。  
  
最大堆和最小堆是二叉堆的两种形式。  
* 最大堆：根结点的键值是所有堆结点键值中最大者的堆。
* 最小堆：根结点的键值是所有堆结点键值中最小者的堆。  
  
![](./Min%20Heap.png)  
  
而`最大—最小堆`集结了最大堆和最小堆的优点，这也是其名字的由来。  
`最大—最小堆`是最大层和最小层交替出现的二叉树，即最大层结点的子节点属于最小层，最小层结点的子节点属于最大层。 以最大（小）层结n点为根结点的子树保有最大（小）堆性质：根结点的键值为该子树结点键值中最大（小）项。  
  