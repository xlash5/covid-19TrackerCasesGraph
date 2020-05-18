package sample;

import java.util.ArrayList;

public class Countries {

    String popData2018;
    String countriesAndTerritories;
    int totalCases;
    int totalDeaths;
    double mortality;
    double attackRate;
    int newCases;
    int newDeaths;

    ArrayList<Cases> countryDailyCase = new ArrayList<Cases>();
    public Countries(String popData2018, String countriesAndTerritories, String cases, String deaths, String date){
        this.countriesAndTerritories = countriesAndTerritories;
        this.popData2018 = popData2018;
        this.newCases = Integer.parseInt(cases);
        this.newDeaths = Integer.parseInt(deaths);
        addData(cases,deaths,date);

    }
    public void addData(String cases, String deaths, String date){
        countryDailyCase.add(new Cases(cases,deaths,date));
        update(cases,deaths);

    }
    public void update(String cases, String deaths){
        this.totalCases += Integer.parseInt(cases);
        this.totalDeaths += Integer.parseInt(deaths);
        if (this.totalCases != 0){
            this.mortality = (double) totalDeaths/totalCases;
        }else if (this.totalCases == 0){
            this.mortality = 0;
        }
        if (!this.popData2018.equals("0")){
            this.attackRate = (double) totalCases/Integer.parseInt(popData2018);
        }else if (this.popData2018.equals("0")){
            this.attackRate = 0;
        }
    }
}
