class Solution {
    public int[] sortedSquares(int[] nums) {
        // o(n) space
        // o(n) solution

        int leftIndex = 0 , rightIndex = nums.length - 1;

        int[] resultArray = new int[nums.length];
        int currentResultIndex = resultArray.length-1;

        while(leftIndex <= rightIndex) {
            if( Math.abs(nums[leftIndex]) <= Math.abs(nums[rightIndex]) ) {
                resultArray[currentResultIndex] = nums[rightIndex] * nums[rightIndex]; 
                rightIndex--;
            } else {
                resultArray[currentResultIndex] = nums[leftIndex] * nums[leftIndex];
                leftIndex++;
            }

            currentResultIndex--;
        }

        return resultArray;
    }
}

/*

tc 1
-10 -4 -1 0 3 5 8

it 1
li 0 ri 6 cra 6
10 <= 8 false 
    
li 1
ra 100

it 2
li 1 ri 6 cri 6
4 <= 8 true
    cra 64 100
    ri 5
cri 5

it 3
li 1 ri 5 cri 5
4 <= 5 true
    cra 25 64 100
    ri 4
cri 4
cra 25 64 100

it 4
li 1 ri 4 cri 4
4 <= 3 false

cra 16 25 64 100
li 2
cra 16 25 64 100

it 5
li 2 ri 4 cri 2
1 <= 3 true

cra 9 16 25 64 100
ri 3 

it 6
li 2 ri 3 cri 1
1 <= 0 false

cra 1 9 16 25 64 100
li 3 cri 0

it 7
li 3 ri 3 cri 0
0 <= 0 true
    cra 0 1 9 16 25 64 100
    ri 2
cri -1

it 8
li > ri


return cra
*/