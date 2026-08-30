class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        RemoveDuplicates obj = new RemoveDuplicates();

        int[] nums = {1, 1, 2};

        int k = obj.removeDuplicates(nums);

        System.out.println("k = " + k);

        System.out.print("Array = ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}