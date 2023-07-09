# Waits
Kullanilabilecek 3 adet wait vardir

## 1.  Thread.sleep()
Bu sleep java'ya aittir. Bir element olusumu ya da elementin durumu icin bekleme degil
javanin isleminin belirli bir süre durdurulmasidir. Otomasyonda bu bekleme mümkün oldugunca
kullanilmamalidir.


## 2. Implicit Wait
1. Selenium'un driver.findElement ile aranan element olusuncaya kadar ki beklemesidir.
2. driver'a aittir, driver'da belirtilir. Asagidaki sekilde tanimlanir.

>driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

3. Element olusuncaya kadar (**presence**) en fazla 20sn (Duration'da belirtilen süre) bekler.
4. Bu süre icinde her 500 milisn de bir elementi arar,
    1. elementi bulur ise hata vermeden devam eder.
    2. 20 sn icinde elementi bulamaz ise hata verir.
5. Verilen 20sn, max bekleme süresidir.

> WebDriverManager.chromedriver().setup;
>
> WebDriver driver = new ChromeDriver();
>
> driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

# Explicit Wait

1. Elemente özel durumlar icin bekleme süresidir
2. Ayri bir sekilde ``WebDriverWait wait;`` olarak tanimlanir
3. Elementin istenilen durumu, sayilari, attribute'una göre bekleme icin kullanilir.
4. WebElement ya da locator (By) ile kullanilir
5. Elementin asagidaki örnek durumlarinin beklemesi icin kullanilir
    1. visibility
    2. clickablity
    3. attribute
    4. invisibility
    5. presence
    6. elements size
    7. ....
6. Tanimlama

   ```
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("id")));
   element.click();
   ```

8. Explicit wait Örnekleri
   ```
   ExpectedConditions.presenceOfElementLocated();
   ExpectedConditions.presenceOfAllElementsLocatedBy();
   ExpectedConditions.visibilityOf();
   ExpectedConditions.visibilityOfAllElementsLocatedBy();
   ExpectedConditions.visibilityOfAllElements();
   ExpectedConditions.elementToBeClickable();
   ExpectedConditions.elementToBeClickable();
   ExpectedConditions.invisibilityOfElementLocated();
   ExpectedConditions.invisibilityOf();
   ExpectedConditions.alertIsPresent();
   ExpectedConditions.attributeContains();
   ExpectedConditions.attributeContains();
   ExpectedConditions.attributeToBe();
   ExpectedConditions.attributeToBe();
   ExpectedConditions.elementToBeSelected();
   ExpectedConditions.elementToBeSelected();
   ExpectedConditions.numberOfElementsToBe();
   ExpectedConditions.numberOfElementsToBeLessThan();
   ExpectedConditions.numberOfElementsToBeMoreThan();
   ExpectedConditions.numberOfWindowsToBe();
   ExpectedConditions.titleIs();
   ExpectedConditions.attributeToBeNotEmpty();
   ExpectedConditions.invisibilityOfElementWithText();
   ExpectedConditions.textMatches();
   ExpectedConditions.textToBe();
   ExpectedConditions.textToBePresentInElement();
   ExpectedConditions.textToBePresentInElementLocated();
   ExpectedConditions.titleContains();
   ```

9. Hem Implicit wait hem de Explicit waitin ayni anda kullanilmasi önerilmez. Bu kullanim bekleme süresinin gereksiz uzamasina neden olabilir.
```
wait.Until(ExpectedConditions.presenceOfElementLocated(By))  -> Implicitly wait gibi
wait.Until(ExpectedConditions.presenceOfElement(WebElement)) -> Implicitly wait gibi
```


### ExplicitWait örnek
Asagidaki iki click() methodu ayni islemi yapar

```java
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
```

```java
    private void click(By locator){
        wait.until(driver -> {
            try {
                driver.findElement(locator).click();
                return true;
            }catch (Exception e){
                return false;
            }
        });
    }
```
1. ``wait.until();`` icindeki ``ExpectedConditiond`` sonucta ``true`` ya da ``false`` return eden bir predicate'dir.
2. Ilk click() methodunda ``ExpectedConditions``kullanilmistir.
2. Ikinci click() methodunda ``lambda`` methodu icinde ``try-catch`` kullanilmis, ``driver.findElement`` true return edene kadar belirlenen sürece bu islem denenmeye devam edilecektir.