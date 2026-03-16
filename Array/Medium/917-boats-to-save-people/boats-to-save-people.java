/*

people array iTh persion weight  > 0
boat maxWeight = limit
maxNumber per boat 2 <= limit

min number of boats

tc 1
people  1 10 limit 2
not possible

tc 2
people 1 2 3 4 limit 1000
2

tc 3
people 1 2 3 1500 limit 100
not possible

tc 4
20 50 33 34 limit 70

tc 5
5 21 50 19 

5 48 49 50
*/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int leftIndex = 0 , rightIndex = people.length-1;

        int currTotalWeight = 0;
        int numberOfBoats = 0;
        while(leftIndex <= rightIndex) {
            currTotalWeight = people[leftIndex] + people[rightIndex];
            if(currTotalWeight <= limit) {
                leftIndex++;
                rightIndex--;
            } else {
                rightIndex--;
            }

            numberOfBoats++;
        }

        return numberOfBoats;
    }
}