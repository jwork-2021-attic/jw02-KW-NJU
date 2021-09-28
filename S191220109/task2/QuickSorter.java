package S191220109.task2;

public class QuickSorter implements Sorter {

    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        int pos = -1;
        for (int i = 0; i < a.length - 1; ++i) {
            pos = i;
            for (int j = i + 1; j < a.length; ++j) {
                if (a[j] < a[pos])
                    pos = j;
            }
            if (pos != i)
                swap(i, pos);
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}
