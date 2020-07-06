38. Napisz program obliczający pole powierzchni koła. Promień koła użytkownik
wprowadza z klawiatury. Program powinien zasygnalizować błędne dane (liczbę
ujemną lub zero) i ponownie zapytac o długośc promienia. Wykorzystaj metodę
Parse klasy float. Oczywiście nie zapomnij o przechwyceniu ewentualnych wyjątków.
39. Napisz program, który pobiera od użytkownika serię liczb różnych od zera (Zero
kończy wprowadzanie danych). Po wprowadzeniu danych program oblicza sumę
liczb wprowadzonych przez użytkownika, najmniejszą oraz największą liczbę. Na
koniec działania wyświetla obliczone wartości. Oczywiście nie zapomnij o
przechwyceniu ewentualnych wyjątków.
40. Napisz program rozwiązujący równanie kwadratowe ax2 + bx + c. Użytkownik musi
podać wartości a, b oraz c. Program musi sprawdzić czy wprowadzone liczby są
cyframi. Jeśli nie użytkownik musi podać wartości do momentu aż będą poprawne.
Korzystając z pętli switch wyznacz pierwiastki równania kwadratowego w zależności
od ilości rozwiązań (Mogą być 2, 1 lub wcale). Postaraj się przygotować klasę i
metodę odpowiedzialną za obliczanie rozwiązania. Klasa powinna zawierać metodę
o następującej sygnaturze (sygnatura do definicja metody składająca się z
modyfikatora dostępu, zwracanego typu, nazwy, oraz przyjmowanych argumentów)

public Solution calculate(int a, int b, int c)