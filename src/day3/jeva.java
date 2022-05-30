package day3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class A_list {
    private String name;
    private double rate;

    private Long limitMoney;

    public Long getLimitMoney() {
        return limitMoney;
    }
    public void setLimitMoney(Long limitMoney) {
        this.limitMoney = limitMoney;
    }

    public A_list() {

    }
	public A_list (String name, double rate,Long limitMoney) {
		this.name = name;
		this.rate = rate;
        this.limitMoney = limitMoney;
	}

    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static void List(){
        String bank1 = "제일은행";
        double sc = 3.41;
        //  String SC = String.valueOf(sc);
        Long goldsc = 4000L;

        // 빈 리스트 생성
        List<A_list> bankList = new ArrayList<A_list>();

        // 은행 정보를 담은 객체 생성
        A_list bankSC = new A_list(bank1,sc,goldsc);
        bankList.add(bankSC);

        String bank2 = "삼성생명";
        double ss = 3.67;
        int goldss = 4000;
        //   String SS = String.valueOf(ss);

        List<Object> bankSS = new ArrayList<Object>();

        bankSS.add(bank2);
        bankSS.add(ss);
        bankSS.add(goldss);

        String bank3 = "한화생명";
        double han = 3.14;
        int goldhan = 6000;
        //     String HAN = String.valueOf(han);

        List<Object> bankHAN = new ArrayList<Object>();
        bankSS.add(bank3);
        bankSS.add(han);
        bankSS.add(goldhan);


        String bank4 = "고려저축은행";
        double go = 3.24;
        int goldgo = 6000;
        //       String GO = String.valueOf(go);
        List<Object> bankgo = new ArrayList<Object>();

        bankSS.add(bank4);
        bankSS.add(go);
        bankSS.add(goldgo);

        String bank5 = "우리은행";
        double woo = 2.41;
        int goldwoo = 8000;

        List<Object> bankwoo = new ArrayList<Object>();

        bankSS.add(bank5);
        bankSS.add(woo);
        bankSS.add(goldwoo);

//		String[] Bank = new String[]{bank1,bank2,bank3,bank4,bank5};
//		String[] Bank_list = new String[]{bank1+" "+sc+"%",bank2+" "+ss+"%",bank3+" "+han+"%",bank4+" "+go+"%",bank5+" "+woo+"%"};
//		Double[] Rate_list = new Double[]{sc,ss,han,go,woo};
        Object[] all = {bankSC,bankSS,bankHAN,bankgo,bankwoo};

        Stream<String>bankStream = Stream.<String>builder()
                .add(bank1).add(bank2).add(bank3).add(bank4).add(bank5).build();

        Stream<String>bank_listStream = Stream.<String>builder()
                .add(bank1+""+sc+"%").add(bank2+""+ss+"%").add(bank3+""+han+"%").add(bank4+""+go+"%").add(bank5+""+woo+"%").build();

        Stream<Double>rate_listStream = Stream.<Double>builder()
                .add(sc).add(ss).add(han).add(go).add(woo).build();

        Stream<Object>al = Stream.<Object>builder()
                .add(bankSC).add(bankSS).add(bankHAN).add(bankgo).add(bankwoo).build();
        List<A_list> sortList = bankList.stream().sorted(Comparator.comparing(A_list::getLimitMoney)).collect(Collectors.toList());
        List<A_list> sortList2 = bankList.stream().sorted(Comparator.comparing(A_list::getRate)).collect(Collectors.toList());


//		Stream<String>bank_list = Stream.of(Bank_list);
//		Stream<Double>rate_list = Stream.of(Rate_list);
//		Stream<Object>al = Stream.of(all);

//		Stream<String>bank = Stream.of(Bank);
//		Stream<String> bank_list = Arrays.stream(Bank_list);
//		Stream<Double> rate_list = Arrays.stream(Rate_list);
//		Stream<String> bank = Arrays.stream(Bank);
//		Stream<Object> al = Arrays.stream(all);

//		ArrayList<String> bank_list = new ArrayList<>(Arrays.asList(Bank_list));
//		ArrayList<Double> rate_list = new ArrayList<>(Arrays.asList(Rate_list));
//		ArrayList<String> bank = new ArrayList<>(Arrays.asList(Bank));
//		ArrayList<String>bank_list = new ArrayList<String>();
//		Stream<String> bank_list = Arrays.stream(Bank);
//		bank_list.forEach(System.out::println);
//		bank_list.sorted(Comparator.coBparing(String::);



//		Collections.sort(bank_list);



        System.out.println("현재 신청 가능 금융사");
        System.out.println("");

        bankStream.forEach(System.out::println);

//		System.out.println(Arrays.toString(Bank));

        System.out.println("");
        System.out.println("필요하신 금액을 적어주세요");
        System.out.println("");

        System.out.println("* 입력단위 : 만");
        System.out.println("");



        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        if(T>0) {
            System.out.println("");
            bank_listStream.forEach(System.out::println);
            System.out.println("");
            System.out.println("희망 대출기간을 써주세요 ");

            System.out.println("* 입력단위 : 1~35(년)");
            System.out.println("");

            int term = s.nextInt();

            System.out.println("");

            if(term>=1) {
                System.out.println("원하시는 금융사 결과 정렬방법을 써주세요");
                System.out.println("A : 금융사명순");
                System.out.println("B : 금리낮은순");
                System.out.println("C : 가능한도순");

                String Q = s.next();

                Q = Q.toUpperCase();

                if(Q.equals("A")) {

                }else if(Q.equals("B")) {

                }else {
                    System.out.println("잘못된값입니다.");
                    return ;
                }
            }else {
                System.out.println("잘못된값입니다");
                return ;
            }

        }else {
            System.out.println("잘못된값입니다");
            return ;
        }
//		Comparator<>bank_list;
    }
}

public class jeva extends A_list{

    public static void main(String[] args) {
        A_list v = new A_list();
        v.List();
    }
}