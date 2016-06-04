package utils;

import java.util.LinkedList;
import java.util.List;

public class ShortArray {

    private int startNumber;
    private int middleAprox;
    private boolean middleActive;

    public ShortArray(int startNumber) {
        this.startNumber = startNumber;
        this.middleActive = true;
    }

    public Integer[] calculateArray(int number){
        boolean sum = false;
        List<Integer> list = new LinkedList<Integer>();
        boolean arrive = false;
        middleAprox = number/2;
        list.add(this.startNumber);

        do{
            if(list.get(list.size()-1) == number) {
                arrive = true;
            } else {
                int current = calculateCurrent(sum, list.get(list.size()-1), this.startNumber);

                list.add(current);

                sum = isSum(current, number, list);
            }
        } while(!arrive);

        return list.toArray(new Integer[list.size()]);

    }

    public int calculateCurrent(boolean isSum, int number, int positiveInteger){
        int multiplyNumber = 2;
        int sumNumber = 1;
        if(!isSum) {
            if (number == 0) {
                number = positiveInteger * multiplyNumber;
            } else {
                number = number * multiplyNumber;
            }
        } else {
            number = number + sumNumber;
        }
        return number;
    }

    public boolean isSum(int current, int number, List<Integer> list){

        boolean sum = false;

        if(current * 2 > number) {
            sum = true;
        }
        if(number%2 == 0 && current * 4 > number) {
            sum = true;

        }
        if(current * 2 == number) {
            sum = false;
        }

        if(this.middleAprox <= current && middleActive){
            sum = true;
            if(this.middleAprox == current) {
                this.middleActive = false;
                sum = false;
            } else {
                list.remove(list.size()-1);
            }
        }
        return sum;
    }




}

