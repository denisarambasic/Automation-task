# Automatizacija Zadatak
## Preduvjeti
Da bi mogli skinuti i odvrtiti testove na Vašem racunalo potrebno je imati instalirane 2 stvari:  
      **1. JAVA JDK**  
          - Možete provjeriti da li imate instaliranu Javu sljedecom naredbom u vašoj konzoli:  
             > javac -version  
             Ukoliko dobijete ispis java compiler verzije netrebate instalirati JDK, u suprotnome link za instlaciju JDK-a za windows je [ovdje](https://devwithus.com/install-java-windows-10/).  
      **1. Maven**  
          - Možete provjeriti da li imate instaliran Maven na racunalu sljedecom naredbom u vašoj konzoli:  
          > mvn -version  
          Ukoliko dobijete ispis neke Apache Maven verzije znaci da je instaliran, u suprotnome link za instlaciju Maven-a za windows je [ovdje](https://mkyong.com/maven/how-to-install-maven-in-windows).  
          
## Preuzimanje zadatka  
Jedan od jednostavnijih nacina za preuzimanje zadatka je da na ovoj github stranici projekta kliknete na zeleni botun "Code" otvorit ce vam se sekcija sa nekoliko opcija za skidanje, najjednostavniji nacin je samo kopirati taj predloženi url: https://github.com/denisarambasic/Automation-task.git  
Zatim na svom racunalu otvorite konzolu na mjestu gdje želite dodati projekt i u konzolu upišete:  > git clone "taj url"  

## Pokretanje zadatka (Automatizacije)  
Udite u projektni folder te iz istoga otvorite konzolu.  
Kao što je u zadatku traženo možemo test pokrenuti na 2 nacina:  
    **1. Chrome browseru**  
        - u konzolu upišite sljedecu naredbu:  
        > mvn clean install  
        Nakon što test završi izgenerirat ce Vam se "report.txt" fajl koji sadrži sve stavke tražene u zadatku.  
        Imamo i bolju opciju reporta koju nam nudi cucumber, koju takoder možete vidjeti u target/HtmlReports/report.html (Ovaj fajl otvorite u browseru te cete dobiti još više         informacija o samom Test case-u).  
    **2. Headless modu**  
        - u konzolu upišite sljedecu naredbu:  
        > mvn -DheadlessMode=true clean install  
        Nakon što test završi izgenerirat ce Vam se "report.txt" fajl koji sadrži sve stavke tražene u zadatku.  
        Imamo i bolju opciju reporta koju nam nudi cucumber, koju takoder možete vidjeti u target/HtmlReports/report.html (Ovaj fajl otvorite u browseru te cete dobiti još više         informacija o samom Test case-u).
        
## Reproduciranje greške  
- Možemo reproducirati npr. grešku da promijenimo expected result da stavimo neki drugi datum. Otvorimo u notepadu sljedeci fajl src/test/resources/Features/Search.feature  
- i sada u stupcu expectedTimestamp umijesto "22:33, 24. travnja 2020." možemo staviti nešto drugo npr. "23:33, 24. travnja 2020." spremimo to.
- pokrenemo testove u konzolu kao što je to navedeno gore sa maven naredbom u konzoli(samo obratite pozornost da se nalazite u root folderu projekta), te možemo vidjeti ovaj    cucumber report u target/HtmlReports/report.html
- Ovdje ce se lipo vidjeti u kojem koraku ja test pao, i moci cete otvoriti screenshoot trenutnog stanja ekrana u kojem je test pao.
    

          
