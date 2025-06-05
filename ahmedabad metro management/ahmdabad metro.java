import java.time.LocalTime;
import java.util.*;
class metro_vending_machine {
    Scanner sc=new Scanner(System.in);
    int index1,index2;
    double basePrice,totalPrice;
    String startStation,endStation;

    //array which stores station of ahmedabad metro.
    String[] metro1={"VASTRAL_GAM","NIRANT_CROSS_ROAD","VASTRAL","RABARI_COLONY","AMARAI_VADI","APERAL_PARK","KAKARIYA_EAST","KALUPUR","GHEE_KANTA","SHAHPUR","OLD_HIGHCOURT","S_P_STADIUM","COMMERCE_SIX_ROAD","GUJARAT_UNIVERCITY","GURUKUL_ROAD","DURDARSHAN_CENTER","THALTEJ","THALTEJ_GAM"};
    String[] metro2={"APMC","JIVRAJ","RAJIVNAGAR","SHREYAS","PALADI","GANDHIGRAM","OLD_HIGHCOURT","USMANPURA","VIJAYNAGAR","VADAJ","RANIP","SABARMATI_RAILWAY_STATION","AEC","SABARMATI","MOTERA_STADIUM"};

    void setData(String s1,String s2) {
        startStation=s1;
        endStation=s2;
    }

    //mothod to print whole ahmedabad metro route
    void wholeroute() {
    System.out.println("===============================================================================================================================================================================");
    System.out.println("                                                                           Ahmedabad Metro Route                                         ");
    System.out.println("===============================================================================================================================================================================");
    System.out.println("                                                                                                                                        (> section 3 <)");
    System.out.println("                                                                                                  |----gandhigram----paladi----shreyas----rajivnagar----jivrajpark----APMC---->");
    System.out.println("                          (> section 2 <)                                                         |                                                                          ");
    System.out.println("<----thaltej gam===thaltej===durdarshan centar===gurukul road===commerce six road===SP stedium===(@)===shahpur===ghee kanta===kalupur===kakariya east===aperal park===ameraivadi");
    System.out.println("                                                                                           (old highcourt)                         (> section 4 <)                            |");
    System.out.println("                                                                                                  |                                                                           | ");
    System.out.println("                                                                                                  |               <----vastral gam===nirant cross road===vastral===rabari colony");
    System.out.println("                 AEC----sabarmati railway station----ranip----vadaj----vijaynagar----usmanpura----|                                           ");
    System.out.println("                   |                 (> section 1 <)");
    System.out.println("                   |");
    System.out.println("                   |----sabarmati----motera stedium---->");
    System.out.println("=================================================================================================================================================================================");
    }

    //method to print section wise stations 
    void section(int i) {
        switch (i) {
            case 1:    //section 1
            System.out.println("===============================");
            System.out.println("        : section 1 :");
            System.out.println("===============================");
            System.out.println("1. <--usmanpura--> \n2. <--vijaynagar--> \n3. <--vadaj--> \n4. <--ranip--> \n5. <--sabarmati railway station--> \n6. <--AEC--> \n7. <--sabarmati--> \n8. <--motera stadium-->");
            System.out.println("==============================="); 
            System.out.println(); 
            break;
            case 2:    //section 2
            System.out.println("===============================");
            System.out.println("         : section 2 :");
            System.out.println("===============================");
            System.out.println("1. <--S P stedium--> \n2. <--commerce six road--> \n3. <--gujarat univercity--> \n4. <--gurukul road--> \n5. <--durdarshan center--> \n6. <--thaltej--> \n7. <--thaltej gam-->");
            System.out.println("===============================");
            System.out.println(); 
            break;
            case 3:    //section 3
            System.out.println("===============================");
            System.out.println("         : section 3 :");
            System.out.println("===============================");
            System.out.println("1. <--gandhigram--> \n2. <--paladi--> \n3. <--shreyas--> \n4. <--rajivnagar--> \n5. <--jivraj--> \n6. <--A P M C-->");
            System.out.println("===============================");
            System.out.println();
            break;
            case 4:    //section 4
            System.out.println("===============================");
            System.out.println("         : section 4 :");
            System.out.println("===============================");
            System.out.println("1. <--shahpur--> \n2. <--gee kanta--> \n3. <--kalupur--> \n4. <--kankariya east--> \n5. <--aperal park--> \n6. <--amarai vadi--> \n7. <--rabari colony--> \n8. <--vastral--> \n9. <--nirant cross road--> \n10. <--vastral gam-->");
            System.out.println("===============================");
            System.out.println();          
            break;
            default:
            System.out.println("invalid choice.");
            break;
        }
    }

    //method to find distance between 2 stations
    int getDistance( String[] metro,String s1,String s2) {
        int startingIndex=findIndex(metro, s1);
        int endingIndex=findIndex(metro, s2);

        if(startingIndex!=-1 && endingIndex!=-1){
            return Math.abs(endingIndex-startingIndex);
        }
        else {
            return -1;
        }
    }

    //method to find index of station in array
    int findIndex(String[] metro,String s1) { //s1 for station

        for(int i=0;i<metro.length;i++) {
            if(metro[i].equals(s1)) {
                return i;
            }
        }
        return -1;
    }

    int interchange;
    //method to check interchange is needed or not.
    void isInterchangeNeeded() {

        boolean startInMetro1=isInArray(metro1, startStation);
        boolean endInMetro1=isInArray(metro1, endStation);
        boolean startInMetro2=isInArray(metro2, startStation);
        boolean endInMetro2=isInArray(metro2, endStation);

        //if true interchange is nedded.
        if((startInMetro1==true)&&(endInMetro1==true)) {
            interchange=1;
        }
        else if((startInMetro2==true)&&(endInMetro2==true)) {
            interchange=2;
        }
        else if((startInMetro1==true)&&(endInMetro2==true)) {
            interchange=3;
        }
        else {
            interchange=4;
        }
    }
    boolean b5;
    Boolean isInArray(String[] metro4,String st) {
        for(String s:metro4) {
            if(s.equalsIgnoreCase(st)) {
                return true; 
            }
        }
        return false;
    }

    int distance;
    //method to find price of ticket token
    void finalDistance(int d1,int d2) {       
        //d1 for distance1 & d2 for distance2.

        isInterchangeNeeded();
        // to find exact distance user will have to cover.
        switch (interchange) {
            case 1:
                distance=d1;
                break;
            case 2:
                distance=d2;
                break;
            case 3:
                int distanceOnMetro1 = getDistance(metro1, startStation, "OLD_HIGHCOURT");
                int distanceOnMetro2 = getDistance(metro2, "OLD_HIGHCOURT", endStation);
                distance=  distanceOnMetro1 + distanceOnMetro2 ;
                break;
            case 4:
                int distanceOnMetro3 = getDistance(metro2, startStation, "OLD_HIGHCOURT");
                int distanceOnMetro4 = getDistance(metro1, "OLD_HIGHCOURT", endStation);
                distance= distanceOnMetro3 + distanceOnMetro4 ;
                break;
            default:

            break;
        }
    }

    void findPrice(boolean b1) {
        int distance1=getDistance(metro1, startStation, endStation);
        int distance2=getDistance(metro2, startStation, endStation);
        finalDistance(distance1,distance2);
        // pricing according to distance.
        if(distance<=4) {
            basePrice=5;
        }
        else if(distance<=8) {
            basePrice=10;
        }
        else if(distance<=12) {
            basePrice=15;
        }
        else if(distance<=16) {
            basePrice=20;
        }
        else {
            basePrice=25;
        }

        if(b1==true) {
            totalPrice=basePrice-((basePrice*10)/100);
        }
        else {
            totalPrice=basePrice;
        }
    }

    void display() {
        System.out.println();
        System.out.println("starting station is "+startStation+".");
        System.out.println("ending station is "+endStation+".");
        System.out.println();
        System.out.println("price of your ticket will be "+totalPrice+" from "+startStation+" to "+endStation);
    }

    void getTocken(String s1, String s2, int paymentType) {
        findPrice(false);
        display();
        if(paymentType==1) {
            System.out.println();
            System.out.println("enter note in machine.");
            System.out.println();
        }
        else {
            System.out.println();
            System.out.println("swap your card in machine.");
            System.out.println("enter your card details and payable amount.");
            System.out.println();
        }
        System.out.println("your ticket is confirmed.");
        System.out.println("Take tocken from machine.");
        System.out.println("It will be valide for 120 minutes.");
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) { 
        Scanner sc=new Scanner(System.in);
        metro_vending_machine j1=new metro_vending_machine();
        System.out.println();
        System.out.println("<-------welcome to our system------->");
        boolean b=true;
        while(b) {
            // for enter user's choice.
        System.out.println();
        System.out.println(" 1) To see whole route of ahmedabad metro press 1.");
        System.out.println(" 2) To see all stations of perticular section press 2.");
        System.out.println(" 3) To find price of ticket between two station press 3.");
        System.out.println(" 4) To get travellin tocken press 4.");
        System.out.println(" 5) To exit the program you can press 5.");
        System.out.println();
        System.out.print("enter your choice: ");
        int n=sc.nextInt();
        System.out.println();
        switch(n) {
            case 1:
                j1.wholeroute();
            break;
            case 2:
            System.out.println();
                System.out.println("<------station list------>");
                System.out.println();
                System.out.println("1. Old Highcourt->>>>-motera stedium");
                System.out.println("2. Old Highcourt->>>>-Thaltej Gam");
                System.out.println("3. Old Highcourt->>>>-A P M C");
                System.out.println("4. Old Highcourt->>>>-Vastral Gam");
                System.out.println();
                System.out.println("enter section number: ");
                int a=sc.nextInt();
                j1.section(a);
            break;
            case 3:
                System.out.print("enter starting station: ");
                String s1=sc.next().trim().toUpperCase();
                System.out.print("enter ending station: ");
                String s2=sc.next().trim().toUpperCase();

                //for validate input stations
                boolean station1FoundInMetro1 = j1.isInArray(j1.metro1, s1);
                boolean station1FoundInMetro2 = j1.isInArray(j1.metro2, s1);
                boolean station2FoundInMetro1 = j1.isInArray(j1.metro1, s2);
                boolean station2FoundInMetro2 = j1.isInArray(j1.metro2, s2);

                if((station1FoundInMetro1 || station1FoundInMetro2) && (station2FoundInMetro1 || station2FoundInMetro2)) {
                    System.out.print("will you metro use card ? 'yes' or 'no': ");
                    String s3=sc.next().trim().toLowerCase();
                    boolean useCard;
                    if(s3.equals("yes")) {
                        useCard=true;
                        j1.setData(s1, s2);
                        j1.findPrice(useCard);
                        j1.display();
                    }
                    else if(s3.equals("no")) {
                        useCard=false;
                        j1.setData(s1, s2);
                        j1.findPrice(useCard); 
                        j1.display();
                    }
                    else {
                        System.out.println("invalid input.");
                    }
                }
                else {
                    System.out.println(" one or both station not found.");
                }
            break;
            case 4:
                System.out.println("enter starting station: ");
                String st1=sc.next().trim().toUpperCase();
                System.out.print("enter ending station: ");
                String st2=sc.next().trim().toUpperCase();

                boolean Station1FoundInMetro1 = j1.isInArray(j1.metro1, st1);
                boolean Station1FoundInMetro2 = j1.isInArray(j1.metro2, st1);
                boolean Station2FoundInMetro1 = j1.isInArray(j1.metro1, st2);
                boolean Station2FoundInMetro2 = j1.isInArray(j1.metro2, st2);

                if((Station1FoundInMetro1 || Station1FoundInMetro2) && (Station2FoundInMetro1 || Station2FoundInMetro2)) {
                    System.out.println("would you like to pay with : ");
                    System.out.println("1. cash");
                    System.out.println("2. payment card");
                    int paymentType=sc.nextInt();
                    j1.setData(st1, st2);
                    j1.getTocken(st1, st2,paymentType);
                }
                else {
                    System.out.println("one or both station not found.");
                }
            break;
            case 5:
                b=false;
            break;
            default:
                System.out.println("invalid input. \ntry again.");
            break;
        }
        }
    }
}