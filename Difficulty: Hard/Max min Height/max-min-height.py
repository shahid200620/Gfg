class Solution():
    def maxMinHeight(self, arr, k, w):
        def is_possible(target):
            ops = 0
            n = len(arr)
            diff = [0] * (n + 1)
            curr_add = 0

            for i in range(n):
                curr_add += diff[i]
                current_height = arr[i] + curr_add
                if current_height < target:
                    needed = target - current_height
                    ops += needed
                    if ops > k:
                        return False
                    curr_add += needed
                    if i + w < n:
                        diff[i + w] -= needed
            return True

        low = min(arr)
        high = max(arr) + k
        answer = low

        while low <= high:
            mid = (low + high) // 2
            if is_possible(mid):
                answer = mid
                low = mid + 1
            else:
                high = mid - 1

        return answer
