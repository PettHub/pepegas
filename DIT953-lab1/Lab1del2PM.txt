=== Laboration 1, del 2/2 ===

Läs labbkriterierna längst ner på sidan innan ni fortsätter!

I denna laborationsuppgift är tanken att ni ska fortsätta på den lösning ni
gjort i del 1. Ni ska lära er jobba med extensibilitet och polymorfism,
och 

Se till att noga läsa igenom instruktionerna och att följa de regler och krav
som labbdokumentet föreskriver. Börja med att kolla igenom hela labbdokumentet
och se vad som krävs för att få godkänt, samt med att ladda ner de filer som
behövs.

Koden ni skriver i denna labb kommer senare att användas i Laboration 2.

Börja med att klona repot https://github.com/niklasbroberg/DIT952-lab1, ifall ni
inte redan gjort det i del 1. Annars kan ni ta fram er lösning från lab 1 del 1
och fortsätta därifrån. Notera att om ni inte är klara eller fått godkänt på
del 1 bör ni göra detta först.

== Uppgift a) ==

Skapa en representation av en Scania-lastbil med modellnamn Scania. Ge den rimliga
startvärden för relevanta fält. Lägg den i filen Scania.java i samma mapp.

Scania ska införlivas i er arvs-hierarki från tidigare, men ha ytterligare
funktionalitet: den har ett flak som kan höjas (tippas) och sänkas. Införliva
detta i er design så att vi kan hålla reda på vilken vinkel flaket har för
närvarande, samt funktioner för att höja och sänka det.

Följande förhållanden ska gälla:
- Vinkeln på flaket kan inte vara lägre än 0 eller högre än 70.
- Flaket kan enbart ha en annan vinkel än 0 om lastbilen står stilla.

Lägg allt i Scania.java och skriv Javadoc för klassen och fälten. Gör minst ett
JUnit-test i er Testklass.

== Uppgift b) ==

Skapa en representation av en biltransport - dvs en långtradare som kan
transportera bilar på flaket. Ge den ett valfritt modellnamn och filnamn.

Biltransporten ska på lämpligt sätt införlivas i er arvshierarki från tidigare.
Likt Scania-lastbilen har den ett "flak" i form av en ramp som går att höja och 
sänka. Införliva detta i er design på lämpligt sätt.

Bilar ska kunna lastas på och av biltransporten. Biltransporten har ett maximalt
antal bilar som den kan lasta. Bilar som ska lastas på biltransporten får inte
vara för stora (gör ett eget antagande).

Följande förhållanden ska gälla:
- Biltransportens ramp har endast två lägen, uppe eller nere.
- Rampen kan endast vara nere om biltransporten står stilla.
- Bilar kan endast lastas om rampen är nere, och de befinner sig rimligt nära 
  biltransporten (gör ett eget antagande, de exakta detaljerna är inte viktiga).
- Bilar kan endast lossas om rampen är nere. De bör då hamna rimligt nära 
  biltransporten.
- Bilar kan endast lossas i omvänd ordning från hur de lastades, dvs den sista
  bilen som lastades måste vara först att lossas (first-in-last-out).
- Biltransporten ska inte kunna lasta på sig själv.
- Under det att en bil är lastad på biltransporten ska dess position i världen 
  alltid vara densamma som biltransportens position. 


Viktiga saker att ha i åtanke under den här uppgiften:
- Undvik kodduplicering för funktionalitet som är gemensam för flera olika
  klasser, e.g. lastbil och biltransport.
- Fundera över behovet av polymorfism för olika ändamål.
- Fundera över hur ni bäst håller reda på de bilar som lastats - vilken sorts
  datastruktur är bäst för ändamålet?

Kom ihåg att skriva Javadoc-dokumentation, och JUnit-tester för relevanta
aspekter av er kod.


== VG-uppgift ==

Den här uppgiften behöver endast göras av dem satsar på VG på labb-delen.

(1)

Skapa en representation av en bilfärja - dvs en färja på vilken det går
att lasta bilar. Notera att bilfärjan inte är en bil (doh), men att många
av de metoder vi hittills använt för olika sorters bilar bör gå att applicera
även på färjan. Hur åstadkommer ni bäst detta?

På bilfärjan gäller samma regler som för biltransporten, med undantaget att
bilar lossas i samma ordning som de lastades, dvs den första bilen som lastades
måste vara först att lossas (first-in-first-out).

Viktiga saker att ha i åtanke under den här uppgiften:
- Undvik kodduplicering för funktionalitet som är gemensam för e.g. bilfärjan
  och biltransporten.
- Fundera över behovet av polymorfism

(2)

Använd generiska typer för att skapa en lösning som generaliserar bilar
och bilfärjor men abstraherar bort från domänen fordon. Dvs, designa och
implementera lämpliga abstraktioner för saker som är "transportörer" och
"transporterbara" i allmänhet. Meningen är att dessa ska vara lika
tillämpliga på bilar och bilfärjor som på t ex känguruungar och
kängurumammor. Refaktorisera er bil- och bilfärjekod så att
de blir specifika instanser av koden från denna uppgift.

Viktigt att tänka på:
- En kängurumamma ska inte kunna lasta på en bil i pungen. Samtidigt vill vi
  inte låsa oss i förväg till att hon bara kan bära just känguruungar.
  Designa så att om vi i framtiden implementerar t ex wallabyungar,
  kan dessa lastas i en kängurumamma utan att vi behöver ändra kängurumammans
  implementation (OCP).
- Ni behöver inte implementera kängurus, det var bara ett exempel.

== Extra uppgifter för mer utmaning ==

- Låt bilfärjan ha ett antal olika filer i vilka bilarna kan befinna sig.
  För varje fil gäller att bilarna i den filen enbart kan lastas av i samma 
  ordning som de lastades på (first-in-first-out), men bilar från olika filer
  kan lastas av i olika ordning (även omväxlande mellan filerna).
- Utöka er command line controller till att hantera alla nya element.
- Använd Javas Reflection API för att skriva ut klassnamn, metodnamn och
  namn på fält för objekten i er modell.


== Labbkriterier ==
- Det är absolut förbjudet att dela, kopiera eller använda kod från varandra på
något sätt. Det är däremot accepterat att diskutera uppgifter och lösningar sinsemellan.

- För att få godkänt på labben gör ni muntliga redovisningar. Gruppen gör detta
samtidigt: alla gruppmedlemmar kommer ställas frågor var och en för sig. För att
gruppen ska bli godkänd ska alla gruppmedlemmar kunna svara på frågor.
Så se till att ni hänger med i laborationen; fråga om hjälp ifall ni fastnar.
