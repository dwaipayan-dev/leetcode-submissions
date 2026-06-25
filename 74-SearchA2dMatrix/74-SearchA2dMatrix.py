# Last updated: 6/25/2026, 8:39:49 AM
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        nRows = len(matrix)
        nCols = len(matrix[0])
        nElements = nRows * nCols;
        low = 0
        high = nElements - 1
        while(low <= high):
            mid = (low + high)//2
            r_mid = mid//nCols
            c_mid = mid%nCols
            print(r_mid, c_mid)
            if(matrix[r_mid][c_mid] == target):
                return True
            elif(matrix[r_mid][c_mid] < target):
                low = mid + 1
            else:
                high = mid - 1
        return False
        