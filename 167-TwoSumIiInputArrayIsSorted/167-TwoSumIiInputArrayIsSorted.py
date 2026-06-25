# Last updated: 6/25/2026, 8:38:47 AM
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        head = 0
        tail = len(numbers) - 1
        while(head < tail):
            targetSum = numbers[head] + numbers[tail]
            if(targetSum == target):
                return [head+1, tail+1]
            elif(targetSum > target):
                tail -= 1
            elif(targetSum < target):
                head += 1