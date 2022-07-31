package Services;

import java.util.Arrays;
import java.util.Stack;

public class construction{
    static boolean largestfloor;
    static boolean flag;

    public static void calculateFloors(int[] floorSize) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < floorSize.length; i++) {
            largestfloor = true;
            int floorSize_i = floorSize[i];
            for (int j = i; j < floorSize.length; j++) {
                if (j == i) {
                    continue;
                } else {
                    int floorSize_j = floorSize[j];
                    if (floorSize_i >= floorSize_j) {
                        largestfloor = true;
                        continue;
                    } else {
                        largestfloor = false;
                        stack.push(floorSize_i);
                        break;
                    }
                }
            }

            if (largestfloor == true) {
                    Stack stackTemp = displayFloor(stack, floorSize_i, i, floorSize);
                    stack.clear();
                    stack = (Stack<Integer>) stackTemp.clone();
                    stackTemp.clear();
                    System.out.println();
            } else {
                System.out.println("Day " + (i + 1) + " :");
            }
        }
    }

    public static Stack displayFloor(Stack stack, int currentFloor, int iter, int[] arrayFloor) {

        int[] arrayOfPoppedItems = new int[arrayFloor.length];
        int count = 0;

        System.out.print("Day " + (iter + 1) + " : " + currentFloor);
        Stack<Integer> stackTemp = new Stack<Integer>();
        boolean largestInStack;
        if (iter == arrayFloor.length - 1) {
            while (!stack.empty()) {
                int popFloor = (int) stack.pop();
                arrayOfPoppedItems[count++] = popFloor;
            }
            if (arrayOfPoppedItems != null) {
                Arrays.sort(arrayOfPoppedItems);
                for (int i = arrayOfPoppedItems.length - 1; i > 0; i--) {
                    if (arrayOfPoppedItems[i] != 0) {
                        System.out.print(" " + arrayOfPoppedItems[i]);
                    }

                }
            }

            return stackTemp;
        } else {
            if (!stack.empty()) {
                while (!stack.empty()) {
                    largestInStack = true;
                    int popFloor = (int) stack.pop();
                    for (int i = iter; i < arrayFloor.length; i++) {
                        if (i == iter) {
                            continue;
                        }
                        if (popFloor < arrayFloor[i]) {
                            stackTemp.push(popFloor);
                            largestInStack = false;
                            break;
                        } else {
                            largestInStack = true;
                        }
                    }
                    if (largestInStack == true) {
                        arrayOfPoppedItems[count++] = popFloor;
                    }
                }
            }
            if (arrayOfPoppedItems != null) {
                Arrays.sort(arrayOfPoppedItems);
                for (int i = arrayOfPoppedItems.length - 1; i > 0; i--) {
                    if (arrayOfPoppedItems[i] != 0) {
                        System.out.print(" " + arrayOfPoppedItems[i]);
                    }
                }
            }

            return stackTemp;
        }
    }
}


