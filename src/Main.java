import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SortPrinterMachineIMP sortPrinterMachineIMP = new SortPrinterMachineIMP();
        sortPrinterMachineIMP.inDigit(5);
        sortPrinterMachineIMP.inDigit(2);
        sortPrinterMachineIMP.inDigit(3);
        sortPrinterMachineIMP.inDigit(6);
        sortPrinterMachineIMP.inDigit(9);

        sortPrinterMachineIMP.inSortType(1);
        sortPrinterMachineIMP.sortMachineRun();

        sortPrinterMachineIMP.sortMachineShow();
        sortPrinterMachineIMP.clearList();
        sortPrinterMachineIMP.sortMachineShow();

        sortPrinterMachineIMP.inDigit(5);
        sortPrinterMachineIMP.inDigit(2);
        sortPrinterMachineIMP.inDigit(3);
        sortPrinterMachineIMP.inDigit(6);
        sortPrinterMachineIMP.inDigit(9);
        sortPrinterMachineIMP.inSortType(2);
        sortPrinterMachineIMP.sortMachineRun();

        sortPrinterMachineIMP.sortMachineShow();
    }
}


interface SortPrinterMachineIP
{
    public void inDigit(int inputDigit);
    public void inSortType(int inputSortType);
    public void sortMachineRun();
    public void sortMachineShow();
    public void clearList();
}

interface SortMachineIP
{
    public void bubbleSort(ArrayList<Integer> lst);
    public void selectionSort(ArrayList<Integer> lst);
}

class SortMachineIMP implements SortMachineIP
{
    @Override
    public void bubbleSort(ArrayList<Integer> lst){
        for(int cycle = 0 ;cycle < lst.size(); cycle ++) {
            for(int i = 0 ; i < lst.size() - 1 - cycle; i ++) {
                if(lst.get(i) > lst.get(i + 1)){
                    //swap
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(i + 1));
                    lst.set(i + 1, tmp);
                }
            }
        }
    }
    @Override
    public void selectionSort(ArrayList<Integer> lst) {
        for(int i = 0 ; i < lst.size(); i++) {
            for(int j = i + 1 ; j < lst.size(); j ++) {
                if(lst.get(i) > lst.get(j)){
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(j));
                    lst.set(j, tmp);
                }
            }
        }
    }
}

class SortPrinterMachineIMP implements SortPrinterMachineIP
{
    public SortMachineIP sortMachineIP = new SortMachineIMP();
    private ArrayList<Integer> digitList = new ArrayList<Integer>();
    private int sortType; //1은 버블 2는 셀렉트
    @Override
    public void inDigit(int inputDigit)
    {
        digitList.add(inputDigit);
    }
    @Override
    public void inSortType(int inputSortType)
    {
        sortType = inputSortType;
    }
    @Override
    public void sortMachineRun()
    {
        if(sortType == 1)
        {
            sortMachineIP.bubbleSort(digitList);
        }
        else if(sortType == 2)
        {
            sortMachineIP.selectionSort(digitList);
        }
    }
    @Override
    public void sortMachineShow()
    {
        System.out.println(digitList.toString());
    }
    @Override
    public void clearList()
    {
        digitList.clear();
    }
}