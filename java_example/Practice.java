public class Practice {
    
    // 1. 배열의 합 구하기
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    
    // 2. 배열의 최댓값 찾기
    public static int findMax(int[] arr) {
        if (arr.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    // 3. 배열의 최솟값 찾기
    public static int findMin(int[] arr) {
        if (arr.length == 0) {
            return Integer.MAX_VALUE;
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    // 4. 팩토리얼 계산
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    // 5. 피보나치 수열 (재귀)
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    // 6. 피보나치 수열 (반복)
    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    
    // 7. 이진 탐색
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // 찾지 못함
    }
    
    // 8. 문자열 뒤집기
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    
    // 9. 소수 판별
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    
    // 10. 배열 정렬 (버블 정렬)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    // 테스트 메인 메서드
    public static void main(String[] args) {
        // 배열 테스트
        int[] testArray = {3, 7, 2, 9, 1, 5};
        System.out.println("배열: " + java.util.Arrays.toString(testArray));
        System.out.println("합: " + sumArray(testArray));
        System.out.println("최댓값: " + findMax(testArray));
        System.out.println("최솟값: " + findMin(testArray));
        
        // 팩토리얼 테스트
        System.out.println("\n5! = " + factorial(5));
        
        // 피보나치 테스트
        System.out.println("\n피보나치(10) = " + fibonacci(10));
        System.out.println("피보나치 반복(10) = " + fibonacciIterative(10));
        
        // 이진 탐색 테스트
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println("\n정렬된 배열: " + java.util.Arrays.toString(sortedArray));
        System.out.println("7의 인덱스: " + binarySearch(sortedArray, 7));
        
        // 문자열 뒤집기 테스트
        System.out.println("\n'Hello' 뒤집기: " + reverseString("Hello"));
        
        // 소수 판별 테스트
        System.out.println("\n17은 소수? " + isPrime(17));
        System.out.println("20은 소수? " + isPrime(20));
        
        // 정렬 테스트
        int[] unsortedArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\n정렬 전: " + java.util.Arrays.toString(unsortedArray));
        bubbleSort(unsortedArray);
        System.out.println("정렬 후: " + java.util.Arrays.toString(unsortedArray));
    }
}


