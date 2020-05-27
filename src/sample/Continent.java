package sample;

import java.util.ArrayList;

public class Continent {
    String continentExp;
    ArrayList<Countries> countries = new ArrayList<Countries>();
    ArrayList<Cases> continentDailyCase = new ArrayList<Cases>();
    boolean firstData = true;
    public Continent(String continentExp){
        this.continentExp = continentExp;
    }
    public void addData(String popData2018, String countriesAndTerritories, String cases, String deaths, String date){
        boolean doesExist = false;
        int index = 0;

        for (int i = 0; i < countries.size(); i++){

            if (countries.get(i).countriesAndTerritories.equals(countriesAndTerritories)){
                doesExist= true;
                index = i;
                break;
            }else {
                doesExist = false;

            }
        }

        if (doesExist){
            countries.get(index).addData(cases,deaths,date);
        }else{
            countries.add(new Countries(popData2018, countriesAndTerritories, cases,  deaths, date));
        }

        continentDailyCase.add(new Cases(cases,deaths,date));
    }
}
