package com.commonsorts;

// 插入排序（时间复杂度：O(n^2)，稳定，最好情况下即原数据已全部排序好则时间复杂度是O(n)，空间复杂度只需要带排序数据加一个额外辅助单位即可）
// 原理如其名，即如整理扑克牌每次拿到新牌先对比最后一个大牌，如果小才开始往前一一对比并插入合适位置否则直接放最后，默认每次拿到新牌前前面的牌已全部由小至大排序好。
public class InsertSort {
    public void insertSort(int[] a){
            int length = a.length; //数组长度，将这个提取出来是为了提高速度。
            int insertNum; //代表要插入的插入数

            for(int i = 1; i < length; i++){ //插入的次数
                insertNum = a[i]; //要插入的插入数
                int j = i - 1; //已经排序好的序列元素个数（0-j都是接下来while循环里的对比数，0-j可称为对比数序列）

                while(j >= 0 && a[j] > insertNum){ //对比数序列从后到前循环（循环到没有剩余对比数或循环到的对比数小于插入数则终止循环）
                    //（进入while说明还有对比数且该数大于插入数）
                    a[j+1] = a[j]; //将大于插入数的对比数向后移动一格
                    j--; //下一次对比的位置向前移一位
                }
                a[j+1] = insertNum; //将需要插入的数放在要插入的位置。(j为-1则意味着把插入数插入数组头位0位，j不为-1则意味把插入数插入对比序列最大且小于插入数的对比数的后一位)
            }
    }
}



/*
原理解释：
直接插入排序

经常碰到这样一类排序问题：把新的数据插入到已经排好的数据列中。
1.将第一个数和第二个数排序，然后构成一个有序序列
2.将第三个数插入进去，构成一个新的有序序列。
3.对第四个数、第五个数……直到最后一个数，重复第二步。

如何写写成代码：

1.首先设定插入次数，即循环次数，for(int i=1;i<length;i++)，1个数的那次不用插入。
2.设定插入数和得到已经排好序列的最后一个数的位数。insertNum和j=i-1。
3.从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位。
4.将当前数放置到空着的位置，即j+1。
*/



/* ???
想想上面的步骤3和4能不能通过swap函数合二为一？如果C++使用swap的话需要'#include<algorithm>'。
*/



/*
// 对顺序表L作直接插入排序
void InsertSort(SqList *L) {
    int i, j;
    for (i = 2; i <= L->length; i++) {
        // 需将L->r[i]插入有序子表
        if (L->r[i] < L->r[i - 1]) {
            // 设置哨兵
            L->r[0] = L->r[i];
            for (j = i - 1; L->r[j] > L->r[0]; j--) {
                //记录后移
                L->r[j + 1] = L->r[j];
            }
            // 插入到正确位置
            L->r[j + 1] = L->r[0];
        }
    }
}

// 如果排序记录是随机的，那么根据概率相同的原则，平均比较和移动次数约为(n^2)/4次。因此，我们得出直接插入排序法的时间复杂度为O(n2)。从这里也看出，同样的O(n^2)时间复杂度，直接插入排序法比冒泡和简单选择排序的性能要好一些。<大话数据结构>
*/