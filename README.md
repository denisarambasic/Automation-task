# Automatizacija Zadatak
## Preduvjeti
Da bi mogli skinuti i odvrtiti testove na Va�em racunalo potrebno je imati instalirane 2 stvari:  
      **1. JAVA JDK**  
          - Mo�ete provjeriti da li imate instaliranu Javu sljedecom naredbom u va�oj konzoli:  
             > javac -version  
             Ukoliko dobijete ispis java compiler verzije netrebate instalirati JDK, u suprotnome link za instlaciju JDK-a za windows je [ovdje](https://devwithus.com/install-java-windows-10/).  
      **1. Maven**  
          - Mo�ete provjeriti da li imate instaliran Maven na racunalu sljedecom naredbom u va�oj konzoli:  
          > mvn -version  
          Ukoliko dobijete ispis neke Apache Maven verzije znaci da je instaliran, u suprotnome link za instlaciju Maven-a za windows je [ovdje](https://mkyong.com/maven/how-to-install-maven-in-windows).  
          
## Preuzimanje zadatka  
Jedan od jednostavnijih nacina za preuzimanje zadatka je da na ovoj github stranici projekta kliknete na zeleni botun "Code" otvorit ce vam se sekcija sa nekoliko opcija za skidanje, najjednostavniji nacin je samo kopirati taj predlo�eni url: https://github.com/denisarambasic/Automation-task.git  
Zatim na svom racunalu otvorite konzolu na mjestu gdje �elite dodati projekt i u konzolu upi�ete:  > git clone "taj url"  

## Pokretanje zadatka (Automatizacije)  
Udite u projektni folder te iz istoga otvorite konzolu.  
Kao �to je u zadatku tra�eno mo�emo test pokrenuti na 2 nacina:  
    **1. Chrome browseru**  
        - u konzolu upi�ite sljedecu naredbu:  
        > mvn clean install  
        Nakon �to test zavr�i izgenerirat ce Vam se "report.txt" fajl koji sadr�i sve stavke tra�ene u zadatku.  
        Imamo i bolju opciju reporta koju nam nudi cucumber, koju takoder mo�ete vidjeti u target/HtmlReports/report.html (Ovaj fajl otvorite u browseru te cete dobiti jo� vi�e         informacija o samom Test case-u).  
    **2. Headless modu**  
        - u konzolu upi�ite sljedecu naredbu:  
        > mvn -DheadlessMode=true clean install  
        Nakon �to test zavr�i izgenerirat ce Vam se "report.txt" fajl koji sadr�i sve stavke tra�ene u zadatku.  
        Imamo i bolju opciju reporta koju nam nudi cucumber, koju takoder mo�ete vidjeti u target/HtmlReports/report.html (Ovaj fajl otvorite u browseru te cete dobiti jo� vi�e         informacija o samom Test case-u).
        
## Reproduciranje gre�ke  
- Mo�emo reproducirati npr. gre�ku da promijenimo expected result da stavimo neki drugi datum. Otvorimo u notepadu sljedeci fajl src/test/resources/Features/Search.feature  
- i sada u stupcu expectedTimestamp umijesto "22:33, 24. travnja 2020." mo�emo staviti ne�to drugo npr. "23:33, 24. travnja 2020." spremimo to.
- pokrenemo testove u konzolu kao �to je to navedeno gore sa maven naredbom u konzoli(samo obratite pozornost da se nalazite u root folderu projekta), te mo�emo vidjeti ovaj    cucumber report u target/HtmlReports/report.html
- Ovdje ce se lipo vidjeti u kojem koraku ja test pao, i moci cete otvoriti screenshoot trenutnog stanja ekrana u kojem je test pao.
    

          
