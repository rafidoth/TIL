import java.net.CacheRequest;

public class Solve {
    public static void main(String[] args) {
        System.out.println("hello");
    }
    //iterative implementation of Binary Search algorithm
    public static int binarySearch(int[] nums, int target){
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while(start<=end){
            int mid = start + (end-start) /2;
            if(target==nums[mid]) return mid;
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }


    //Recursive implementation of BinarySearch
    private static int bsRec(int[] nums, int start, int end,int target){
        if(start>end) return -1;
        int mid = start + (end-start) /2;
        if(target== nums[mid]) return mid;
        else if (target > nums[mid]){
            return bsRec(nums, mid+1, end,target);
        }
        else{
            return bsRec(nums, start, mid-1, target);
        }
        
    }
    public static int binarySearchRecursive(int[] nums, int target){
        int n = nums.length;
        int start = 0;
        int end = n-1;
        return bsRec(nums, start, end, target);
    }


    // lower bound implementation
    public static int lowerBound(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int ans = nums.length;
        while(start <= end){
            int mid = start + (end-start) /2;
            if(nums[mid]<target){
                start = mid+1;
            }else if(nums[mid] >= target){
                ans = mid;
                end = mid -1;
            }
        }

        return ans;
    }

    // upper bound implementation
    public static int upperBound(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        int ans = nums.length;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid]<=target){
                start = mid+1;
            }else if(nums[mid]>target){
                ans = mid;
                end = mid-1;
            }
        }

        return ans;
    }

    //floor and ceil of the number in array
    public static int[] floorAndCeil (int[] nums, int target){
        int[] result = new int[2];
        result[1] = BS.lowerBound(nums,target);
        int start = 0;
        int end = nums.length-1;
        while(start <=end){
            int mid = start + (end-start) /2;
            if(nums[mid]<=target){
                result[0] = mid;
                start = mid +1;
            }else if(nums[mid]>target){
                end = mid-1;
            }
        }
        return result;
    }


    // first and last occurances of the number in an array
    public static int[] firstAndLast(int[] nums, int target){
        int lb = BS.lowerBound(nums, target);
        if(lb ==nums.length || nums[lb] != target ){
            int[] result = {-1,-1};
            return result;
        }else{
            int ub = BS.upperBound(nums, target);
            int result[]  = {lb,ub-1};
            return result;
        }
    }

    // first and last occurances of the number in the array 
    // using plain binary search 
    // without using lower bound upper bound concept
    private static int getFirstOccurance(int[] nums, int target){
        int start = 0;
        int end  = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] >= target) end = mid-1;
            else start = mid + 1; 
        }
        return start;
    }
    
    private static int getLastOccurance(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end - start )/2;
            if(nums[mid] <= target) start = mid +1;
            else end = mid -1;
        }
        return end;
    }
    public static int[] firstAndLastOccurance(int[] nums, int target){
        int firstIndex = getFirstOccurance(nums, target);
        int lastIndex = getLastOccurance(nums, target);
        if(firstIndex == nums.length || nums[firstIndex] != target ) return new int[] {-1,-1};
        if(lastIndex == nums.length || nums[lastIndex] != target) return new int[] { -1,-1};
        return new int[] {firstIndex, lastIndex};
    }


    // find the number of occurances of an element in an array
    // https://leetcode.com/discuss/interview-question/algorithms/124724/google-find-the-number-of-occurrences-of-an-element-in-a-sorted-array
    public static int numberOfOccurance(int[] nums, int target){
        return getLastOccurance(nums, target) - getFirstOccurance(nums, target)+1;
    }


    //Search element in Rotated Sorted Array-I (Unique elements)
    public static int searchInRotatedArray(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        while(start <=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[start]<=nums[mid]){
                if(target>=nums[start] && target<nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            } else{
                if(target>nums[mid] && target <=nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }



    //Search element in Rotated Sorted Array-II (Duplicate elements)
    // Important Time Complexity explaination
    public static boolean searchInRotatedArrayDup(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        while(start <=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target) return true;
            else if(nums[mid]== nums[start] && nums[mid]== nums[end]){
                end--;
                start++;
            }
            else if(nums[start]<=nums[mid]){
                if(target>=nums[start] && target<nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            } else{
                if(target>nums[mid] && target <=nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return false;
    }



    // finding the minimum in the Rotated Sorted Array
    public static int minimumInRotated(int[] nums){
        int start = 0;
        int end = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[start]<= nums[end]){
                min = nums[start];
                break;
            }
            else if(nums[start]<=nums[mid]){
                if(nums[start]<min) min = nums[start];
                start = mid +1;
            }else{
                if(nums[mid]<min) min = nums[mid];
                end = mid -1;
            }
        }
        return min;
    }


    // how many times the array is rotated or find the pivot
    // https://practice.geeksforgeeks.org/problems/rotation4723/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    public static int findPivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        int min = Integer.MAX_VALUE;
        int pivot = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[start]<= nums[end]){
                if(nums[start]<min){
                    min = nums[start];
                    pivot = start;
                }
                break;
            }
            else if(nums[start]<=nums[mid]){
                if(nums[start]<min){
                    min = nums[start];
                    pivot = start;
                }
                start = mid +1;
            }else{
                if(nums[mid]<min){
                    min = nums[mid];
                    pivot = mid;
                }
                end = mid -1;
            }
        }
        return pivot;
    }



    // 1752. Check if Array Is Sorted and Rotated
    // public static boolean isSortedAndRotated(int[] nums) {
    //     int rotation_no = 0;
    //     for(int i =0;i<nums.length-1;i++){
    //         if(nums[i]>nums[i+1]){
    //             rotation_no++;
    //             if(rotation_no>1) return false;
    //         }
    //     }
    //     return true;
    // }

    //540. Single Element in a Sorted Array
    // naive solution without binary search
    // public static int singleNonDuplicate(int[] nums) {
    //     int n = nums.length;
    //     if(n==1 || nums[0]!=nums[1]) return nums[0];
    //     for(int i =1;i<n;i++){
    //         if(nums[i]==nums[i-1] || nums[i] == nums[(i+1)%n]){
    //             continue;
    //         }else{
    //             return nums[i];
    //         }
    //     }
    //     return -1;
        
    // }
    



    //540. Single Element in a Sorted Array
    //binary search solution
    public static int singleNonDuplicate(int[] nums ){
        int n = nums.length;
        int start = 1;
        int end = n-2;
        if(nums.length==1 || nums[0]!=nums[1]) return nums[0];
        else if(nums[n-1]!=nums[n-2]) return nums[n-1];

        while(start<=end){
            int mid = start + (end - start)/2;
            
            if(nums[mid]!= nums[mid-1] && nums[mid]!= nums[mid+1]) return nums[mid];
            else if(nums[mid]==nums[mid-1]){
                if((mid-1)%2==0) start = mid +1;
                else end = mid -1;
            }
            else {
                if((n-mid-2)%2==0) end = mid -1;
                else start = mid + 1; //[1,1,2,2,4,4,5,6,6]
            }
        }
        return -1;
        
    }



    // Find the sqrt
    public static int mySqrt(int x) {
        int start = 0;
        int end = x;
        while(start<=end){
            int mid = start + (end - start )/2;
            long sqr = (long)mid*(long)mid;
            if(sqr == x) return mid;
            else if(sqr < x) start = mid +1;
            else end = mid -1;
        }
        return end;
    }



    //find N th root of a Number
    public static int NthRoot(int x, int N){
        int start = 1;
        int end = x;
        while(start<=end){
            int mid = start + (end - start )/2;
            System.out.println(mid);
            long val = Math.binpow(mid, N);
            System.out.println(val);
            if(val == x) return mid;
            else if(val > x){
                end = mid -1;
            }else{
                start = mid +1;
            }

        }
        return -1;
    }


    //koko eating banana
    // https://leetcode.com/problems/koko-eating-bananas
    //time complexity O(k*n)
    public static int kokoEatingBanana(int[] piles, int h){
        int k = 1;
        int len = piles.length;
        while(true){
            int totalTime= 0;
            for(int i = 0;i<len;i++){
                totalTime += ((piles[i]%k)>0? (piles[i]/k)+1 : piles[i]/k);
            }
            if(totalTime<=h){
                return k;
            }else k++;
        }
    }

    private static int calculateTime(int[] piles, int k){
        int totalTime = 0;
        for(int i=0;i<piles.length;i++){
            totalTime+= (((double)piles[i]%(double)k)>0? ((double)piles[i]/k)+1 : (double)piles[i]/(double)k);
        }
        return totalTime;
    }

    public static int effKokoEatingBanana(int[] piles, int h){
        int start = 1;
        int end = Util.MaxInArray(piles);
        int k = 1;
        while(start<= end){
            int mid = start + (end - start)/2;
            int time = calculateTime(piles, mid);
            if(time<= h) {
                k = mid;
                end = mid -1;
            }
            else if(time > h){
                start = mid +1;
            }
        }
        return k;
    }


}


