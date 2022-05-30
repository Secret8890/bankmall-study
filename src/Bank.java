public class Bank {

    private String name; // 은행명

    private Double rate1; // 원리금 균등상환시 금리

    private Double rate2; // 만기일시상환시 금리

    private Long year; // 대출 희망년도

    private Long limitMoney; // 대출한도

    /**
     *  GETTER & SETTER
     * @return
     */

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate1() {
        return rate1;
    }

    public void setRate1(Double rate1) {
        this.rate1 = rate1;
    }

    public Double getRate2() {
        return rate2;
    }

    public void setRate2(Double rate2) {
        this.rate2 = rate2;
    }

    public Bank() {

    }

    public Bank(String name, Double rate1, Double rate2, Long year, Long limitMoney) {
        this.name = name;
        this.rate1 = rate1;
        this.rate2 = rate2;
        this.year = year;
        this.limitMoney = limitMoney;
    }


    public Long getLimitMoney() {
        return limitMoney;
    }

    public void setLimitMoney(Long limitMoney) {
        this.limitMoney = limitMoney;
    }

    private Double getCalcRate1(Long price) {
        Double rate = (price / (year * 12d)) + ((price * (rate1 / 100) / (year * 12)));
        return rate;
    }
    private Double getCalcRate2(Long price) {
        Double rate = (price * (rate2 / 100) * year / (year * 12));
        return rate;
    }
    public Long getRateResult(Long price) {
//		System.out.println(name + "의 "+ year + " 년 원리금 균등상환시 월 납입액은 : " + Math.round(getCalcRate1(price)));
//		System.out.println(name + "의 "+year+" 년 만기일시 상환시 월 납입액은 : " + Math.round(getCalcRate2(price)));
        return Math.round(getCalcRate1(price));
    }
    public String getRateResult1() {
//		System.out.println(name + "의 "+ year + " 년 원리금 균등상환시 월 납입액은 : " + Math.round(getCalcRate1(price)));
//		System.out.println(name + "의 "+year+" 년 만기일시 상환시 월 납입액은 : " + Math.round(getCalcRate2(price)));
        return String.format("%.2f", getCalcRate1(30000L));
    }
}
