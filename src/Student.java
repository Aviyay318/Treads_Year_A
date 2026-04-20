public class Student {
    private String name;
    private int[] grades;
    private  int amountOfGrades;


    public Student(String name, int size){
        this.name =name;
        this.grades = new int[size];
        this.amountOfGrades = 0;
    }

    //avg:

    public synchronized double getAvg(){
        double avg = 0;
        int sum  = 0;
        for (int i = 0; i < this.amountOfGrades; i++) {
           sum+=this.grades[i];
        }
      if (this.amountOfGrades>0){
          avg =  (double) sum / this.amountOfGrades;
      }
      return avg;
    }

    //max:

    public synchronized int getMax(){
        int max = 0;
        for (int i = 0; i < this.amountOfGrades; i++) {
            if (this.grades[i] > max){
                max = this.grades[i];
            }
        }
        return max;
    }

    //add grades:

    public synchronized boolean addGrades(int grade){
        boolean isAdd = false;
        if (this.amountOfGrades<this.grades.length){
            this.grades[this.amountOfGrades] =  grade;
            this.amountOfGrades++;
            isAdd = true;
        }
        return isAdd;
    }
    //remove grade :
   public synchronized boolean removeFirstGrade(){
        boolean isRemove = false;
        if (this.amountOfGrades>0){
            for (int i = 0; i < this.amountOfGrades-1; i++) {
               this.grades[i] = this.grades[i+1];
            }
            this.amountOfGrades--;
            this.grades[this.amountOfGrades] = 0;
           isRemove = true;
        }
       return isRemove;
   }

}
