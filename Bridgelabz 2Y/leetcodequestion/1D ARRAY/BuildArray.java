class BuildArray {

    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    public static void main(String[] args) {
        BuildArray obj = new BuildArray();

        int[] nums = {0, 2, 1, 5, 3, 4};

        int[] result = obj.buildArray(nums);

        System.out.print("Array = ");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}