package com.techelevator;

public class KataPotter {
    private double price;
    private int count;
    double[] setCost = {0,8,15.2,21.6,25.6,30};


    public double getCost(int[] books) {
        int[] sets = new int[5];
        for (int i = 0; i < books.length; i++) {
            if (books[i] > 0) {
                while (books[i] > 0) {
                    sets[count]++;
                    books[i]--;
                    count++;
                }
                count = 0;
            }
        }

        int book1 = 0;
        int book2 = 0;
        int book3 = 0;
        int book4 = 0;
        int book5 = 0;

      for (int i : books) {
          if(i==0){
              book1++;
          }
          if(i==1){
              book2++;
          } if(i==2){
              book3++;
          } if(i==3){
              book4++;
          } if(i==4){
              book5++;
          }
      }
      int[] bookCart = {book1, book2, book3, book4, book5};

    private double exception(int[] bookSets) {
        for (int i = 0; i < bookSets.length; i++) {
            for (int j = 0; j < bookSets.length; j++) {
                if (bookSets[i] == 5 && bookSets[j] == 3) {
                    price += 4 * 8 * 0.8 + 4 * 8 * 0.8;
                    bookSets[i] = 0;
                    bookSets[j]=0;
                }
            }
        }
        return price;
    }
//Really got stuck, will be returning to this :/
}
