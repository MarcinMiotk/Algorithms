for _ in range(input()):
    n = input()
    arr = map(int,raw_input().split())
    max_sum = -999999999
    c_sum = 0
    sum1 = 0
    for i in range(n):
        sum1+=arr[i]
        if arr[i]>0:
            c_sum += arr[i]
        if sum1>max_sum:
            max_sum = sum1
        if sum1<0:
            sum1 = 0
    if c_sum == 0:
        c_sum = max(arr)
    print max_sum,c_sum