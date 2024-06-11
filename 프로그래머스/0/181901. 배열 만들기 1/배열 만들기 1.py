def solution(n, k):
    answer = []
    
    for i in range(n):
        if (i + 1) % k == 0:
            answer.append(i + 1)
            
    return answer