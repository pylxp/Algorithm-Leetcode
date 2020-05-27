package java.t100_t199.t150_t159;

public class T155 {
    class MinStack {
        //提升为全局变量，方便调用
        //分别为标准栈和最小栈
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            //最小栈，那么这里无非就是在栈的基础上
            //添加一个获取最小值的功能
            //即可以额外维护一个栈，遇到更小值则存入

            //初始化栈
            stack = new Stack<>();
            minStack = new Stack<>();
        }
        //push方法
        public void push(int x) {
            //入栈
            stack.push(x);
            //如果遇到更小值，则压入最小栈
            if (minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);
        }
        //pop方法
        public void pop() {
            //如果出栈的数是最小值，则弹出
            if (stack.pop().equals(minStack.peek())) minStack.pop();
        }
        //top方法
        public int top() {
            //出栈
            return stack.peek();
        }
        //getMin方法
        public int getMin() {
            //弹出最小值
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
