import org.w3c.dom.ls.LSOutput;

import java.security.SecureRandom;
import java.sql.SQLOutput;
import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {

        SecureRandom oRand = new SecureRandom();
        int iNumTotal = 999999999;
        int[] aiNumbers =  new int[iNumTotal];
        int iTargetNum;
        int iTargetNumIndex;
        int iIndexReturned;
        long lTimeStarted;
        long lTimeEnded;

        //Fill array with random numbers.
        for (int i = 0; i < aiNumbers.length; i++ ){
            aiNumbers[i] = oRand.nextInt();

        }

        // Sort the array to enable binary search
        Arrays.sort(aiNumbers);

        // Get a target number to pass to our search algo.

        iTargetNumIndex = oRand.nextInt(aiNumbers.length); //0-99
        iTargetNum = aiNumbers[iTargetNumIndex];
        System.out.println("target number's index is: " + iTargetNumIndex);

        BinarySearch oBinarySearch = new BinarySearch();

        // begin binary search test
        lTimeStarted = System.nanoTime();
        iIndexReturned = oBinarySearch.findNumberBinarySearch(aiNumbers, iTargetNum, aiNumbers.length-1, 0);
        lTimeEnded = System.nanoTime();
        System.out.println("Binary Search elapsed time: " + (lTimeEnded - lTimeStarted));
        System.out.println("Binary search returned: " + iIndexReturned);

        // begin linear search test
        lTimeStarted = System.nanoTime();
        iIndexReturned = oBinarySearch.findNumberLinearSearch(aiNumbers, iTargetNum);
        lTimeEnded = System.nanoTime();
        System.out.println("Linear Search elapsed time: " + (lTimeEnded - lTimeStarted));
        System.out.println("Linear search returned: " + iIndexReturned);
    }

    /**
     * Find index of target num using binary search via recursion.
     */
    private int findNumberBinarySearch(int[] aiNumbers, int iTargetNum, int iHighIndex, int iLowIndex){

        // Get middle index
        int iMiddleIndex = ((iHighIndex + iLowIndex) /2);

        // Check if target number is at middle index
        if(aiNumbers[iMiddleIndex] == iTargetNum){
            return iMiddleIndex;
        }

        // Check if target number is greater than the number at the middle index.
        if(iTargetNum > aiNumbers[iMiddleIndex]){
            return findNumberBinarySearch(aiNumbers, iTargetNum, iHighIndex, iMiddleIndex +1);
        }

        // Then target number is less than the number at the middle index.
        else{
            return findNumberBinarySearch(aiNumbers, iTargetNum, iMiddleIndex -1, iLowIndex);
        }

    }


    /**
     *  Find index of target num using linear search.
     */

    private int findNumberLinearSearch(int[] aiNums, int iTargetNum){

        for(int x = 0; x < aiNums.length; x++) {
            if (aiNums[x] == iTargetNum) {
                return x;
            }
        }
        return -1; // -1 is a standard error
    }

}
