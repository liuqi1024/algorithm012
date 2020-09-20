# 毕业总结-算法训练营第12期

一直以来，算法都是我的短板，在平时讨论中，代码评审中，或者面试中只要问到一个有点类似于算法相关的问题就特别紧张。这种紧张感，来源于对这方面知识的缺失，因为无知所以害怕。

有时候想一想，程序员不会算法，是不是就和医生拿起手术刀不会用一样？在医院里，即使是做到科室主任，还是需要安排固定的出诊时间，这就是说明职位做的再高，基本功不能丢！
所以，我报名参加了算法训练营，希望能通过类似健身教练的方式，指导和督促我能补上这个短板。回想起10周的学习过程，收获了很多知识，也唤起了尘封已久的关于大学课程的记忆。
前几周属于基础知识，学着学着都有似曾相识的感觉。后面学到了高级算法，布隆过滤器这些，又开拓了自己的知识面。
10周想来很长，但是实际走过来，感觉自己的时间都不太够用，好在最终还是坚持了下来。

收获最大的还是“刻意练习”这一思想吧，自从知道了超哥的“刻意练习”思想之“五毒神掌”后，心里上已经不在惧怕学算法，就是熟能生巧呗。

以下是本期算法知识的简单回顾：

## 数据结构

- 一维：
  - 基础：数组 array (string), 链表 linked list
  - 高级：栈 stack, 队列 queue, 双端队列 deque, 集合 set, 映射 map (hash or map), etc. TreeMap, HashMap 
- 二维：
  - 基础：树 tree, 图 graph
  - 高级：二叉搜索树 binary search tree (red-black tree, AVL), 堆 heap, 并查集 disjoint set, 字典树 Trie, etc
-  特殊：
  - 位运算 Bitwise, 布隆过滤器 BloomFilter
  - LRU Cache
  
## 时间复杂度

![](https://img2020.cnblogs.com/blog/740516/202008/740516-20200812161810866-474917451.png)

## 学习要点

- 基本功是区别业余和职业选手的根本。深厚功底来自于 — 过遍数
- 最大的误区：只做一遍
- 五毒神掌
- 刻意练习 - 练习缺陷弱点地方、不舒服、枯燥
- 反馈 - 看题解、看国际版的高票回答

## 代码模板



### 递归

```java
    public void recur(int level, int param) { 
        // terminator 
        if (level > MAX_LEVEL) { 
        // process result 
            return; 
        } 
         
         // process current logic 
        process(level, param); 
         
         // drill down 
        recur( level: level + 1, newParam); 
         
        // restore current status 
     
    }
```



### 深度优先DFS

```java
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();// 结果集
        if (root==null) {
            return allResults;
        }
        travel(root, 0, allResults);// 0代表第0层
        return allResults;
    }

    private void travel(TreeNode root,int level,List<List<Integer>> results){
        // results代表每层结果集，集合大小和层数一样，开辟下一层空间
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        
        // 每一层的结果都是一个array，放到new array里
        results.get(level).add(root.val);
        
        if (root.left!=null) {
            travel(root.left, level+1, results);
        }
        if (root.right!=null) {
            travel(root.right,level+1,results);
        }
    }
```



### 广度优先BFS

```java
    // 将每一层元素放到队列中，然后将队首出队，存入每层的结果，下一层再放到队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();// 队列元素不断增加，size保留初始大小
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                results.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            allResults.add(results);
        }
        return allResults;
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
```



### 二分查找

```java
    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;// 或者mid = (right + left) / 2
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
```



### 并查集

```java
public class UnionFind {
        private int count = 0;
        private int[] parent;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }
    
        public int getCount() {
            return count;
        }
    }
```



### 字典树Trie

```java
public class Trie {
        class TireNode {
            private boolean isEnd;
            TireNode[] next;
    
            public TireNode() {
                isEnd = false;
                next = new TireNode[26];
            }
        }
    
        private TireNode root;
        public Trie() {
            root = new TireNode();
        }
    
        public void insert(String word) {
            TireNode node = root;
            char[] words = word.toCharArray();
            for (char c : word.toCharArray()) {
                if (node.next[c-'a'] == null) {
                    node.next[c-'a'] = new TireNode();
                }
                node = node.next[c-'a'];
            }
            node.isEnd = true;
        }
    
        public boolean search(String word) {
            TireNode node = root;
            for (char c : word.toCharArray()) {
                node = node.next[c-'a'];
                if (node == null) {
                    return false;
                }
            }
            return node.isEnd;
        }
    }
```
    

## 排序动画

• https://www.cnblogs.com/onepixel/p/7674659.html

• https://www.bilibili.com/video/av25136272

• https://www.bilibili.com/video/av63851336
    
    

    
    
