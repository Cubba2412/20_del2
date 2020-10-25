public class FeltListe {

    private FeltListKeyValue tower = new FeltListKeyValue(2, 250);
    private FeltListKeyValue crater = new FeltListKeyValue(3, -100);
    private FeltListKeyValue palaceGates = new FeltListKeyValue(4, 100);
    private FeltListKeyValue coldDesert = new FeltListKeyValue(5, -20);
    private FeltListKeyValue walledCity = new FeltListKeyValue(6, 180);
    private FeltListKeyValue monastery = new FeltListKeyValue(7, 0);
    private FeltListKeyValue blackCave = new FeltListKeyValue(8, -70);
    private FeltListKeyValue hutsInMountain = new FeltListKeyValue(9, 60);
    private FeltListKeyValue werewall = new FeltListKeyValue(10, -80, true);
    private FeltListKeyValue pit = new FeltListKeyValue(11, -50);
    private FeltListKeyValue goldmine = new FeltListKeyValue(12, 650);

    private FeltListKeyValue[] feltListValues = new FeltListKeyValue[11];

    public FeltListe() {
        feltListValues[0] = tower;
        feltListValues[1] = crater;
        feltListValues[2] = palaceGates;
        feltListValues[3] = coldDesert;
        feltListValues[4] = walledCity;
        feltListValues[5] = monastery;
        feltListValues[6] = blackCave;
        feltListValues[7] = hutsInMountain;
        feltListValues[8] = werewall;
        feltListValues[9] = pit;
        feltListValues[10] = goldmine;
    }

    public FeltListKeyValue getVærdi(int feltKey) {
        for (int i = 0; i < feltListValues.length; i++) {
            FeltListKeyValue keyValue = feltListValues[i];
            if (keyValue.getKey() == feltKey) {
                return keyValue;
            }
        }
        return null;
    }
}
