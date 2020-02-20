import java.util.ArrayList;
public class MinNumberInRotatedArray {
    public int minNumberInRotateArray(int [] array) {
        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = index1;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            
            indexMid = (index1 + index2) / 2;
            
            // 如果下标为index1，index2 和 indexMid 指向的三个数字相等，
            // 则只能顺序查找
            if (array[index1] == array[index2] 
                && array[indexMid] == array[index1])
                return MinInOrder(array, index1, index2);
            
            if (array[indexMid] >= array[index1])
                index1 = indexMid;
            else if (array[indexMid] <= array[index2])
                index2 = indexMid;
        }
        
        return array[indexMid];
    }
    
    public int MinInOrder(int [] array, int index1, int index2) {
        int result = array[index1];
        for (int i = index1 + 1; i <= index2; ++i) {
            if (result > array[i])
                result = array[i];
        }
        return result;
    }
}
