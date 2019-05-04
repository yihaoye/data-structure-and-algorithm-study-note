/*
在计算机科学中，二分搜索（英语：binary search），也称折半搜索（英语：half-interval search）、对数搜索（英语：logarithmic search），
是一种在有序数组中查找某一特定元素的搜索演算法。搜索过程从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜索过程结束；
如果某一特定元素大于或者小于中间元素，则在数组大于或小于中间元素的那一半中查找，而且跟开始一样从中间元素开始比较。
如果在某一步骤数组为空，则代表找不到。这种搜索算法每一次比较都使搜索范围缩小一半。
*/

// 递归版本 ("start"原始值为0，"end"原始值为arr.length()-1)
int binary_search(const int arr[], int start, int end, int key) {
	if (start > end)
		return -1;

	int mid = start + (end - start) / 2; //直接平均可能會溢位，所以用此算法
	if (arr[mid] > key)
		return binary_search(arr, start, mid - 1, key);
	if (arr[mid] < key)
		return binary_search(arr, mid + 1, end, key);
	return mid; //最後檢測相等是因為多數搜尋狀況不是大於要不就小於
}

// while循环（迭代版本）
int binary_search(const int arr[], int start, int end, int key) {
	int mid;
	while (start <= end) {
		mid = start + (end - start) / 2; //直接平均可能會溢位，所以用此算法
		if (arr[mid] < key)
			start = mid + 1;
		else if (arr[mid] > key)
			end = mid - 1;
		else
			return mid; //最後檢測相等是因為多數搜尋狀況不是大於要不就小於
	}
	return -1;
}