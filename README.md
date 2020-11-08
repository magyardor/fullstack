# Webshop
## Tárgy: Full-stack webprogramozás 
## Készítői: Nádai Zsombor Csaba, Magyar Dorina

Leírás: Egyszerű kis webshop ami különleges és érdekes termékeket kínál az oldal látogatóinak.

## Alkalmazás funkcionális követelményei:

* Regisztrált felhasználó:
  - Amit csinálhat:
    - megtekinthetik a termékeket
    - módosíthatják a regisztrált adatukat
    - beléphetnek
    - vásárolhatnak
    - értékelhetik a vásárolt terméket
  - Amit nem csinálhat:
    - valami
* Nem regisztrált felhasználó:
  - Amit csinálhat:
    - megtekinthetik a termékeket
    - regisztrálhatnak
    - beléphetnek
    - vásárolhatnak
  - Amit nem csinálhat:
    - nem minden funkciót érhetnek el
* Tulajdanos/Admin:
  - Amit csinálhat:
    - módosíthatja az alkalmazást
    - módosíthatja a termékek leírását, nevét ..stb
    - törölhet terméket
    - új terméket adhat hozzá
  - Amit nem csinálhat:
    - adatok nem megfelelő használata
        
## Az alkalmazás nem funkcionális követelményei:

* Az alkalmazásnak átláthatónak és könnyen kezelhetőnek kell lennie.
* Az alkalmazásnak az adatokat biztonságosan kell kezelnie és tárolnia, kiváltképpen az érzékeny hitelesítő adatokat, amelyek az autentikációhoz szükségesek.
* Az alkalmazásnak gyors válaszidejűnek kell lennie.
* Az alkalmazásnak szinte folyamatosan, minimális rendszerleállásokkal kell működnie a problémák elkerülése miatt.
* A rendszer adatbázisának jól szervezettnek kell lennie, a dinamikusságot elősegítve.

## Szakterületi fogalomjegyzék:

* Menüsor:
     - Főoldal: megnyitja a főoldalt, ha rajta vagyunk újra tölti
     - Termékek: az összes terméket tartalmazó oldal
     - Keresés: egy bizonyos termék keresése
     - Kosár: a felhaszáló kosarát jeleníti meg
     - Bejelentkezés: megjelenik a bejelentkezési felület
     - Regisztráció: megjelenik a regisztráció felület
        - Ha már be van jelentkezve: 
             - felhasználó neve: Profil szerkesztése
             - Kijelentkezés: kijelentkezik a felhasznló profiljából
* Termék:
     - Képpel rendelkezik
     - Kosárba tesz: bele teszi a terméket a felhasznéló kosarába
     - Termék véleményezése: 5 * -os értékelési rendszer (csak bejelentkezett felhasználóknak elérhető funkció)
* Kosár:
     - +/-: növeli/csökkenti a termék számát
     - Vásárlás: vásárlási felület megnyitása
* Vásárlás:
     - fizetési mód kiválasztása (csak utánvétel)
     - Tovább: rendelés leadása

## Szerepkörök:

* Regisztrált felhasználó: általános felhasználó, aki termékeket tud megvásárolni és ha be van jelentkezve értékelheti a terméket
* Nem regisztrált felhasználó: általános felhasználó, aki termékeket tud vásárolni, de nem minden funkciót ér el az oldalon (például: termék értékelése)
* Tulajdonos (Admin):  a weboldal funkcióit aktualizálja, moderátori joga van, a termékeket tartja aktuálisan, ha elfogyott vagy már nem elérhető egy termék törli, módosíthatja a termékek nevét, leírását, árát, új terméket adhat hozzá

## Fejlesztői környezet
### Backendhez használt technológiák

* NetBeans 11.3
  - java.version: 1.8.0_242
  - java.vendor: AdoptOpenJDK - Spring-boot REST API
* VisualStudioCode
  - Typescript 4.0.2 - Angular frontend
* MySql WorkBench

## Adatbázis terv (UML)
![Admin](db.png)

## Könyvtárstuktúra:
### Gyökérkönyvtár:

* **backend/spring-boot mappa**
  * **.mvn/wrapper mappák**
    * **MavenWrapperDownloader.java**
    * **maven-wrapper.jar**
    * **maven-wrapper.properties**
  * **src mappa**
    * **main/java/com/fulltack/webshop mappák**
      * **config mappa**
        * **MyDataRestConfig.java**
      * **dao mappa**
        * **CountryRepository.java**
        * **ProductCategoryRepository.java**
        * **ProductRepository.java**
        * **StateRepository.java**
      * **entity mappa**
        * **Country.java**
        * **Product.java**
        * **ProductCategory.java**
        * **State.java**
      * **SpringBootWebshopApplication.java**
  * **resources mappa**
    * **application.properties**
  * **test mappa**
    * **java/com/fullstack mappák**
        * **webshop**
  * **.gitignore**
  * **mvnw**
  * **mvnw.cmd**
  * **pom.xml**
* **Readme.md** *(a verziókövető rendszer (pl. Git) által alkalmazott szöveges fájl, mely arra szolgál, hogy a projekt iránt érdeklődők tájékozódhassanak azokról a fontos információkról, amelyeket a fejlesztők megosztanának velük (például a könyvtárstruktúra részletes leírását, remélem mindenki elolvassa idáig haha))*

## Végpont tervek

### Egyszerű végpontok

### Adatbázisok végpontjai

### Hiba végpontok

### Végpont bemutatása (szekvenciáldiagram)
![Admin](szekvencial.png)

