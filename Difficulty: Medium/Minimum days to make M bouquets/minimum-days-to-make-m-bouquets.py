class Solution:
    def minDaysBloom(self, arr, k, m):
        def is_possible(no_of_days):
            count = 0
            flowers = 0
            for days in arr:
                if days <= no_of_days:
                    flowers += 1
                    if flowers == k:
                        count += 1
                        flowers = 0
                else:
                    flowers = 0
            return count >= m
        n = len(arr)
        if k * m > n:
            return -1
        left = min(arr)
        right = max(arr)
        res = -1
        while left <= right:
            mid = (left + right) // 2
            if is_possible(mid):
                res = mid
                right = mid - 1
            else:
                left = mid + 1
        return res