package lc222ak_assign1;

public class Arrays {
    public static void main(String [] args) throws Error {
    }

    static int sum(int[] arr) {
        int result = 0;
        for (int anArr : arr) {
            result += anArr;
        }
        return result;
    }

    static String toString(int[] arr) {
        StringBuilder strBuilder = new StringBuilder();
        for (int anArr : arr) {
            strBuilder.append(anArr);
        }

        return strBuilder.toString();
    }

    static int[] addN(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += n;
        }
        return arr;
    }

    static int[] reverse(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[arr.length - 1 - i];
        }
        return newArr;
    }

    static void replaceAll(int[] arr, int old, int nw) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == old) {
                arr[i] = nw;
            }
        }
    }

    static int[] sort(int[] arr) {
        int[] newArr = new int[arr.length];
        int holder = 0;
        System.arraycopy( arr, 0, newArr, 0, arr.length );

        for (int i = 0; i < newArr.length; i++) {
            for (int j = 1; j < newArr.length - i; j++) {
                if (newArr[j - 1] > newArr[j]) {
                    holder = newArr[j-1];
                    newArr[j - 1] = newArr[j];
                    newArr[j] = holder;
                }
            }
        }
        return newArr;
    }

    static boolean hasSubsequence(int[] arr, int[] sub) {
        int counter = 0;

        for (int el : arr) {
            if (el == sub[counter]) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == sub.length) {
                return true;
            }
        }
        return false;
    }

    static int[] absDif(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new Error("Both arrays must be same length");
        }
        int[] newArr = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            newArr[i] = arr1[i] - arr2[i];
            if (newArr[i] < 0) {
                newArr[i] = -newArr[i];
            }
        }
        return newArr;
    }
}
