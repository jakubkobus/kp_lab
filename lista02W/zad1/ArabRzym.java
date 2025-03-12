public class ArabRzym {
  private static final String[] liczbyRzymskie = {
    "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"
  };

  private static final int[] liczbyArabskie = {
    1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000
  };

  public static int rzym2arab(String rzym) throws ArabRzymException {
    int result = 0;
    int prevValue = 4000;
    int i = 0;

    while (i < rzym.length()) {
      boolean found = false;

      for(int j = liczbyArabskie.length - 1; j >= 0; j--) {
        if(rzym.startsWith(liczbyRzymskie[j], i)) {
          int value = liczbyArabskie[j];

          if(value > prevValue)
            throw new ArabRzymException("nieprawidlowy zapis");
        
          result += value;
          prevValue = value;
          i += liczbyRzymskie[j].length();
          found = true;
          break;
        }
      }

      if(!found)
        throw new ArabRzymException("nieprawidlowy zapis");
    }

    return result;
  }

  public static String arab2rzym(int arab) throws ArabRzymException {
    if(arab < 1 || arab > 3999)
      throw new ArabRzymException("liczba spoza zakresu (1-3999)");

    String result = "";
    for(int i = liczbyArabskie.length - 1; i >= 0; i--)
      while(arab >= liczbyArabskie[i]) {
        result += liczbyRzymskie[i];
        arab -= liczbyArabskie[i];
      }
    
    return result;
  }
}