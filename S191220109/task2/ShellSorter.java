package S191220109.task2;

public class ShellSorter implements Sorter {

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
        int gap = a.length;
        while (true) {
            gap /= 2;
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < a.length; j += gap) {
                    int k = j - gap;
                    while (k >= 0 && a[k] > a[k + gap]) {
                        swap(k, k + gap);
                        k -= gap;
                    }
                }
            }
            if (gap == 1)
                break;
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}
