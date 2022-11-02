

public class Stack{
    // array to store actual items in the stack
    // it may be partially full
    private int[] items;
    // to keep track of how many actual items are
    // in the array
    private int numItems;


    public Stack(){
        this.items = new int[10];
        this.numItems = 0;
    }

    public boolean isEmpty(){
        return this.numItems == 0;
    }

    public int size(){
        return this.numItems;
    }


    public int peek(){
        // do some simple error checking
        // if there is nothing to look at
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("The stack is empty!");
        }
        // return last item in the array
        return this.items[this.numItems - 1];
    }


    public int pop(){
        // get the last item
        int last = this.peek();
        // decrease the item count
        this.numItems--;
        // zero out the spot
        this.items[this.numItems] = 0;
        // return the popped item
        return last;
    }


    public void push(int number){
        // is there room?
        if(this.numItems < this.items.length){
            this.items[this.numItems] = number;
            this.numItems++;
        }else{
            // make a new array twice as big
            int[] temp = new int[this.numItems*2];
            // copy array across
            for(int i = 0; i < this.numItems; i++){
                temp[i] = this.items[i];
            }
            // items is the new array
            this.items = temp;
            this.items[this.numItems] = number;
            this.numItems++;
        }
    }




    public static void main(String[] args) {
        Stack myNumbers = new Stack();
        myNumbers.push(7);
        myNumbers.push(-2);

        System.out.println(myNumbers.peek());
        System.out.println(myNumbers.size());

        System.out.println(myNumbers.pop());
        System.out.println(myNumbers.size());
        System.out.println(myNumbers.peek());

        myNumbers.pop();
        myNumbers.peek();
    }
}