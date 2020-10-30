package part3.ex2.InstanceMethod;



import java.util.Scanner;

public class ExamList {

    //외부변수의 변경으로 인해 파일이 에러가 나는것을 방지 => capsulation
    //파라미터 전달이 아닌, 인스턴스를 통해 호춣을해야 편하다
    //인스턴스를 사용해야 속성,값 등을 이용하여 행동 지시
    // ex . list.inputList() (o) ExamList.inputLisy(list) (x)
    // list 야 list input 해
    // static method vs instance method
    /*
    public static void inputList(ExamList list){
    list.exams[list.current] = new Exam();
    }
    vs
    public void inputList(){
    //여기선 받을 parameter 가 없기에 묵시적으로 this 로 받는다.
    this.exams[this.current] = new Exam();
    }


     */
    Exam[] exams;
    private int current;


    void printList() {
        this.printList(this.current);
    }

    void printList(int size) {
        //static method
        System.out.println("성적출력이");

        Exam[] exams = this.exams;

        for (int i = 0; i < size; i++) {
            Exam exam = exams[i];
            int kor = exam.kor;
            int eng = exam.eng;
            int math = exam.math;

            int total = kor + eng + math;
            float avg = total / 3.0f;


            System.out.printf("kor : %d | eng : %d | math : %d \n", kor, eng, math);
            System.out.printf("total : %d | avg : %6.2f\n", total, avg);
        }
    }


        void inputList () {
            //instance method 방법 with this
            Scanner scan = new Scanner(System.in);
            System.out.println("성적을 입력해주시기 바랍니다.");
            int kor, eng, math;

            do {
                System.out.printf("Kor :");
                kor = scan.nextInt();

                if (kor < 0 || 100 < kor)
                    System.out.printf("kor is worng");

            } while (kor < 0 || 100 < kor);

            do {
                System.out.printf("eng : ");
                eng = scan.nextInt();
                if (eng < 0 || eng < 100)
                    System.out.printf("eng : wrong");
            } while (eng < 0 || 100 < eng);


            do {
                System.out.printf("math : ");
                math = scan.nextInt();
                if (math < 0 || math < 100)
                    System.out.printf("math : wrong");
            } while (math < 0 || 100 < math);


            Exam exam = new Exam();
            exam.kor = kor;
            exam.eng = eng;
            exam.math = math;

            Exam[] exams = this.exams;
            int size = this.current;

            if (exams.length == size) {
                //  1.크기가 5개 정도 더 큰 새로운
                Exam[] temp = new Exam[size + 5];
                //2. 값을 이주시키기
                for (int i = 0; i < size; i++)
                    temp[i] = exams[i];
                //3.list.exmas가 새로만든 temp
                this.exams = temp;
            }

            this.exams[this.current] = exam;
            this.current++;
        }

        static int inputMenu(){
         int k =0;
         return k;
        }




        public void init () {

            this.exams = new Exam[3];
            this.current = 0;
        }
    }

