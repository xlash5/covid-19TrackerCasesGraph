package sample;



import javafx.scene.layout.VBox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;

import javafx.stage.Stage;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class Main extends Application {
    Continent asia= new Continent("Asia"),europe= new Continent("Europe"),africa = new Continent("Africa"), america= new Continent("America"),oceania = new Continent("Oceania");

    @Override
    public void start(Stage primaryStage) throws Exception{
        Networking networking = new Networking();
        networking.getData();

        try
        {


            File file = new File(System.getProperty("user.dir")+"\\data.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("record");

            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);

                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;

                    String popData = eElement.getElementsByTagName("popData2018").item(0).getTextContent();
                    String countriesAndTerritories = eElement.getElementsByTagName("countriesAndTerritories").item(0).getTextContent();
                    String cases = eElement.getElementsByTagName("cases").item(0).getTextContent();
                    String deaths = eElement.getElementsByTagName("deaths").item(0).getTextContent();
                    String dateRep = eElement.getElementsByTagName("dateRep").item(0).getTextContent();

                    if(eElement.getElementsByTagName("continentExp").item(0).getTextContent().equals("Asia")){
                        if (popData.equals("")){
                            popData = "0";
                        }
                        asia.addData(popData, countriesAndTerritories,cases, deaths,dateRep);
                    }else if(eElement.getElementsByTagName("continentExp").item(0).getTextContent().equals("Europe")){
                        if (popData.equals("")){
                            popData = "0";
                        }
                        europe.addData(popData, countriesAndTerritories,cases, deaths,dateRep);
                    }else if(eElement.getElementsByTagName("continentExp").item(0).getTextContent().equals("Africa")){
                        if (popData.equals("")){
                            popData = "0";
                        }
                        africa.addData(popData, countriesAndTerritories,cases, deaths,dateRep);
                    }else if(eElement.getElementsByTagName("continentExp").item(0).getTextContent().equals("America")){
                        if (popData.equals("")){
                            popData = "0";
                        }
                        america.addData(popData, countriesAndTerritories,cases, deaths,dateRep);
                    }else if(eElement.getElementsByTagName("continentExp").item(0).getTextContent().equals("Oceania")){
                        if (popData.equals("")){
                            popData = "0";
                        }
                        oceania.addData(popData, countriesAndTerritories,cases, deaths,dateRep);
                    }

                }

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }








        primaryStage.setTitle("StackedBarChart");

        CategoryAxis xAxis    = new CategoryAxis();
        xAxis.setLabel("Dates");
        xAxis.getCategories().addAll("Asia", "Europe", "Africa", "Oceania", "America");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Cases");

        StackedBarChart     stackedBarChart = new StackedBarChart(xAxis, yAxis);
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Asia");
        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("Europe");
        XYChart.Series dataSeries3 = new XYChart.Series();
        dataSeries3.setName("Africa");
        XYChart.Series dataSeries4 = new XYChart.Series();
        dataSeries4.setName("Oceania");
        XYChart.Series dataSeries5 = new XYChart.Series();
        dataSeries5.setName("America");
        for(int i = 0; i < asia.continentDailyCase.size();i++){

            dataSeries1.getData().add(new XYChart.Data<String, Number>(asia.continentDailyCase.get(i).dateRep, Integer.parseInt(asia.continentDailyCase.get(i).cases)));

        }
        for(int i = 0; i < europe.continentDailyCase.size();i++){

            dataSeries2.getData().add(new XYChart.Data<String, Number>(europe.continentDailyCase.get(i).dateRep, Integer.parseInt(europe.continentDailyCase.get(i).cases)));

        }
        for(int i = 0; i < africa.continentDailyCase.size();i++){

            dataSeries3.getData().add(new XYChart.Data<String, Number>(africa.continentDailyCase.get(i).dateRep, Integer.parseInt(africa.continentDailyCase.get(i).cases)));

        }
        for(int i = 0; i < oceania.continentDailyCase.size();i++){

            dataSeries4.getData().add(new XYChart.Data<String, Number>(oceania.continentDailyCase.get(i).dateRep, Integer.parseInt(oceania.continentDailyCase.get(i).cases)));

        }
        for(int i = 0; i < america.continentDailyCase.size();i++){

            dataSeries5.getData().add(new XYChart.Data<String, Number>(america.continentDailyCase.get(i).dateRep, Integer.parseInt(america.continentDailyCase.get(i).cases)));

        }
        stackedBarChart.getData().addAll(dataSeries1,dataSeries2,dataSeries3,dataSeries4,dataSeries5);




        VBox vbox = new VBox(stackedBarChart);

        Scene scene = new Scene(vbox, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(1200);

        primaryStage.show();


    }


    public void parseXML(){

    }

    public static void main(String[] args) {
        launch(args);
    }
}
