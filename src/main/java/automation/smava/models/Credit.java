package automation.smava.models;

import static automation.smava.pages.landing.LandingPage.*;

public class Credit {

    public CreditType getCreditType() {
        return creditType;
    }

    public void setCreditType(CreditType creditType) {
        this.creditType = creditType;
    }

    public Integer getOnAmount() {
        return onAmount;
    }

    public void setOnAmount(Integer onAmount) {
        this.onAmount = onAmount;
    }

    public Integer getForMonths() {
        return forMonths;
    }

    public void setForMonths(Integer forMonths) {
        this.forMonths = forMonths;
    }

    public Credit creditType(CreditType creditType){
        this.creditType = creditType;
        return this;
    }

    public Credit onAmount(Integer amount){
        this.onAmount = amount;
        return this;
    }

    public Credit forMonths(Integer period){
        this.forMonths = period;
        return this;
    }

    private CreditType creditType;
    private Integer onAmount;
    private Integer forMonths;


}
