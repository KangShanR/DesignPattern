package designpattern.singleton;

/**
 * @description
 * @author KangShan
 * @date 2019/2/19 15:36
 */
public class Test {

    public static void main(String[] args){
        System.out.println("fasdfsadf\n\tsdfsadf\n\tsdfsdfsd");

    }


    int[] arrayQuickSort(int[] numbers){

        if(numbers.length == 1){
            return numbers;
        }else if(numbers.length == 0){
            throw new IllegalArgumentException("参数错误");
        }else if(numbers.length == 2){
            if(numbers[0] <= numbers[1]){
                return numbers;
            }else {
                return new int[]{numbers[1], numbers[0]};
            }
        }else {
            int pivotIndex = numbers.length,
                    leftIndex = 0,
                    rightIndex= numbers.length - 1;
            

            return arrayQuickSort(numbers);
        }
    }
}
