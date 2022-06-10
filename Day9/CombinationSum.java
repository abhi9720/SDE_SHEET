
/*
This is same , picking or not picking 
but as in question given we can pick any index element any number of times 
so after picking candidates[idx] we still stay at same index id, didn't move 

(2^n)*k  
 k - > work to putting one data structure in other data structure
*/
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> comb = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, comb, new ArrayList<Integer>());
        return comb;
    }

    private void combinationSumHelper(int[] cand, int tar, int idx, List<List<Integer>> comb, 
                                                                     ArrayList<Integer> curr) {
        int n = cand.length;

        if (idx == n || tar == 0) {
            if (tar == 0) {
                comb.add(new ArrayList<>(curr));
            }
            return;
        }

        // either include or not include
        if (tar >= cand[idx]) {
            curr.add(cand[idx]);
            combinationSumHelper(cand, tar - cand[idx], idx , comb,curr);
            curr.remove(curr.size() - 1);
        }

        combinationSumHelper(cand, tar, idx + 1, comb,curr);
    }
}
