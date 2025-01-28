package Week1DisjointSets.ProblemC;

public class ColorPicker {
    private int numStudent; //K
    private int rows; //N
    private int columns; //M
    private int[] columnRepresentative;
    private int[] studentParent;
    private int[] size;
    private int colors;
// 65-90
    public ColorPicker(int N, int M, int K){
        this.rows = N;
        this.columns = M;
        this.numStudent = K;
        this.columnRepresentative = new int[M];
        this.studentParent = new int[K];
        this.size = new int[K];
        for (int i = 0; i < K; i++) {
            this.studentParent[i] = i;
            this.size[i] = 1;
        }
        this.colors = K;
    }
    public ColorPicker(String input) {
        String[] in = input.split(" ");
        this.rows = Integer.parseInt(in[0]);
        this.columns = Integer.parseInt(in[1]);
        this.numStudent = Integer.parseInt(in[2]);
        this.columnRepresentative = new int[this.columns];
        this.studentParent = new int[this.numStudent];
        for (int i = 0; i < this.numStudent; i++) {
            this.studentParent[i] = i;
        }
    }

    public void addRow(String input, int currRow) {
        if (currRow == 0) {
            for (int j = 0; j < this.columns; j++) {
                columnRepresentative[j] = input.charAt(j)-65;
            }
        } else {
            for (int j = 0; j < this.columns; j++) {
                int student = input.charAt(j)-65;
                if (find(student) == find(columnRepresentative[j])) {
                    continue;
                } else {
                    int root1 = find(student);
                    int root2 = find(columnRepresentative[j]);
                    if (root1 < root2) {
                        studentParent[root2] = root1;
                        size[root1] += size[root2];
                    } else {
                        studentParent[root1] = root2;
                        size[root2] += size[root1];
                    }
                    colors--;
                }

            }
        }
    }

    public int find(int p) {
        if (studentParent[p] == p) {
            return p;
        }
        studentParent[p] = studentParent[studentParent[p]];
        return find(studentParent[p]);
    }

    public int maxDiffColors() {
        return colors;
    }
}
