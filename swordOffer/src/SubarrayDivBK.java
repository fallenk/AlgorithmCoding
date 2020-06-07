import java.util.HashMap;
import java.util.Map;

// 974 和可被K整除的子数组
public class SubarrayDivBK {
    public static void main(String[] args) {

    }
    // 1. 暴力循环
    public int subarrayDivByK2(int[] A, int K) {
        int length = A.length;
        String str = new String();
        str.length();
        int cnt = 0;
        for (int i=0; i<length; i++) {
            int sum = A[i];
            if (sum%K == 0){
                cnt++;
            }
            for (int j=i+1; j<length; j++) {

                sum += A[j];
                if (sum%K == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 1. 哈希表 + 逐一统计
    // 本题与题目 560 非常相似，可以从相同的角度思考解法。而由于本题提高了数据量的要求，暴力法在本题不能通过，因此这里不再给出。
    // 思路和算法
    //模式识别：通常，涉及连续子数组问题的时候，我们使用前缀和来解决。 用一个新数组来记录 P[i] = A[0]+A[1]+...+A[i]
    public int subarrayDivByk(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : A) {
            sum += elem;
            int modulus = (sum%K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same+1);
        }
        return ans;
    }


}
