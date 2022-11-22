package com.dataStrucure.stack;


import java.math.BigInteger;
import java.util.*;

public class Stack {
    private ListNode top;
    private int length;


    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public Stack() {
        top = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public void push(int data) {
        ListNode node = new ListNode(data);
        node.next = top;
        top = node;
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty stack");
        } else {
            int data = top.data;
            top = top.next;
            length--;
            return data;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public String reverse(String str) {
        java.util.Stack<Character> stacks = new java.util.Stack<Character>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            stacks.push(c);

        }
        for (int i = 0; i < str.length(); i++) {
            chars[i] = stacks.pop();
        }

        return new String(chars);
    }

    private int[] nextGreaterElement(int arr[]) {
        int[] result = new int[arr.length];
        java.util.Stack<Integer> integerStack = new java.util.Stack<Integer>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!integerStack.isEmpty()) {
                while (!integerStack.isEmpty() && (integerStack.peek() < arr[i])) {
                    integerStack.pop();
                }
            }
            if (integerStack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = integerStack.peek();
            }
            integerStack.push(arr[i]);
        }
        return result;
    }

    public boolean isValid(String string) {
        char[] input = string.toCharArray();
        java.util.Stack<Character> stacks = new java.util.Stack<Character>();
        for (char c : input) {
            if (c == '(' || c == '{' || c == '[') {
                stacks.push(c);
            } else {
                if (stacks.isEmpty()) {
                    return false;
                } else if ((c == ')' && stacks.peek() == '(')
                        || (c == '}' && stacks.peek() == '{')
                        || (c == ']' && stacks.peek() == '[')) {
                    stacks.pop();
                } else {
                    return false;
                }
            }
        }

        return stacks.isEmpty();
    }

    public boolean isSymetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        stack.push(root.right);
        stack.push(root.left);
        while (!stack.isEmpty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if (n1 == null && n2 == null) {
                continue;
            }
            if (n1 == null || n2 == null || n1.data != n2.data) {
                return false;
            }
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n2.left);
            stack.push(n1.right);
        }


        return true;
    }

    private class TreeNode {
        private int data; // Generic type
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

    }


    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int maxans = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidParentheses1(String s) {
        int answer = 0;

        int open = 0;
        int close = 0;

        // 0 to n-1
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            if (ch == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                int totalLength = open + close;
                answer = Math.max(answer, totalLength);
            } else if (close > open) {
                open = close = 0;
            }
        }

        open = close = 0;

        // n-1 to 0
        for (int index = s.length() - 1; index >= 0; index--) {
            char ch = s.charAt(index);

            if (ch == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                int totalLength = open + close;
                answer = Math.max(answer, totalLength);
            } else if (open > close) {
                open = close = 0;
            }
        }

        return answer;
    }

    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            str = count(str);
        }
        BigInteger x = BigInteger.valueOf(1);
        BigInteger x1 = BigInteger.valueOf(1);
        String x2 = x.multiply(x1).toString();

        return str;
    }

    private String count(String str) {
        if (str.length() == 1) return "1" + str.charAt(0);
        String countAndSay = "";
        int count = 1, i = 1;
        for (i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                count++;
            } else {
                countAndSay += String.valueOf(count) + str.charAt(i - 1);
                count = 1;
            }
        }
        countAndSay += String.valueOf(count) + str.charAt(i - 1);
        return countAndSay;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> st = new ArrayList<>();
        Map<String, List<String>> hs = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String p = strs[i];
            char[] arr = p.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if (hs.containsKey(sorted)) {
                List<String> m = hs.get(sorted);
                List<String> m1 = new ArrayList<>();
                m1.add(p);
                m1.addAll(m);
                hs.put(sorted, m1);
            } else {
                hs.put(sorted, Arrays.asList(p));
            }
        }
        for (Map.Entry<String, List<String>> entry : hs.entrySet()) {
            st.add(entry.getValue());
        }
        return st;
    }

    public boolean isMatch(String s, String p) {

        s.matches(p);
        char c[] = s.toCharArray();
        if (p.contains("*")) {
            for (int i = 0; i < s.length() - 1; i++) {
                if (c[i] != '*' && c[i] == c[i + 1] && p.equalsIgnoreCase(String.valueOf(c[i]))) {

                } else {
                    return false;
                }
            }
        } else if (p.contains(".*")) {
            return true;
        }
        return s.contains(p);
    }

    public int lengthOfLastWord(String s) {
        String[] as = s.split(" ");
        String s1 = as[as.length - 1];
        return s1.length();
    }

    public boolean isNumber(String s) {
        boolean hasDigit = false;
        boolean hasExponent = false;
        boolean hasDecimal = false;
        boolean needDigitAfterExponent = false;

        s = s.trim();

//        For example, all the following are valid numbers:
//        ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1",
//                "53.5e93", "-123.456e789"],
//        while the following are not valid numbers:
//        ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'E' && s.charAt(i - 1) != 'e') return false;

            } else if (Character.isDigit(c)) {
                hasDigit = true;
                needDigitAfterExponent = false;

            } else if (c == '.') {
                if (hasDecimal || hasExponent) return false;
                hasDecimal = true;

            } else if (c == 'E' || c == 'e') {
                if (hasExponent || !hasDigit) return false;
                hasExponent = true;
                needDigitAfterExponent = true;

            } else return false;
        }

        return !needDigitAfterExponent && hasDigit;
    }

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(10);
        stack.push(15);
        stack.push(20);


//        int peek = stack.peek();
//        System.out.println("peek ::: " + peek);
//        int pop = stack.pop();
//        System.out.println("pop ::: " + pop);
//        int peek1 = stack.peek();
//        System.out.println("peek ::: " + peek1);
//
//        String reverse = stack.reverse("mukesh");
//        System.out.println("reverse ::: " + reverse);
//        int[] data = new int[]{3, 5, 6, 3, 4, 5, 9, 10, 1};
//        int[] data1 = stack.nextGreaterElement(data);
//        for (int i = 0; i < data1.length; i++) {
//            System.out.print(data1[i] + " , ");
//        }

//        String changes = stack.countAndSay(5);
//
//        System.out.println("isValid ::: " + changes);
//        List<List<String>> hs = stack.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
//        System.out.println("isValid ::: " + hs);
//        3e+7
//        System.out.println("isValid ::: " + stack.isNumber("3e+7"));

        System.out.println(stack.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(stack.numDecodings("226"));


    }

    public int numDecodings(String s) {
        Set<String> ls = new HashSet<String>();
        for (int i = 0; i < s.length()-1; i++) {
            char c = s.charAt(i);
            String p1= getStringValue(String.valueOf(c));
            ls.add(p1);

            String s1 = new String(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1)));
            String p2 = getStringValue(getStringValue(s1.toString()));
            ls.add(p2);

        }
        return ls.size();
    }


    public boolean isInterleave(String s1, String s2, String s3) {

        String s = s1 + s2;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        char[] chars1 = s3.toCharArray();
        Arrays.sort(chars1);
        String sorted1 = new String(chars1);
        if (sorted.equalsIgnoreCase(sorted1)) {
            return true;
        } else {
            return false;
        }
    }

    public String getStringValue(String s) {
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("1", "A");
        hashMap.put("2", "B");
        hashMap.put("3", "C");
        hashMap.put("4", "D");
        hashMap.put("5", "E");
        hashMap.put("6", "F");
        hashMap.put("7", "G");
        hashMap.put("8", "H");
        hashMap.put("9", "I");
        hashMap.put("10", "J");
        hashMap.put("11", "K");
        hashMap.put("12", "L");
        hashMap.put("13", "M");
        hashMap.put("14", "N");
        hashMap.put("15", "O");
        hashMap.put("16", "P");
        hashMap.put("17", "Q");
        hashMap.put("18", "R");
        hashMap.put("19", "S");
        hashMap.put("20", "T");
        hashMap.put("21", "U");
        hashMap.put("22", "V");
        hashMap.put("23", "W");
        hashMap.put("24", "X");
        hashMap.put("25", "Y");
        hashMap.put("26", "Z");

        return hashMap.get(s);
    }
}
