public class BlockSearch {
    public static void main(String[] args) {
        int[] arr = {16, 5, 9, 12, 21, 18,
                32, 23, 37, 26, 45, 34,
                50, 48, 61, 52, 73, 66};
        //创建三个块的对象
        Block b1 = new Block(21, 0, 5);
        Block b2 = new Block(45, 6, 11);
        Block b3 = new Block(73, 12, 17);
        //定义数组用来管理三个块的对象（索引表）
        Block[] blocks = {b1, b2, b3};
        //定义一个变量用来记录要查找的元素
        int number = 48;
        //调用方法，传递索引表，数组，要查找的元素
        int index = getIndex(blocks, arr, number);
        //打印一下
        System.out.println(index);
    }

    //利用分块查找的原理，查找number的索引
    private static int getIndex(Block[] blocks, int[] arr, int number) {
        //获取所在分块
        int blockIndex = findBlock(blocks, number);
        if (blockIndex == -1) {
            return -1;
        }
        int startIndex = blocks[blockIndex].getStartIndex();
        int endIndex = blocks[blockIndex].getEndIndex();
        int max = blocks[blockIndex].getMax();

        //遍历
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i]==number){
                return i;
            }
        }
        return -1;
    }

    static int findBlock(Block[] blocks, int number) {
        for (int i = 0; i < blocks.length; i++) {
            if (number <= blocks[i].getMax()) {
                return i;
            }
        }
        return -1;
    }

}

class Block {
    private int max;
    private int startIndex;
    private int endIndex;

    public Block() {
    }

    public Block(int max, int startIndex, int endIndex) {
        this.max = max;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
