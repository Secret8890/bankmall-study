import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public void callLoop(List<Bank> banks, String text) {
        System.out.println("--------------------" + text + "--------------------");
        for (Bank bank : banks) {
            String result = "이름 :" + bank.getName() + " 대출한도 : " + bank.getLimitMoney() + " 금리 1 : " + bank.getRate1() + " 월별납입액 : " + bank.getRateResult1();
            System.out.println(result);
        }
    }

    public Main() {
        Bank hana = new Bank("하나은행", 2.2d, 2.4d, 35L, 25000L);
        Bank kakao = new Bank("카카오뱅크", 2.3d, 3.3d, 35L, 35000L);
        Bank sc = new Bank("SC제일은행", 4.4d, 5.5d, 35L, 30000L);
        Bank daegu = new Bank("대구은행", 2.7d, 3.7d, 35L, 35000L);
        Bank saemaul = new Bank("새마을은행", 2.2d, 4.3d, 35L, 40000L);

        List<Bank> bankList = new ArrayList<Bank>();

        bankList.add(hana);
        bankList.add(kakao);
        bankList.add(sc);
        bankList.add(daegu);
        bankList.add(saemaul);
        // 이름별로 정렬
        List<Bank> nameOrderList = bankList.stream().sorted(Comparator.comparing(Bank::getName)).collect(Collectors.toList());
        callLoop(nameOrderList, "이름별 정렬");
        // 월별 납입액별로 정렬 (납입액이 같을경우 더많은 한도)
        List<Bank> monthOrderList = bankList.stream().sorted(Comparator.comparing(Bank::getRateResult1).thenComparing(Comparator.comparing(Bank::getLimitMoney).reversed())).collect(Collectors.toList());
        callLoop(monthOrderList, "월별납입액 별 정렬");
        // 대출 한도별로 정렬 (한도가 같을경우 더낮은금리)
        List<Bank> limitMoneyOrderList = bankList.stream().sorted(Comparator.comparing(Bank::getLimitMoney).reversed().thenComparing(Bank::getRate1)).collect(Collectors.toList());
        callLoop(limitMoneyOrderList, "대출 한도별 정렬");
        // 금리별로 정렬 (금리가 같을경우 더많은 한도)
        List<Bank> rateOrderList = bankList.stream().sorted(Comparator.comparing(Bank::getRate1).thenComparing(Comparator.comparing(Bank::getLimitMoney).reversed())).collect(Collectors.toList());
        callLoop(rateOrderList, "금리별 정렬");

    }

    public static void main(String[] args) {
        Main main = new Main();

    }
}
